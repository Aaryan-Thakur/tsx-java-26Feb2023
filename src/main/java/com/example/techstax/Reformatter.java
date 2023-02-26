//This class was made to reformat the events into more read-able form but couldn't complete due to time limitations (I have an exam in 2 days :D)
//Only the logging part of the event is done here for now

package com.example.techstax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
// import com.fasterxml.jackson.databind.node.ObjectNode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reformatter {

    public static final Logger logger = LoggerFactory.getLogger(Reformatter.class);

    public ResponseEntity<String> Log(JsonNode gitobj) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    
            // ObjectNode logobj = objectMapper.createObjectNode();
            // ObjectNode repository = objectMapper.createObjectNode();
    
            // // HANDLER FOR PULL REQUEST
            // if (gitobj.has("action")) {
    
            //     logobj.set("action", gitobj.path("action"));
            //     logobj.set("number", gitobj.path("number"));
            //     logobj.set("pull_request", gitobj.path("pull_request"));
            //     logobj.set("repository", gitobj.path("repository"));
            //     logobj.set("sender", gitobj.path("sender"));
    
            // } else {// HANDLER FOR ANYTHING ELSE (COMMIT,PUST,MERGE etc)
    
            //     logobj.set("ref", gitobj.path("ref"));
            //     logobj.set("before", gitobj.path("before"));
            //     logobj.set("after", gitobj.path("after"));
            //     logobj.put("timestamp", gitobj.path("head_commit").get("timestamp").asText());
    
            //     repository.put("name", gitobj.path("repository").get("full_name").asText());
            //     repository.put("id", gitobj.path("repository").get("id").asText());
            //     repository.put("link", gitobj.path("repository").get("html_url").asText());
    
            //     logobj.set("repository", repository);
            //     logobj.set("pusher", gitobj.path("pusher"));
            //     logobj.set("commits", gitobj.path("commits"));
            //     logobj.set("head_commit", gitobj.path("head_commit"));
            // }
    
            // logger.info("Commit Information: {}", logobj.toPrettyString());
    
            logger.info("Event Log: {}", gitobj.toPrettyString());

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String formattedDateTime = now.format(formatter);

            System.out.println(formattedDateTime+ "\nNEW EVENT LOGGED IN logs/eventlogger.log\n");

        } catch (Exception e) {
			System.out.println("------------------------ERROR HAS OCCURED------------------------\n"+e+"\nPlease check logs/errors.log for more infomation");
            logger.error("", e);

        }



        return null;
    }

}
