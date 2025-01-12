package br.com.escriba.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.escriba.App;


@SpringBootTest(classes = App.class)
@WebAppConfiguration
class ProductControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
    void listByCategoryAlimentos() throws Exception {
        mockMvc.perform(get("/product/listByCategory/1"))
        .andExpect(status().isOk())
	    		.andExpect(jsonPath("$", hasSize(2)))
	        .andExpect(jsonPath("$[0].id", is(1)))
	        .andExpect(jsonPath("$[0].name", is("Arroz")))
	        .andExpect(jsonPath("$[1].id", is(2)))
	        .andExpect(jsonPath("$[1].name", is("Feijão")));
    }

	@Test
	void listByCategoryEletrodomesticos() throws Exception {
		mockMvc.perform(get("/product/listByCategory/2"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[0].id", is(3)))
		.andExpect(jsonPath("$[0].name", is("Aspirador de pó")))
		.andExpect(jsonPath("$[1].id", is(4)))
		.andExpect(jsonPath("$[1].name", is("Batedeira")))
		.andExpect(jsonPath("$[2].id", is(5)))
		.andExpect(jsonPath("$[2].name", is("Liquidificador")));
	}

	@Test
	void listByCategoryMoveis() throws Exception {
		mockMvc.perform(get("/product/listByCategory/3"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[0].id", is(6)))
		.andExpect(jsonPath("$[0].name", is("Sofá")))
		.andExpect(jsonPath("$[1].id", is(7)))
		.andExpect(jsonPath("$[1].name", is("Mesa")))
		.andExpect(jsonPath("$[2].id", is(8)))
		.andExpect(jsonPath("$[2].name", is("Estante")));
	}
}
