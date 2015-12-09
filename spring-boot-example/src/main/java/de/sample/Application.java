package de.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jonaslanzendorfer on 09.12.15.
 */
@EnableAutoConfiguration
@ComponentScan({"de.sample.*"})
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        logger.error("Message logged at ERROR level");
        logger.warn("Message logged at WARN level");
        logger.info("Message logged at INFO level");
        logger.debug("Message logged at DEBUG level");
    }
}
