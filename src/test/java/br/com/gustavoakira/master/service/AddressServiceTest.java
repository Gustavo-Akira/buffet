package br.com.gustavoakira.master.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

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
	
	@Test
	void getAll() {
		List<Address> all = addressService.getAll();
		assertNotEquals(null, all);
	}
	
	@Test
	void getOne() {
		Address one = null;
		Long x = 0L;
		while(one == null) {
			x +=1L;
			one = addressService.getOne(x);
		}
		assertNotEquals(null,one);
	}
	
	@Test
	void getOneError() {
		Address one = addressService.getOne(30L);
		assertEquals(null, one);
	}
	
	@Test
	void delete() {
		Long x= 3L;
		while(addressService.getOne(x) == null) {
			x +=1L;
		}
		String ok  =addressService.deleteById(x);
		assertEquals("ok",ok);
	}
}
