package org.kiskampi.customerservice.customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    private final CustomerSearchClient customerSearchClient;

    @GetMapping
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @PostMapping
    public Customer save(Customer customer) {
        customerRepository.save(customer);
        customerSearchClient.indexCustomer(customer);
        return customer;
    }

}
