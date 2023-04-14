package com.esgi.livraisonfinal.infrastructure;

import com.esgi.livraisonfinal.domain.Client;
import com.esgi.livraisonfinal.use_cases.exeption.ClientNotFoundException;

import java.util.ArrayList;
import java.util.List;
public class ClientRepository {

    private List<Client> clients = new ArrayList<>();


    public void saveClient(Client client) {
        clients.add(client);
    }

    public Client getClientById(String id) throws ClientNotFoundException {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        throw new ClientNotFoundException("Client with ID " + id + " not found.");
    }
}
