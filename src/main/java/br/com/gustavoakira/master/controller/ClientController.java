package br.com.gustavoakira.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
