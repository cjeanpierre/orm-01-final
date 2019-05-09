package com.puthisastra.first;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class MainController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
    @ResponseBody
    public List<Person> getListPerson() {
		return personRepository.findAll();
    }
	
	@GetMapping("/create")
    @ResponseBody
    public Person createPerson() {
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Doe");
		person.setAge(13);
		return personRepository.save(person);
    }
	
	
}
