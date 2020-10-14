package br.com.gustavoakira.master.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gustavoakira.master.model.Telephone;

@SpringBootTest
class TelephoneServiceTest {
	
	@Autowired
	private TelephoneService service;
	
	//@Test
	void save() {
		Telephone telephone = new Telephone();
		telephone.setNumber("954506404");
		telephone.setRegion("11");
		telephone.setClient(null);
		telephone = service.save(telephone, null);
		System.out.print(telephone);
		assertNotEquals(null, telephone);
	}
	
	@Test
	void getAll() {
		List<Telephone> telephones = service.getAll();
		assertNotEquals(null, telephones);
	}
	
	@Test
	void getOne() {
		Telephone telephone = service.findById(5L);
		assertNotEquals(null,telephone);
	}
	
	@Test
	void getOneError() {
		Telephone telephone = service.findById(30L);
		assertEquals(null,telephone);
	}
	
	@Test
	void delete() {
		service.deleteById(6L);
		Telephone telephone = service.findById(6L);
		assertEquals(null,telephone);
	}
}
