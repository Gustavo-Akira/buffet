package br.com.gustavoakira.master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gustavoakira.master.model.Party;
import br.com.gustavoakira.master.repository.PartyRepository;

@Service
public class PartyService {
	private PartyRepository repository;
	
	public List<Party> getAll(){
		return repository.findAll(); 
	}
	
	public Party findById(Long id) {
		Optional<Party>optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public Party save(Party party) {
		return repository.save(party);
	}
	
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "ok";
	}
}
