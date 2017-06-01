package it.euris.fullstack.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.euris.fullstack.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, String> {
    
    public Page<Person> findByName(String name, Pageable pageable);
    
    public Page<Person> findBySurname(String surname, Pageable pageable);
    
}
