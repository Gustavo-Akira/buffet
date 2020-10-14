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

import br.com.gustavoakira.master.model.Telephone;
import br.com.gustavoakira.master.service.TelephoneService;

@RestController
public class TelephoneController {
	
	@Autowired
	private TelephoneService service;
	
	@GetMapping("/telephone/{id}")
	public ResponseEntity<Telephone> getOne(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/telephone/client/{id}")
	public ResponseEntity<List<Telephone>> getTelephonesByClients(@PathVariable("id")Long id){
		return ResponseEntity.ok(service.getByClient(id));
	}
	
	@PostMapping("/telephone/client/{id}")
	public ResponseEntity<Telephone> save(@PathVariable("id") Long id,@RequestBody Telephone telephone){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(telephone,id));
	}
	
	@PutMapping("telephone/{id}")
	public ResponseEntity<Telephone> update(@PathVariable Long id,@RequestBody Telephone telephone){
		telephone.setId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.save(telephone, null));
	}
	
	@DeleteMapping("telehpne/{id}")
	public ResponseEntity<String>  delete(@PathVariable("id")Long id){
		return ResponseEntity.ok(service.deleteById(id));
	}
}
