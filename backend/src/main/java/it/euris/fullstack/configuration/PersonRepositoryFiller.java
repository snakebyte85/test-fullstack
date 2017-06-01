package it.euris.fullstack.configuration;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.euris.fullstack.model.Gender;
import it.euris.fullstack.model.Person;
import it.euris.fullstack.persistence.PersonRepository;

@Component
@Profile("dev")
public class PersonRepositoryFiller implements ApplicationListener<ContextRefreshedEvent>{

    private final static int TOTAL = 100;
    
    private final static Logger log = LoggerFactory.getLogger(PersonRepositoryFiller.class);
    
    @Autowired 
    private PersonRepository repository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {	
	for(int i = 0 ; i < TOTAL; i++) {
	    repository.save(createPerson());
	}
	log.info("Filled PersonRepository with " + TOTAL + " records");
    }

    private Person createPerson() {
	Person p = new Person();
	p.setName(Math.random() > 0.5 ? "Mario" : "Luca");
	p.setSurname(Math.random() > 0.5 ? "Rossi" : "Bianchi");
	p.setCity(Math.random() > 0.5 ? "Bologna" : "Roma"); 
	p.setAddress("Via Indipendenza 1");
	p.setGender(Math.random() > 0.5 ? Gender.MALE : Gender.FEMALE);
	p.setPhoneNumber("0511111111");
	p.setPlaceOfBirth("Messina");
	p.setDateOfBirth(LocalDate.of(1985, 11, 23));
	return p;
    }
}
