package br.com.pedro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedro.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
