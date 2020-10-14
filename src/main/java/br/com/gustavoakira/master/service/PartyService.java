package br.com.gustavoakira.master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoakira.master.model.Party;
import br.com.gustavoakira.master.repository.PartyRepository;

@Service
public class PartyService {
	@Autowired
	private PartyRepository repository;
	
	@Autowired 
	private AddressService addressService;
	
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
	
	public Party save(Party party, Long id) {
		if(party.getAddress() == null) {
			party.setAddress(addressService.getOne(id));
		}
		return repository.save(party);
	}
	
	public String deleteById(Long id) {
		if(findById(id)!= null) {
			repository.deleteById(id);
		}
		return "ok";
	}

	public void updateAddress(Long id, Long addressId) {
		findById(id).setAddress(addressService.getOne(addressId));
	}
}
