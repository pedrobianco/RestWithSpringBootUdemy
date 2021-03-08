package br.com.pedro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedro.model.Person;
import br.com.pedro.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") long id) {
		return services.findById(id);
	}
	
	@GetMapping
	public List<Person> findAll() {
		return services.findAll();
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		return services.create(person);
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) {
		return services.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
