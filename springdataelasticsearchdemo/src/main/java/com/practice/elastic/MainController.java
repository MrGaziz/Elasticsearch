package com.practice.elastic;

import java.util.*;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping(path="/persons")
public class MainController {
	
	@Autowired
	PersonRepository repository;

	@PostMapping(path = "/generate") //Postman: post-http://localhost:8080/persons/generate after you can check it
    public String addNewPersons() {
        Random rand = new Random();
        Faker faker =new Faker();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            repository.save(Person.builder().name(faker.name().firstName()).age(rand.nextInt(100)+1).build());
        }
        long end = System.currentTimeMillis();
        log.info("Time which is wasted: " + (end - start));
        return "Saved";
    }

	@PostMapping("/add")
	public Person addPerson(@RequestBody Person person ){
		return repository.save(person);
	}
	
	@GetMapping("/all")
	public List<Person> getPerson(){
		 Iterator<Person> iterator= repository.findAll().iterator();
		 List<Person> person=new ArrayList<Person>();
		 while(iterator.hasNext()){
			 person.add(iterator.next());
		 }
		 return person;
	}

	@GetMapping("/{id}")
	public Optional<Person> getPerson(@PathVariable Integer id){
		return repository.findById(id);
	}

	@GetMapping("/{age}")
	public List<Person> getPersonbyAge(@PathVariable Integer age){
		return repository.findPersonByAge(age);
	}


	@PutMapping("/{id}")
	   public Person updatePerson(@PathVariable Integer id, @RequestBody Person person){
		   Optional<Person> person1= repository.findById(id);
		   if(person1.isPresent()){
			   Person p=person1.get();
			   p.setName(person.getName());
			   p.setAge(person.getAge());
		   return repository.save(p);
		   }
		   else return null; }
	@DeleteMapping("/{id}")
	   public String deletePerson(@PathVariable Integer id){
		  repository.deleteById(id);
		  return "Document Deleted";
	   }
}
