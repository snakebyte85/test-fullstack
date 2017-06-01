package it.euris.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableMongoRepositories("it.euris.fullstack.persistence")
//@ComponentScan("it.euris.fullstack")
public class MainApplication {

    public static void main(String[] args) throws Exception {
	SpringApplication.run(MainApplication.class, args);	
    }

    @Bean
    WebMvcConfigurer configurer() {
	return new WebMvcConfigurerAdapter() {

	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.html");
	    }

	};
    }
}
