package br.com.gustavoakira.master.controller;

import java.util.List;

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

import br.com.gustavoakira.master.model.Party;
import br.com.gustavoakira.master.service.PartyService;

@RestController
public class PartyController {
	@Autowired
	private PartyService service;
	
	@GetMapping("/parties")
	public ResponseEntity<List<Party>> getParties(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/party/{id}")
	public ResponseEntity<Party> getOne(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping("/party/address/{id}")
	public ResponseEntity<Party> save(@PathVariable Long id, @RequestBody Party party){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(party,id));
	}
	
	@PutMapping("/party/{id}")
	public ResponseEntity<Party> update(@PathVariable Long id, @RequestBody Party party){
		party.setId(id);
		service.save(party, null);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/party/{id}/adress/{addressId}")
	public ResponseEntity<Party> updateAddress(@PathVariable("id") Long id, @PathVariable("addressId") Long addressId) {
		service.updateAddress(id, addressId);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/party/id")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return ResponseEntity.ok(service.deleteById(id));
	}
}
