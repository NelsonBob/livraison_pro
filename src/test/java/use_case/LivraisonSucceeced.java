import org.junit.Assert;
import org.junit.Test;
import com.example.livraison.use_case.LivraisonColis;

public class LivraisonSucceecedTest {
    private LivraisonAggretate livraisonAggretate;
    private Sender sender;
    private Recipient recipient;


    @BeforeEach
    void setUp() {
        client = new client("999", "Dong", "Hang");
        colis = new Colis("111", "35.6",'999');
        livreur = new Liveur();
        sender = new Sender("Lucas", "39 av. lizton, German");
        recipient = new Recipient("Nelson", "4 av. London, London");
        livraisonAggretate = new LivraisonAggretate("123",client, colis, livreur, sender, recipient);
    }

    @Test
    void testMarkAsDelivered() {
        livraisonAggretate.markAsDelivered();

        assertEquals(DeliveryStatus.DELIVERED, livraisonAggretate.getDeliveryStatus());
        assertNotNull(livraisonAggretate.getDeliveryTime());
        assertEquals(1, livraisonAggretate.getDeliveryEvents().size());

        // Verify that the DeliveryEvent was added to the list
        DeliveryEvent deliveryEvent = livraisonAggretate.getDeliveryEvents().get(0);
        assertEquals("livraisonId", deliveryEvent.getLivraisonId());
        assertEquals("Delivered", deliveryEvent.getEvent());
    }

    @Test
    void testMarkAsFailed() {
        livraisonAggretate.markAsFailed();

        assertEquals(DeliveryStatus.FAILED, livraisonAggretate.getDeliveryStatus());
        assertNotNull(livraisonAggretate.getDeliveryTime());
        assertEquals(1, livraisonAggretate.getDeliveryEvents().size());

        // Verify that the DeliveryEvent was added to the list
        DeliveryEvent deliveryEvent = livraisonAggretate.getDeliveryEvents().get(0);
        assertEquals("livraisonId", deliveryEvent.getLivraisonId());
        assertEquals("Failed", deliveryEvent.getEvent());
    }

    @Test
    void testMarkAsDelivered_WhenAlreadyDelivered() {
        // Mark the colis as delivered
        livraisonAggretate.markAsDelivered();

        // Reset the delivery events
        livraisonAggretate.getDeliveryEvents().clear();

        // Attempt to mark as delivered again
        livraisonAggretate.markAsDelivered();

        // Verify that the delivery status, delivery time, and delivery events are not changed
        assertEquals(DeliveryStatus.DELIVERED, livraisonAggretate.getDeliveryStatus());
        assertNotNull(livraisonAggretate.getDeliveryTime());
        assertEquals(0, livraisonAggretate.getDeliveryEvents().size());
    }

    @Test
    void testMarkAsFailed_WhenAlreadyFailed() {
        // Mark the colis as failed
        livraisonAggretate.markAsFailed();

        // Reset the delivery events
        livraisonAggretate.getDeliveryEvents().clear();

        // Attempt to mark as failed again
        livraisonAggretate.markAsFailed();

        // Verify that the delivery status, delivery time, and delivery events are not changed
        assertEquals(DeliveryStatus.FAILED, livraisonAggretate.getDeliveryStatus());
        assertNotNull(livraisonAggretate.getDeliveryTime());
        assertEquals(0, livraisonAggretate.getDeliveryEvents().size());
    }




}
