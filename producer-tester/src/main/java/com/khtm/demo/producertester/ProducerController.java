package com.khtm.demo.producertester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, User2> userKafkaTemplate;
    private static final String TOPIC = "kafka_example";

    @RequestMapping(method = RequestMethod.GET, value = "/publish/{message}")
    public String post(@PathVariable("message") String message){
        kafkaTemplate.send(TOPIC, message);
        return "publish successfully.";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json/{firstname}/{lastname}")
    public String postUser(@PathVariable(name = "firstname") String firstName, @PathVariable(name = "lastname") String lastName){
        User2 user = new User2();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userKafkaTemplate.send("kafka_example_json_5", user);
        return "user was published successfully.";
    }

}
