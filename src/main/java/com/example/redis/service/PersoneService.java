package com.example.redis.service;

import com.example.redis.model.Persone;
import com.example.redis.repository.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PersoneService {
    private final PersoneRepository personeRepository;

    @Autowired
    public PersoneService(PersoneRepository personeRepository) {
        this.personeRepository = personeRepository;
    }

    public List<Persone> getPersones() {
        return personeRepository.findAll();
    }

    public void addNewPersone(Persone persone) {
        personeRepository.save(persone);
    }

    public void deletePersone(Integer personeId) {
        personeRepository.deleteById(personeId);
    }

    public void updatePersone(Persone newPersone) {
        Persone persone = personeRepository.findById(newPersone.getId());
        if (newPersone.getName() != null &&
                newPersone.getName().length() > 0 &&
                !Objects.equals(persone.getName(), newPersone.getName())) {
            persone.setName(newPersone.getName());
        }
        if (newPersone.getSurname() != null &&
                newPersone.getSurname().length() > 0 &&
                !Objects.equals(persone.getSurname(), newPersone.getSurname())) {
            persone.setSurname(newPersone.getSurname());
        }
        if (newPersone.getAge() != null &&
                newPersone.getAge() > 0 &&
                !Objects.equals(persone.getAge(), newPersone.getAge())) {
            persone.setAge(newPersone.getAge());
        }
        personeRepository.save(persone);
    }

    public Optional<Persone> getPersone(Integer personeId) {
        return Optional.ofNullable(personeRepository.findById(personeId));
    }
}
