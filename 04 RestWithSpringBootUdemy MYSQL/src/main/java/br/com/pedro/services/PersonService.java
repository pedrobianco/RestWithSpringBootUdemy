package br.com.pedro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.pedro.model.Person;
import br.com.pedro.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId()).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}	
	
	public void delete(long id) {
		Person entity = repository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
	public Person findById(long id) {
		return repository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	
	
	
}
