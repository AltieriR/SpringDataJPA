package dev.altieri.springdatajpa.orders.integration;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dev.altieri.springdatajpa.orders.endpoint.CustomerController;
import dev.altieri.springdatajpa.orders.model.LegalPerson;
import dev.altieri.springdatajpa.orders.model.Person;
import dev.altieri.springdatajpa.orders.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@EnableWebMvc
//@AutoConfigureMockMvc
public class PersonTests {

	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerController customerController;

	private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
    	MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        this.mockMvc.perform(get("/customer")).andExpect(status().isOk());
    }
    
    @Test
    public void shouldListAll() throws Exception {/*
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer").accept(MediaType.APPLICATION_JSON))
    	.andExpect(MockMvcResultMatchers.status().isOk())
		//.andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty())
		.andReturn();
    	int content = result.getResponse().getStatus(); //getContentAsString
    	int contents = result.getResponse().getContentLength();
    	System.out.println("=-=-=-=");
    	System.out.println(contents);*/
    	LegalPerson person = new LegalPerson();
    	person.setName("alt");
    	person.setLegalEntityIdentifier("4534FSF3");
    	List<Person> l = new ArrayList<Person>();
    	l.add(person);
    	l = customerRepository.findAll();
    	Mockito.when(customerRepository.findAll()).thenReturn(l);
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer")).andReturn();
    	System.out.println("=-=- " +result.getResponse().getContentAsString() +" =-=");
    	System.out.println("=-=- " +result.getResponse().getContentAsString() +" =-=");
    }
}
