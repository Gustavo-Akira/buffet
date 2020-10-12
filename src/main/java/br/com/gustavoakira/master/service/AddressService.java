package br.com.gustavoakira.master.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoakira.master.model.Address;
import br.com.gustavoakira.master.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired 
	private AddressRepository addressRepository;
	
	public List<Address> getAll(){
		return addressRepository.findAll();
	}
	
	public Address getOne(Long id) {
		return addressRepository.getOne(id);
	}
	
	public Address save(Address address) {
		return addressRepository.save(address);
	}
	
	public String deleteById(Long id) {
		addressRepository.deleteById(id);
		return "ok";
	}
}
