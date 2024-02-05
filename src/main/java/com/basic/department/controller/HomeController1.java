package com.basic.department.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
public class HomeController1 {

	
	private final RestTemplate restTemplate = new RestTemplate();
	@Value("${welcome.message}")
	private String welcomeMessageString;
	@GetMapping("/home")
	public String hello() {
		
		//return restTemplate.getForObject("http://3.28.216.7:8080/departments", String.class);
//		HttpEntity<String> httpEntity = new HttpEntity<String>(welcomeMessageString);
//
//		ResponseEntity<String> responseEntity= restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET, httpEntity, String.class);
//		System.out.println(responseEntity);
//		JSONParser parser = new JSONParser(welcomeMessageString);
		//restTemplate.postForObject("http://3.28.216.7:8080/departments", restTemplate, Department.class);
		return welcomeMessageString;
	}
	@GetMapping("/getDummyData")
	public String getDummyData() throws JsonMappingException, JsonProcessingException {
		
		// Create a RestTemplate (you might want to configure it with, for example, a custom HttpClient)
        RestTemplate restTemplate = new RestTemplate();

        // URL and method for the REST call
        String apiUrl = "https://dummy.restapiexample.com/api/v1/employees";
        HttpMethod httpMethod = HttpMethod.GET;

        // Make the REST call and extract the response object
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, httpMethod, null, String.class);
        
        String responseString = responseEntity.getBody();
        //JsonParser jsonNode = p(responseString);
     // Use the responseData as needed
        System.out.println("Response Data: " + responseEntity.getStatusCode());
        //System.out.println("Response Data: " + responseEntity.getBody());
        responseEntity.getStatusCode();
     // Check if the response was successful (status code 2xx)
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            // Parse the JSON response using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseEntity.getBody());

            // Access the 'data' array from the JSON response
            JsonNode dataArray = rootNode.get("data");

            // Process each element in the 'data' array
            for (JsonNode employeeNode : dataArray) {
                // Access individual properties
                int id = employeeNode.get("id").asInt();
                String name = employeeNode.get("employee_name").asText();
                int salary = employeeNode.get("employee_salary").asInt();
                int age = employeeNode.get("employee_age").asInt();

                // Do something with the data (e.g., print or store in a list)
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Age: " + age);
            }
        } else {
            // Handle the error scenario
            System.err.println("Error: " + responseEntity.getStatusCode());
        }
        return responseString;
        
        
	}
	
	@PostMapping("/postServiceToUrl")
	public String postServiceToUrl() throws JsonMappingException, JsonProcessingException {
		
		// Create a RestTemplate (you might want to configure it with, for example, a custom HttpClient)
        RestTemplate restTemplate = new RestTemplate();

        // URL and method for the REST call
        String apiUrl = "https://dummy.restapiexample.com/api/v1/create";
        HttpMethod httpMethod = HttpMethod.POST;
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
     // Create the request body as a JSON string
        String jsonBody = "{\"name\":\"Praveen Doe\","
        		+ "\"salary\":\"50000\","
        		+ "\"age\":\"30\"}";
     // Create the HttpEntity with headers and body
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        // Make the REST call and extract the response object
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, httpMethod, requestEntity, String.class);
        
        String responseString = responseEntity.getBody();
        //JsonParser jsonNode = p(responseString);
     // Use the responseData as needed
        System.out.println("Response Data: " + responseEntity.getStatusCode());
        System.out.println("Response Data postServiceToUrl: " + responseEntity.getBody());
        responseEntity.getStatusCode();
     // Check if the response was successful (status code 2xx)
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
        	// Process the response body
            String responseBody = responseEntity.getBody();

            // Parse the JSON response using Jackson ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Parse the response body into a JsonNode
                JsonNode jsonNode = objectMapper.readTree(responseBody);

                // Extract data from the "data" field
                JsonNode dataNode = jsonNode.path("data");
                String name = dataNode.path("name").asText();
                String salary = dataNode.path("salary").asText();
                String age = dataNode.path("age").asText();
                long id = dataNode.path("id").asLong();

                // Print the extracted data
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
                System.out.println("Age: " + age);
                System.out.println("ID: " + id);
                

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Handle the error scenario
            System.err.println("Error: " + responseEntity.getStatusCode());
        }
        return responseString;
        
        
	}
	
}
