package com.elvissilva.defaultprojectspring.service;

import com.elvissilva.defaultprojectspring.model.Client;

public interface IClientService {

    Iterable<Client> findAll();

    Client findForId(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
