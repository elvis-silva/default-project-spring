package com.elvissilva.defaultprojectspring.service.impl;

import com.elvissilva.defaultprojectspring.model.Address;
import com.elvissilva.defaultprojectspring.model.Client;
import com.elvissilva.defaultprojectspring.model.IAddressRepository;
import com.elvissilva.defaultprojectspring.model.IClientRepository;
import com.elvissilva.defaultprojectspring.service.IClientService;
import com.elvissilva.defaultprojectspring.service.IViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;
    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    private IViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findForId(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clienteBd = clientRepository.findById(id);
        if (clienteBd.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep)
                .orElseGet(() -> {
                    Address newAddress = viaCepService.consultCep(cep);
                    addressRepository.save(newAddress);
                    return newAddress;
                });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
