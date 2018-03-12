package main.java.com.unico.config;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import main.java.com.unico.auth.impl.RestAuthFilter;

@EnableWebSecurity
@ComponentScan(basePackages = { "main.java.com.unico" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	
      
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().
          antMatchers("/rest/*").and()
          .addFilterAfter(new RestAuthFilter(), BasicAuthenticationFilter.class).authorizeRequests().anyRequest();         
        
          
    }

   
}