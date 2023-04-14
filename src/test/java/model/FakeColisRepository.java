package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FakeColisRepository implements ColisRepository {

    private final List<Colis> colisALivrer = new ArrayList<>();
    private final List<Colis> colisLivre = new ArrayList<>();

    public FakeColisRepository() {
        colisALivrer.add(Colis.builder()
                .id("123")
                .originAddress("4 av. London, London")
                .destinationAddress("39 av. lizton, German")
                .weight("30.5")
                .code("444789")
                .clientId("123")
                .isDelivered("false")
                .build());
        colisALivrer.add(Colis.builder()
                .id("234")
                .originAddress("99 rue de Nantes, Paris")
                .destinationAddress("238 av. Fantas, France")
                .weight("200.5")
                .code("444900")
                .clientId("345")
                .isDelivered("false")
                .build());
        colisLivre.add(Colis.builder()
                .id("345")
                .originAddress("4 av. London, London")
                .destinationAddress("39 av. lizton, German")
                .weight("30.5")
                .code("444789")
                .weight("30.5")
                .clientId("123")
                .isDelivered("true")
                .build());

    }

    @Override
    public List<Colis> findAll() {
        return colisALivrer.stream().map(Colis::new).collect(toList());
    }

    @Override
    public List<Colis> findAll() {
        return colisLivre.stream().map(Colis::new).collect(toList());
    }

}
