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

import br.com.gustavoakira.master.model.Client;
import br.com.gustavoakira.master.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping("/client")
	public ResponseEntity<Client> save(@RequestBody Client client){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(client));
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody Client client){
		client.setId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.save(client));
	}
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteById(id));
	}
	
	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
}
