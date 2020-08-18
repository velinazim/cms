package com.example.service;

import com.example.dao.CustomerDao;
import com.example.exception.CustomerNotFoundException;
import com.example.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    public List<Customer> getCustomerList() {
        return customerDao.findAll();
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if(!optionalCustomer.isPresent()){

            throw new CustomerNotFoundException("Customer Record is not available.");

        }

        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerDao.deleteById(customerId);
    }
}
