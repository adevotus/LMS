package io.credable.loanmanagementsystem.controller;

import io.credable.loanmanagementsystem.Soap.client.SoapClient;
import io.credable.loanmanagementsystem.Soap.client.WebServiceConfiguration;
import io.credable.loanmanagementsystem.customerclasses.Customer;
import io.credable.loanmanagementsystem.customerclasses.CustomerRequest;
import io.credable.loanmanagementsystem.customerclasses.CustomerResponse;
import io.credable.loanmanagementsystem.data.dto.CustomerRequestDTO;
import io.credable.loanmanagementsystem.data.vo.CustomerModel;
import io.credable.loanmanagementsystem.service.CustomerService;
import jakarta.xml.ws.soap.SOAPFaultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/customerNumber")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private SoapClient soapClient;
    private CustomerResponse customerResponse;
    @Autowired
    public CustomerController(CustomerService customerService, SoapClient soapClient) {
        this.customerService = customerService;
         this.soapClient = soapClient;
    }

    /**********************************************************
     api for customer details requesting from customer soap
     *********************************************************/
    @GetMapping("{customerNumber}")
    public Customer invokeSoapClientToGetCustomerNumber(@PathVariable String customerNumber) {
        CustomerResponse customerResponse = new CustomerResponse();
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setCustomerNumber(customerRequest.getCustomerNumber());
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebServiceConfiguration.class);
        soapClient = context.getBean(SoapClient.class);
        customerResponse = soapClient.getCustomerNumber(customerNumber);
        return customerResponse.getCustomer();
    }




    /**********************************************************
     api for customer subscription and add to customerkyc db if not exit
     *********************************************************/
    @GetMapping("subscribe/{customerNumber}")
    public ResponseEntity<Object> subscribeCustomer(@PathVariable String customerNumber) {
        CustomerModel existingCustomer = customerService.getCustomer(customerNumber);
        if (existingCustomer != null) {
            // customer found in local database, return the response
            log.info("Customer found in local database with customer number: " + customerNumber);
            return new ResponseEntity<>(Map.of("message", "Customer already subscribed", "response", existingCustomer), HttpStatus.OK);
        } else {
            try {
                log.info("Customer not found " + customerNumber);
                // customer not found in local database, hit SOAP web service to get customer information
                CustomerResponse newCustomerResponse = soapClient.getCustomerNumber(customerNumber);
                if (newCustomerResponse != null && newCustomerResponse.getCustomer() != null) {
                    // customer found in SOAP web service, save to local database
                    log.info("Customer found in SOAP web servicer: " + customerNumber);

                    CustomerModel newCustomer = extractAndSaveCustomer(newCustomerResponse, customerNumber);
                    return new ResponseEntity<>(Map.of("message", "subscribed successfully", "response", newCustomer), HttpStatus.OK);
                } else {
                    // customer not found in both local database and SOAP web service
                    log.info("Customer with customer number " + customerNumber + " not found.");
                    return new ResponseEntity<>("Customer with this customer number doesn't exist", HttpStatus.NOT_FOUND);
                }
            } catch (SOAPFaultException ex) {
                // handle the SOAP fault exception and return an appropriate response
                log.info("Error retrieving customer  " + customerNumber);
                return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    /**********************************************************
     method for extract and save to db
     *********************************************************/
    private CustomerModel extractAndSaveCustomer(CustomerResponse newCustomerResponse, String customerNumber) {
        Customer customer = newCustomerResponse.getCustomer();
        if (customer != null) {
            CustomerModel model = new CustomerModel();
            model.setCustomerNumber(customer.getCustomerNumber());
            model.setFirstName(customer.getFirstName());
            model.setMiddleName(customer.getMiddleName());
            model.setLastName(customer.getLastName());
            model.setEmail(customer.getEmail());
            model.setMobile(customer.getMobile());
            model.setMonthlyIncome(customer.getMonthlyIncome());
            //model.setIdType(customer.getIdType());
            model.setID(customer.getId());

            return customerService.addCustomer(model);

        } else {
            log.info("No customer information found");
            return null;
        }

    }

    @PostMapping("/subscribe_V1")
    public ResponseEntity<?> create(@RequestBody CustomerRequestDTO dto){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerNumber(dto.getCustomerNumber());
        customerModel.setID(dto.getID());
        customerModel.setFirstName(dto.getFirstName());
        customerModel.setLastName(dto.getLastname());
        customerModel.setMiddleName(dto.getMiddleName());
        customerModel.setEmail(dto.getEmail());
        customerModel.setDob(dto.getDob());
        customerModel.setGender(dto.getGender());
        customerModel.setMonthlyIncome(dto.getMonthlyIncome());
        customerModel.setStatus(dto.getStatus());
        customerModel.setCreatedAt(dto.getCreatedAt());
        customerModel.setCreatedDate(dto.getCreatedDate());
        customerModel.setMobile(dto.getMobile());
        customerModel.setUpdatedAt(dto.getUpdatedAt());



        CustomerModel customer =  customerService.addCustomerNumber(customerModel);
        return new ResponseEntity(customerModel, HttpStatus.OK);
    }


}

