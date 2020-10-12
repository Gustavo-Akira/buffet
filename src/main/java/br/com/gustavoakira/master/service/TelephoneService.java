package br.com.gustavoakira.master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoakira.master.model.Telephone;
import br.com.gustavoakira.master.repository.TelephoneRepository;

@Service
public class TelephoneService {
	
	@Autowired
	private TelephoneRepository telephoneRepository;
	
	public List<Telephone> getAll(){
		return telephoneRepository.findAll();
	}
	
	public Telephone findById(Long id) {
		Optional<Telephone>optional = telephoneRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public Telephone save(Telephone telephone) {
		return telephoneRepository.save(telephone);
	}
	
	public String deleteById(Long id) {
		telephoneRepository.deleteById(id);
		return "ok";
	}
}
