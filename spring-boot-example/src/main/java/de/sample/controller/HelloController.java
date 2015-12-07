package de.sample.controller;

import de.sample.service.MongoService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class HelloController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    MongoService mongoService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        logger.debug("Wipe Mongo DB");
        mongoService.wipeAllRepositories();
        logger.debug("Fill Customer Repository");
        mongoService.fillCustomerRepository();
        logger.debug("List Customer Repository");
        return mongoService.listCustomer().toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloController.class, args);
    }
}