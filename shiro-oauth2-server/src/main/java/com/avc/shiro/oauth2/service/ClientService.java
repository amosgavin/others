package com.avc.shiro.oauth2.service;

import com.avc.shiro.oauth2.entity.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long clientId);

    Client findOne(Long clientId);

    List<Client> findAll();

    Client findByClientId(String clientId);

    Client findByClientSecret(String clientSecret);
}
