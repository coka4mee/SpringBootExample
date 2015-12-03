package de.sample.controller;

import de.sample.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class HelloController {
    @Autowired
    MongoService mongoService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        mongoService.wipeAllRepositories();
        mongoService.fillCustomerRepository();
        return mongoService.listCustomer().toString();
    }

}