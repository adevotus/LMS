package io.credable.loanmanagementsystem.Soap.client;

import io.credable.loanmanagementsystem.customerclasses.CustomerRequest;
import io.credable.loanmanagementsystem.customerclasses.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class SoapClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(SoapClient.class);




    /**********************************************************
    requesting customer details from customer classes
     *********************************************************/
    public CustomerResponse getCustomerNumber(String CustomerNumber) {
        CustomerRequest request = new CustomerRequest();
        request.setCustomerNumber(CustomerNumber);
        log.info("request information for " + CustomerNumber);
        return (CustomerResponse) getWebServiceTemplate().marshalSendAndReceive("https://kycapitest.credable.io/service/customer", request);

    }
}
