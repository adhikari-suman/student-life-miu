package edu.miu.reactbackend.service.impl;

import edu.miu.reactbackend.entity.Person;
import edu.miu.reactbackend.repository.PersonRepository;
import edu.miu.reactbackend.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> findAll() {
    return personRepository.findAll();
    }
}
