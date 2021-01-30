package com.ba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ba.dto.CustomerDTO;

@Controller
@RequestMapping("/client")
public class RestClientController {

    private static final String webUrl = "http://localhost:8080/customer";
    
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getKisiList(){
    	
    	String username = "user2";
    	String password = ":pass2";
    	HttpHeaders headers = new HttpHeaders();
    	 headers.add("Authorization", "Basic dXNlcjI6cGFzczI=");
    	
    	HttpEntity<String> request = new HttpEntity<String>(headers);
    	ResponseEntity<List> response = restTemplate.exchange(webUrl, HttpMethod.GET, request, List.class);
        List<CustomerDTO> responseBody = response.getBody();
        return ResponseEntity.ok(responseBody);
    }
  

}
