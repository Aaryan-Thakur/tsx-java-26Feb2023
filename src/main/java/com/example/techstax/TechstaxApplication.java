package com.example.techstax;


import java.io.IOException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



@RestController
@SpringBootApplication
public class TechstaxApplication {
	public static final Logger logger = LoggerFactory.getLogger(CommitList.class);


	//For main page
	@RequestMapping("/")
    String home(){
        return "POST request at URL/webhook to log event details <br> Visit URL/commit to retrive list of commits from a repo <br>  Repo can be changed from com.example.techstax.data.repodata.java";
    }

	//Visiting "URL/commit" will execute the code below (retriveing commit list)
	@RequestMapping("/commit")
    String sheesh(){
		CommitList comL = new CommitList();
		comL.commitList();
        return "WARNING: WITH EACH REFRESH ON THIS PAGE A GITHUB API CALL WILL BE MADE TO GET LIST OF COMMITS";
    }

	//Setting up the webhook endpoint for git repo to hit to
    @PostMapping(value="/webhook")
    public void webhook(@RequestBody String data) throws IOException{
		try {

			//Decoding the incoming data from git to reformat it into a more readable format
			String decodedString = URLDecoder.decode(data,"UTF-8");
			String json = decodedString.substring(8);
	
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);//To enable pretty format
	
			JsonNode actualObj = mapper.readTree(json);//Creating the incoming string data into a JsonNode
			
			//Sending the data to reformatter for further processing
			Reformatter rf = new Reformatter();
			rf.Log(actualObj);	

			return;
		} catch (Exception e) {
			
			System.out.println("------------------------ERROR HAS OCCURED------------------------\n"+e+"\nPlease check logs/errors.log for more infomation");
			logger.error("", e);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(TechstaxApplication.class, args);
	}

	

}
