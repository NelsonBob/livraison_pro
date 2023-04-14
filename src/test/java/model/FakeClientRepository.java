package model.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FakeClientRepository implements ClientRepository {

    private final List<Client> clients = new ArrayList<>();

    public FakeClientRepository() {
        clients.add(Client.builder()
                .id("123")
                .nom("Kill")
                .prenom("John")
                .address("4 av. London, London")
                .email("john@gmail.com")
                .telephone("0632221123")
                .build());
        clients.add(Client.builder()
                .id("345")
                .nom("Dong")
                .prenom("Hang")
                .address("99 rue de Nantes, Paris")
                .email("hang@gmail.com")
                .telephone("0632998923")
                .build());
        clients.add(Client.builder()
                .id("678")
                .nom("Fomekong")
                .prenom("Nelson")
                .address("238 av. Fantas, France")
                .email("nelson@gmail.com")
                .telephone("0632229003")
                .build());
    }

    @Override
    public List<Client> findAll() {
        return clients.stream().map(Client::new).collect(toList());
    }

}
