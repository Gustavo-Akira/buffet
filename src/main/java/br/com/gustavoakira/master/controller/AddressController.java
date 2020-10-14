package br.com.gustavoakira.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoakira.master.model.Address;
import br.com.gustavoakira.master.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping("/address/party/{id}")
	public ResponseEntity<Address> saveByParty(@RequestBody Address address){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(address));
	}
	
	@GetMapping("/address/party/{id}")
	public ResponseEntity<Address> getByParty(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.getByParty(id));
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/address/{id}")
	public ResponseEntity update(@PathVariable Long id,@RequestBody Address address){
		address.setId(id);
		service.save(address);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/address/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return ResponseEntity.ok(service.deleteById(id));
	}
}
