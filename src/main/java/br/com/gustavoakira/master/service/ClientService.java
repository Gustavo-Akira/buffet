package br.com.gustavoakira.master.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gustavoakira.master.model.Client;
import br.com.gustavoakira.master.repository.ClientRepository;

@Service
public class ClientService {
	private ClientRepository repository;
	
	public List<Client> getAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id){
		return repository.getOne(id);
	}
	
	public Client save(Client client) {
		return repository.save(client);
	}
	
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "ok";
	}
}
