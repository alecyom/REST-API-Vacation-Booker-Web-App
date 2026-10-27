package com.example.demo;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer();
        c1.setFirstName("customer1");
        c1.setLastName("lastname1");
        c1.setAddress("1111");
        c1.setPostal_code("11111");
        c1.setPhone("18001111111");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstName("customer2");
        c2.setLastName("lastname2");
        c2.setAddress("2222");
        c2.setPostal_code("22222");
        c2.setPhone("18002222222");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setFirstName("customer3");
        c3.setLastName("lastname3");
        c3.setAddress("3333");
        c3.setPostal_code("33333");
        c3.setPhone("18003333333");
        customerRepository.save(c1);

        Customer c4 = new Customer();
        c4.setFirstName("customer4");
        c4.setLastName("lastname4");
        c4.setAddress("4444");
        c4.setPostal_code("44444");
        c4.setPhone("18004444444");
        customerRepository.save(c4);

        Customer c5 = new Customer();
        c5.setFirstName("customer5");
        c5.setLastName("lastname5");
        c5.setAddress("5555");
        c5.setPostal_code("55555");
        c5.setPhone("18005555555");
        customerRepository.save(c5);
    }

}
