package br.com.gustavoakira.master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavoakira.master.model.Client;
import br.com.gustavoakira.master.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	@Transactional
	public List<Client> getAll(){
		return repository.findAll();
	}
	@Transactional
	public Client findById(Long id){
		Optional<Client>optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	@Transactional
	public Client save(Client client) {
		if(client.getTelephone() != null) {
			for(int pos=0;pos<client.getTelephone().size(); pos++){
				client.getTelephone().get(pos).setClient(client);
			}
		}
		return repository.save(client);
	}
	@Transactional
	public String deleteById(Long id) {
		if(findById(id)!= null) {
			repository.deleteById(id);
		}
		return "ok";
	}
}
