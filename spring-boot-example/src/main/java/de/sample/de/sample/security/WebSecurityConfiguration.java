package de.sample.de.sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.*;

/**
 * Created by jonaslanzendorfer on 09.12.15.
 */
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("coka4mee").password("casino").roles("USER");
    }
}
