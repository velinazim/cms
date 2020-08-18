package com.example.api;

import com.example.entity.Person;
import com.example.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/porse")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setName("Veli Nazım");
        person.setLast_name("Akyıldırım");
        person.setAddress("test");
        person.setBirthDay(Calendar.getInstance().getTime());
        personRepository.save(person);

    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>>getPerson(@PathVariable String search){
       List<Person> persons = personRepository.getByNameLikeOrLast_nameLike(search, search);
       return ResponseEntity.ok(persons);
    }
}
