package use_case;

import com.esgi.livraisonfinal.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LivraisonSucceecedTest {
    private LivraisonAggregate livraisonAggregate;
    private Sender sender;
    private Recipient recipient;

    public LivraisonSucceecedTest(LivraisonAggregate livraisonAggregate) {
        this.livraisonAggregate = livraisonAggregate;
    }


    @BeforeEach
    void setUp() {
        Client client = new Client("999", "Dong", "Hang","mymail","0123456789");
        Colis colis = new Colis("111", 35.6,"999");
        Livreur livreur = new Livreur("998", "test", "test","mymail","0123456789");
        sender = new Sender("Lucas", "39 av. lizton, German");
        recipient = new Recipient("Nelson", "4 av. London, London");
        LivraisonAggregate livraisonAggregate1 = new LivraisonAggregate("123",client, colis, livreur, sender, recipient);
    }

    @Test
    void testMarkAsDelivered() {

        LivraisonAggregate.markAsDelivered();

        assertEquals(DeliveryStatus.DELIVERED, LivraisonAggregate.getDeliveryStatus());
        assertNotNull(LivraisonAggregate.getDeliveryTime());
        assertEquals(1, LivraisonAggregate.getDeliveryEvents().size());

        // Verify that the DeliveryEvent was added to the list
        DeliveryEvent deliveryEvent = LivraisonAggregate.getDeliveryEvents().get(0);
        assertEquals("livraisonId", deliveryEvent.getLivraisonId());
        assertEquals("Delivered", deliveryEvent.getEvent());
    }

    @Test
    void testMarkAsFailed() {
        LivraisonAggregate.markAsFailed();

        assertEquals(DeliveryStatus.FAILED, LivraisonAggregate.getDeliveryStatus());
        assertNotNull(LivraisonAggregate.getDeliveryTime());
        assertEquals(1, LivraisonAggregate.getDeliveryEvents().size());

        // Verify that the DeliveryEvent was added to the list
        DeliveryEvent deliveryEvent = LivraisonAggregate.getDeliveryEvents().get(0);
        assertEquals("livraisonId", deliveryEvent.getLivraisonId());
        assertEquals("Failed", deliveryEvent.getEvent());
    }

    @Test
    void testMarkAsDelivered_WhenAlreadyDelivered() {
        // Mark the colis as delivered
        LivraisonAggregate.markAsDelivered();

        // Reset the delivery events
        LivraisonAggregate.getDeliveryEvents().clear();

        // Attempt to mark as delivered again
        LivraisonAggregate.markAsDelivered();

        // Verify that the delivery status, delivery time, and delivery events are not changed
        assertEquals(DeliveryStatus.DELIVERED, LivraisonAggregate.getDeliveryStatus());
        assertNotNull(LivraisonAggregate.getDeliveryTime());
        assertEquals(0, LivraisonAggregate.getDeliveryEvents().size());
    }

    @Test
    void testMarkAsFailed_WhenAlreadyFailed() {
        // Mark the colis as failed
        LivraisonAggregate.markAsFailed();

        // Reset the delivery events
        LivraisonAggregate.getDeliveryEvents().clear();

        // Attempt to mark as failed again
        LivraisonAggregate.markAsFailed();

        // Verify that the delivery status, delivery time, and delivery events are not changed
        assertEquals(DeliveryStatus.FAILED, LivraisonAggregate.getDeliveryStatus());
        assertNotNull(LivraisonAggregate.getDeliveryTime());
        assertEquals(0, LivraisonAggregate.getDeliveryEvents().size());
    }




}
