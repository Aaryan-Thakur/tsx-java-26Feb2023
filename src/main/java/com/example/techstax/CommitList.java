package com.example.techstax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.techstax.data.repodata;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class CommitList {
    public static final Logger logger = LoggerFactory.getLogger(CommitList.class);
    
    //RestTemplate used to make API Call
    public RestTemplate restTemplate;
    
    //Getting details about the owner and repo to make the API call to
    private repodata data;
    
    public CommitList() {
        this.restTemplate = new RestTemplate();
        this.data = new repodata();
    }

    public void commitList(){

        try {

            //Initizaling the URL
            String apiUrl = String.format("%s/repos/%s/%s/commits",data.API_BASE_URL,data.owner,data.repo);
    
            //Setting the headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "Spring");
            headers.set("Authorization", "Token " + data.token);
    
            //Makeing the API Call
            ResponseEntity<JsonNode> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null,JsonNode.class);
    
            //Logging the information recieved from the github API endpoint
            logger.info(response.getBody().toPrettyString());

            //Getting current timestamp
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String formattedDateTime = now.format(formatter);

            //Printing success message
            System.out.println(formattedDateTime+"\nCommit logged in logs/commitlist.log successfully\n");
            return;
        } catch (Exception e) {//Catching error
			System.out.println("------------------------ERROR HAS OCCURED------------------------\n"+e+"\nPlease check logs/errors.log for more infomation");
            logger.error("", e);
        }

    }

}
