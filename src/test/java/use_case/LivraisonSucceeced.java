import org.junit.Assert;
import org.junit.Test;

public class LivraisonSucceecedTest {


    @BeforeEach
    void setUp() {
        Clients = new FakeClientsRepository();
        Colis = new FakeColisRepository();

    }

    @Test
    public void testColisDelivery() {
        // Arrange
        String colisId = "123456";
        String sender = "John";
        String recipient = "Alice";
        ColisAggregate colis = new ColisAggregate(colisId, sender, recipient);

        // Act
        colis.markAsDelivered();

        // Assert
        Assert.assertTrue(colis.isDelivered());
        Assert.assertEquals(1, colis.getDeliveryEvents().size());
        Assert.assertEquals("Delivered", colis.getDeliveryEvents().get(0).getEvent());
    }
}
