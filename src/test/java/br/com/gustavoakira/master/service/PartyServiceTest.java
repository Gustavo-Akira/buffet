package br.com.gustavoakira.master.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gustavoakira.master.model.Party;

@SpringBootTest
class PartyServiceTest {
	
	@Autowired
	PartyService partyService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	AddressService addressService;
	
	@Test
	void save() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2020");
		Party party = new Party();
		party.setAddress(addressService.getOne(3L));
		party.setClient(clientService.findById(10L));
		party.setDate(date);
		party.setName("Birthday");
		party.setInitHour(Time.valueOf("11:11:11"));
		party.setEndHour(Time.valueOf("23:11:11"));
		party.setTheme("Birthday");
		party = partyService.save(party,2L);
		assertNotEquals(null, party.getId());
	}
	@Test
	void getAll() {
		List<Party> party = partyService.getAll();
		party.stream().forEach(x->System.out.println(x));
		assertNotEquals(null,party);
	}
	@Test
	void getOne() {
		Party party = partyService.findById(11L);
		assertNotEquals(null,party);
	}
	
	@Test
	void remove() {
		String ok = partyService.deleteById(12L);
		assertEquals("ok", ok);
	}
}
