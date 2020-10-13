package br.com.gustavoakira.master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoakira.master.model.Client;
import br.com.gustavoakira.master.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> getAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id){
		Optional<Client>optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public Client save(Client client) {
		return repository.save(client);
	}
	
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "ok";
	}
}
