package br.com.gustavoakira.master.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavoakira.master.model.Client;
import br.com.gustavoakira.master.service.ClientService;

@WebMvcTest(ClientController.class)
class ClientControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ClientService service;
	
	@Autowired
	ObjectMapper mapper;
	
	@Test
	void getAll() throws Exception {
		mockMvc.perform(get("/clients").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	@Test
	void save() throws Exception {
		String json = mapper.writeValueAsString(getValidClient());
		mockMvc.perform(
			post("/client")
			.contentType(MediaType.APPLICATION_JSON)
			.content(json)
			.accept(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated());
	}
	
	Client getValidClient() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2019");
		Client client = new Client();
		client.setName("Gustavo Akira");
		client.setDateOfEnroll(date);
		return client;
	}
}
