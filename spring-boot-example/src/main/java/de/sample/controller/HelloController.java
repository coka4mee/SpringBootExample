package de.sample.controller;

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

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloController.class, args);
    }
}