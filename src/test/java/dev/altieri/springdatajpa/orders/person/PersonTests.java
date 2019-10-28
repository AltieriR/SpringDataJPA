package dev.altieri.springdatajpa.orders.person;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dev.altieri.springdatajpa.orders.endpoint.CustomerController;
import dev.altieri.springdatajpa.orders.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonTests {

	@Autowired
	private CustomerRepository customerDao;

    @Autowired
	private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController(customerDao)).build();
    }
    
    @Test
    public void shouldReturn200() throws Exception {
        this.mockMvc.perform(get("/customer")).andExpect(status().isOk());
    }
}
