package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entitiy.Person;
import Repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }


}