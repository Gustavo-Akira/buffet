package br.com.gustavoakira.master.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gustavoakira.master.model.Address;

@SpringBootTest
class AddressServiceTest {
	@Autowired
	AddressService addressService;
	
	@Test
	void save() {
		Address address = new Address();
		address.setCity("Mogi das Cruzes");
		address.setState("SP");
		address.setStreet("Maria Antonieta");
		address = addressService.save(address);
		System.out.println(address);
		assertNotEquals(null, address);
	}
}
