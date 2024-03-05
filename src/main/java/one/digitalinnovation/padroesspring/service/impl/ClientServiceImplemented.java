package one.digitalinnovation.padroesspring.service.impl;

import one.digitalinnovation.padroesspring.model.Address;
import one.digitalinnovation.padroesspring.model.Client;
import one.digitalinnovation.padroesspring.repository.AddressRepository;
import one.digitalinnovation.padroesspring.repository.ClientRepository;
import one.digitalinnovation.padroesspring.service.ClientService;
import one.digitalinnovation.padroesspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplemented implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {

        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        SaveClientWithCep(client);

    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientBd = clientRepository.findById(id);
        if (clientBd.isPresent()) {
            SaveClientWithCep(client);
        }

    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void SaveClientWithCep(Client client) {
        var cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultarCep(cep);
            return addressRepository.save(newAddress);
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
