package br.com.gustavoakira.master.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gustavoakira.master.model.Client;

@SpringBootTest
class ClientServiceTest {
	@Autowired
	ClientService clientService;
	
	//@Test
	void save() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2019");
		Client client = new Client();
		client.setName("Gustavo Akira");
		client.setDateOfEnroll(date);
		clientService.save(client);
	}
	
	@Test
	void getAll() {
		List<Client> client = clientService.getAll();
		client.stream().forEach(System.out::println);
		assertNotEquals(null, client);
	}
}
