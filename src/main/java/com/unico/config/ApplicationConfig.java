/**
 * 
 */
package main.java.com.unico.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Sonam
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "main.java.com.unico")
public class ApplicationConfig {

	
}
