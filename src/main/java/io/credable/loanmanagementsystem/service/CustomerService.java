package io.credable.loanmanagementsystem.service;

import io.credable.loanmanagementsystem.data.dao.Repository.CustomerRepository;
import io.credable.loanmanagementsystem.data.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;



    @Autowired
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository=customerRepository;

    }

    public CustomerModel getCustomer(String customerNumber){
        return customerRepository.findByCustomerNumber(customerNumber);
    }


    public CustomerModel addCustomerNumber(CustomerModel customerNumber){
        return customerRepository.save(customerNumber);
    }


    /**********************************************************
     add the customer details to customerkyc db
     *********************************************************/
    public CustomerModel addCustomer(CustomerModel customer){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerNumber(customer.getCustomerNumber());
        return customerRepository.save(customer);
    }


}