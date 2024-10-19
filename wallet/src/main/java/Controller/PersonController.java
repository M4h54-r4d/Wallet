package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Entitiy.Person;
import Service.PersonService;
import jakarta.validation.Valid;

@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPerson(id));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody @Valid Person personDetails) {
//        Person updatedPerson = personService.updatePerson(id, personDetails);
//        return ResponseEntity.ok(updatedPerson);
//    }
//
//   
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
//        personService.deletePerson(id);
//        return ResponseEntity.ok("Person deleted successfully");
//    }
}