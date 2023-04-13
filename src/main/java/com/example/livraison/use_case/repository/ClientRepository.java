package com.example.livraison.use_case.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.livraison.model.Client;
import com.example.livraison.use_case.exeption.ClientNotFoundException;

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
