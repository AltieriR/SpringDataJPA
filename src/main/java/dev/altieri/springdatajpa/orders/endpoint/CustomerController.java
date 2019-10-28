package dev.altieri.springdatajpa.orders.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.altieri.springdatajpa.orders.model.Person;
import dev.altieri.springdatajpa.orders.repository.CustomerRepository;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	private static CustomerRepository customerDao;

	@Autowired	
	public CustomerController(CustomerRepository customerDao) {
		this.customerDao = customerDao;
	}

	@GetMapping
	public List<Person> getAllUsers() {
		return customerDao.findAll();
	}

	@GetMapping(path="/{name}")
	public List<Person> getCustomersByName(@PathVariable("name") String n) {
		return customerDao.findCustomerByName(n);
	}
	
	public static Person teste() {
		/*LegalPerson legalPerson = new LegalPerson();
		legalPerson.setLegalEntityIdentifier("FSDFNBOI32");
		customerDao.save(legalPerson);
		return legalPerson;*/
		return null;
	}
}
