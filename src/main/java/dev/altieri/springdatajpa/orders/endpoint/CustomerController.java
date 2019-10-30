package dev.altieri.springdatajpa.orders.endpoint;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.altieri.springdatajpa.orders.model.LegalPerson;
import dev.altieri.springdatajpa.orders.model.NaturalPerson;
import dev.altieri.springdatajpa.orders.model.Order;
import dev.altieri.springdatajpa.orders.model.OrderProduct;
import dev.altieri.springdatajpa.orders.model.Person;
import dev.altieri.springdatajpa.orders.model.Product;
import dev.altieri.springdatajpa.orders.repository.CustomerRepository;
import dev.altieri.springdatajpa.orders.repository.LegalPersonRepository;
import dev.altieri.springdatajpa.orders.repository.NaturalPersonRepository;
import dev.altieri.springdatajpa.orders.repository.OrderProductRepository;
import dev.altieri.springdatajpa.orders.repository.OrderRepository;
import dev.altieri.springdatajpa.orders.repository.ProductRepository;

@RestController
@RequestMapping(path = "customer")
public class CustomerController {
	
	private CustomerRepository customerDao;

	private ProductRepository productDao;

	private OrderRepository orderDao;

	private OrderProductRepository orderProductDao;
	
	private NaturalPersonRepository naturalPersonDao;

	private LegalPersonRepository legalPersonDao;
	
	@Autowired	
	public CustomerController(CustomerRepository customerDao, ProductRepository productDao, OrderRepository orderDao, 
			OrderProductRepository orderProductDao, NaturalPersonRepository naturalPersonDao, LegalPersonRepository legalPersonDao) {
		this.customerDao = customerDao;
		this.productDao = productDao;
		this.orderDao = orderDao;
		this.orderProductDao = orderProductDao;
		this.naturalPersonDao = naturalPersonDao;
		this.legalPersonDao = legalPersonDao;
	}

	@GetMapping
	public List<Person> getAllUsers() {
		teste();
		return customerDao.findAll();
	}

	@GetMapping(path="/{name}")
	public List<Person> getCustomersByName(@PathVariable("name") String n) {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		return customerDao.findCustomerByName(n);
	}
	
	public Person teste() {

		LegalPerson legalPerson = new LegalPerson();
		legalPerson.setName("Windows R");
		legalPerson.setLegalEntityIdentifier("FSDFHGHD22");
		customerDao.save(legalPerson);
		System.out.println();

		NaturalPerson naturalPerson = new NaturalPerson();
		naturalPerson.setName("Foo");
		naturalPerson.setNationalIdentityNumber("43248127722");
		customerDao.save(legalPerson);
		System.out.println();
		
		Product hotdog = new Product();
		hotdog.setName("Le doggy doggie");
		hotdog.setQuantity(12l);
		hotdog.setPrice((long) 3.5);
		productDao.save(hotdog);
		System.out.println();

		System.out.println("Find by name (Foo):");
		/*
		System.out.println(((NaturalPerson)customerDao.findCustomerByName("Foo").get(0)).getName() 
				+ " - " +((NaturalPerson)customerDao.findCustomerByName("Foo").get(0)).getNationalIdentityNumber());
		System.out.println();*/
		
		System.out.println("By person select:");
		List<Person> lookup4person = customerDao.findAll();
		for(int i=0; i<lookup4person.size(); i++) {
			if(lookup4person.get(i) != null) {
				System.out.println("Name: " +lookup4person.get(i).getName());
			}
		}

		System.out.println();
		System.out.println("By legalperson select:");

		List<LegalPerson> lookup4legalperson = legalPersonDao.findAll();
		for(int i=0; i<lookup4legalperson.size(); i++) {
			if(lookup4legalperson.get(i) != null) {
				System.out.println("Name: " +lookup4legalperson.get(i).getName());
			}
		}

		System.out.println();
				
		System.out.println("Find all products");

		List<Product> lookup4products = productDao.findAll();
		for(int i=0; i<lookup4products.size(); i++) {
			if(lookup4products.get(i) != null) {
				System.out.println("Name: " +lookup4products.get(i).getName() +" - Price: " +lookup4products.get(i).getPrice() );
			}
		}
		System.out.println();

		System.out.println("Find product id 1:");
		productDao.findById(1l).ifPresent(p -> System.out.println(p.getName() + " - " +p.getPrice()));
		System.out.println();
		
		Order order = new Order();
		order.setCustomer(legalPerson);
		order.setPaymentMethod(Arrays.asList("Paypal","Picpay","TransferWise"));
		//order.setCustomer(naturalPerson);
		order.setReferral(legalPerson);
		order.setCoupon(Arrays.asList(10,15,20));
		order.setTime(new Date());
		orderDao.save(order);
		System.out.println();
				
		OrderProduct orderingProduct = new OrderProduct();
		orderingProduct.setOrder(order);
		orderingProduct.setProduct(hotdog);
		orderingProduct.setQuantity(2);
		orderProductDao.save(orderingProduct);
		System.out.println();

		List<Order> orderObjs = orderDao.findAll();
		System.out.println();
		
		Order lastOne;
		for(int i=0; i<orderObjs.size(); i++) {
			System.out.println("=-=-=-=-=Order " +(i+1) +"=-=-=-=-=");
			System.out.println();
			System.out.println("Order info: ");
			System.out.println("Requested by: " +orderObjs.get(i).getCustomer().getName());
			System.out.println("When: " +orderObjs.get(i).getTime());
			System.out.println("Referral: " +orderObjs.get(i).getReferral().getName()); 
			lastOne = orderObjs.get(i);
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println();
		
		System.out.println(orderDao.findAll(PageRequest.of(0, 3, Sort.by("time"))));
		return null;
	}
}

