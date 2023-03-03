package io.credable.loanmanagementsystem.Soap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
public class WebServiceConfiguration {


    /**********************************************************
      credentials in core banking system in customer soap.
     *********************************************************/

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor security = new Wss4jSecurityInterceptor();
        security.setSecurementActions("UsernameToken");
        security.setSecurementUsername("admin");
        security.setSecurementPassword("pwd123");
        security.setSecurementPasswordType("PasswordText");
        security.setSecurementMustUnderstand(true);
        return security;
    }



    /**********************************************************
     fetching the customer soap classes folder
     *********************************************************/
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("io.credable.loanmanagementsystem.customerclasses");
        return marshaller;
    }




    /**********************************************************
     converting xml class to java objects and for secitury interceptor.
     *********************************************************/
    @Bean
    public SoapClient soapClient(Jaxb2Marshaller marshaller) {
        SoapClient client = new SoapClient();
        client.setDefaultUri("https://kycapitest.credable.io/service/customer");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        ClientInterceptor[] interceptor = new ClientInterceptor[]{securityInterceptor(),  new SoapInterceptor("")};
        client.setInterceptors(interceptor);
        return client;

    }
}
