package com.rmartin.assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Assignment2Application {

    public static void main(String[] args) {
        
        SpringApplication.run(Assignment2Application.class, args);
        endBoredom();
        System.exit(0);
        
    }

    public static void endBoredom() {
        try {
            String url = "http://www.boredapi.com/api/activity/";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonActivity = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonActivity);

            //Get the activity to end boredom.
            String activity = root.findValue("activity").asText();
            //Get type of activity.
            String typeOfActivity = root.findValue("type").asText();
            //Get the number of participants
            int numberOfParticipants = root.findValue("participants").asInt();

            //print vals
            System.out.println("Here's an idea to end your boredom:");
            System.out.println();
            System.out.println("Activity: " + activity);
            System.out.println("Type: " + typeOfActivity);
            System.out.println("Participants needed: " + numberOfParticipants);

        } catch (JsonProcessingException e) {
            System.out.println("error in endBoredom");
        }
    }
}
