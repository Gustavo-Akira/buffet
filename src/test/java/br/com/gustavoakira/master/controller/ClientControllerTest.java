package br.com.gustavoakira.master.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
	
	//@Test
	void getAll() throws Exception {
		mockMvc.perform(get("/clients").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	//@Test
	void save() throws Exception {
		String json = mapper.writeValueAsString(getValidClient());
		mockMvc.perform(
			post("/client")
			.contentType(MediaType.APPLICATION_JSON)
			.content(json)
			.accept(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated());
	}
	
	//@Test
	void update() throws Exception {
		Client client  = getValidClient();
		client.setName("Souzones");
		String json = mapper.writeValueAsString(client);
		mockMvc.perform(put("/client/{id}",10L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
			).andExpect(status().isNoContent());
	}
	
	//@Test
	void remove() throws Exception {
		mockMvc.perform(delete("/client/{id}",1L).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
	}
	@Test
	void getOne() throws Exception {
		mockMvc.perform(get("/client/{id}",10L)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	Client getValidClient() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2019");
		Client client = new Client();
		client.setName("Gustavo Akira");
		client.setDateOfEnroll(date);
		return client;
	}
}
