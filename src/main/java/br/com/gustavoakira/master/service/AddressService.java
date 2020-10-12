package br.com.gustavoakira.master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavoakira.master.model.Address;
import br.com.gustavoakira.master.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired 
	private AddressRepository addressRepository;
	
	@Transactional(readOnly = true)
	public List<Address> getAll(){
		return addressRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Address getOne(Long id) {
		Optional<Address> optional = addressRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
		
	}
	
	@Transactional
	public Address save(Address address) {
		return addressRepository.save(address);
	}
	
	public String deleteById(Long id) {
		addressRepository.deleteById(id);
		return "ok";
	}
}
