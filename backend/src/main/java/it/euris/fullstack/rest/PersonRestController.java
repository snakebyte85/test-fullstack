package it.euris.fullstack.rest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.euris.fullstack.model.Person;
import it.euris.fullstack.persistence.PersonRepository;

@RestController
@RequestMapping(produces="application/json")
public class PersonRestController {
    
    private final static Logger log = LoggerFactory.getLogger(PersonRestController.class);

    @Autowired
    private PersonRepository repository;
    
    
    @RequestMapping(path="/person", method=RequestMethod.GET)
    @ResponseBody
    public Page<Person> persons() {
	log.info("Called 'persons' api");
	return repository.findAll(new PageRequest(0, 10));
    }
    
    @RequestMapping(path="/person", params= "name", method=RequestMethod.GET)
    @ResponseBody
    public Page<Person> personsFindByName(@RequestParam(value="name", required=true) String name) {
	log.debug("Called 'personsFindByName' api with name={}" , name);
	return repository.findByName(name, new PageRequest(0,1000));	
    }
    
    @RequestMapping(path="/person", params= "surname", method=RequestMethod.GET)
    @ResponseBody
    public Page<Person> personsFindBySurname(@RequestParam(value="surname", required=false) String surname) {
	log.debug("Called 'persons' api searching with surname={}", surname);
	return repository.findBySurname(surname, new PageRequest(0,1000));	
    }
        
    @RequestMapping(path="/person/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Person person(@PathVariable("id") String id, HttpServletResponse response) {
	log.debug("Called 'person' api");
	Person p = repository.findOne(id);
	if(p == null) {
	    response.setStatus(HttpServletResponse.SC_NOT_FOUND);	    
	}
	return p;
    }

}
