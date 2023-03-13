package io.credable.loanmanagementsystem.config;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.credable.loanmanagementsystem.data.vo.LoanResponse;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Configuration
public class LoanConfig {
    RestTemplate restTemplate = new RestTemplate();


    /**********************************************************
      client token header for scoring score
     *********************************************************/

    public ResponseEntity<String> createClientToken(String customernumber) {
        String request = "{ " + "\"url\": \"" + "Http://13.48.10.129:8080/transactionsApi/" + customernumber + "\", " + "\"name\": \"" + "loan" + "\", " + "\"username\": \"" + "" + "\", " + "\"password\": \"" + "" + "\"" + "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(request, headers);

        String url = "https://scoringtest.credable.io/api/v1/client/createClient";
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }



    /**********************************************************
      token for initialize query score
     *********************************************************/
    @SneakyThrows
    public String createToken(String customerNumber) {
        ResponseEntity<String> ClientToken = createClientToken(customerNumber);
        String tokenNew = ClientToken.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(tokenNew);
        String Clienttoken = jsonNode.get("token").asText();
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", Clienttoken);
        HttpEntity<?> request = new HttpEntity<>(headers);
        String uri = "https://scoringtest.credable.io/api/v1/scoring/initiateQueryScore/" + customerNumber;
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
        String token = response.getBody();
        return token;

    }



    /**********************************************************
     the client score method
     *********************************************************/
    @SneakyThrows
    public LoanResponse clientScore(@PathVariable String customerNumber) {
        ResponseEntity<String> clientToken = createClientToken(customerNumber);
        String token = clientToken.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(token);
        String Clienttoken = jsonNode.get("token").asText();
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", Clienttoken);
        HttpEntity<Object> request = new HttpEntity<>(headers);

        String token2 = createToken(customerNumber);
         int seconds = 7;

        String uri = "https://scoringtest.credable.io/api/v1/scoring/queryScore/" + token2;

        /**************      waiting and retries for the request to sent    *********/
        LoanResponse scorereponse = new LoanResponse();
        int retryCount = 1;
        int maxRetries = 2;

        while (scorereponse.getScore() == null && retryCount < maxRetries) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            retryCount++;
            String tokennew = clientToken.getBody();
            ObjectMapper objectMappernew = new ObjectMapper();
            JsonNode jsonNodenew = objectMappernew.readTree(tokennew);
            String Clienttokennew = jsonNodenew.get("token").asText();
            HttpHeaders headersnew = new HttpHeaders();
            headersnew.set("client-token", Clienttokennew);
            HttpEntity<Object> requestnew = new HttpEntity<>(headersnew);
            Thread.sleep(seconds * 1000);
            ResponseEntity<LoanResponse> responsequerynew = restTemplate.exchange(uri, HttpMethod.GET, requestnew, LoanResponse.class);

            LoanResponse response = responsequerynew.getBody();
            return response;

        }
        // retryCount++;
        return null;


    }


}
