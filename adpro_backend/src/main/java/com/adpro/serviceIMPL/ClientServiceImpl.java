package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Client;
import com.adpro.repository.ClientRepository;
import com.adpro.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public List<Client> list() {
		
		return clientRepository.findAll();
	}

	@Override
	public Client save(Client client) {
		
		return clientRepository.save(client);
	}

	@Override
	public Client getById(int id) {
		
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		
		clientRepository.deleteById(id);
	}

}
