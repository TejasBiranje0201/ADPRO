package com.adpro.service;

import java.util.List;

import com.adpro.entity.Client;

public interface ClientService {
	
	List<Client> list();
	
	Client save(Client client);
	
	Client getById(int id);
	
	void deleteById(int id);

}
