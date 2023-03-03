package io.credable.loanmanagementsystem;

import io.credable.loanmanagementsystem.Soap.client.SoapClient;
import io.credable.loanmanagementsystem.Soap.client.WebServiceConfiguration;
import io.credable.loanmanagementsystem.customerclasses.CustomerResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication


public class LoanManagementSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(LoanManagementSystemApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebServiceConfiguration.class);
        SoapClient client = context.getBean(SoapClient.class);
        CustomerResponse response = client.getCustomerNumber("340397370 ");
        //System.out.println("response: Customer ID" + response.getCustomer().getId() + "Customer name=" + response.getCustomer().getFirstName() + response.getCustomer().getMiddleName() + response.getCustomer().getLastName() + ", Email=" + response.getCustomer().getEmail() + ",Gender = " + response.getCustomer().getGender() + ",Mobile number = " + response.getCustomer().getMobile() + ",Date of birth = " + response.getCustomer().getDob() + "Identity type = " + response.getCustomer().getIdType() + "Mounthly income = " + response.getCustomer().getMonthlyIncome() + "Updated at=" + response.getCustomer().getUpdatedAt() + " Created Date = " + response.getCustomer().getCreatedDate() + "Status =" + response.getCustomer().getStatus() + " Created at = " + response.getCustomer().getCreatedAt() + "Identity number = " + response.getCustomer().getIdNumber());

        System.out.println("response: the customer details : " + response.getCustomer());
    }

}
