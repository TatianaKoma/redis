package com.example.redis.service;

import com.example.redis.PersoneNotFoundException;
import com.example.redis.model.Persone;
import com.example.redis.repository.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoneServiceImpl implements PersoneService {

    @Autowired
    private PersoneRepository personeRepository;

    @Override
    public Persone savePersone(Persone persone) {
        return personeRepository.save(persone);
    }

    @Override
    @CachePut(value = "Persone", key = "#personeId")
    public Persone updatePersone(Persone newPersone, Integer personeId) {
        Persone persone = personeRepository.findById(personeId)
                .orElseThrow(() -> new PersoneNotFoundException("Persone Not Found"));
        persone.setName(newPersone.getName());
        persone.setSurname(newPersone.getSurname());
        persone.setAge(newPersone.getAge());
        return personeRepository.save(persone);
    }

    @Override
    @CacheEvict(value = "Persone", key = "#personeId")
    public void deletePersone(Integer personeId) {
        Persone persone = personeRepository.findById(personeId)
                .orElseThrow(() -> new PersoneNotFoundException("Persone Not Found"));
        personeRepository.delete(persone);
    }

    @Override
    @Cacheable(value = "Persone", key = "#personeId")
    public Persone getOnePersone(Integer personeId) {
        return personeRepository.findById(personeId)
                .orElseThrow(() -> new PersoneNotFoundException("Persone Not Found"));
    }

    @Override
    public List<Persone> getAllPersones() {
        return personeRepository.findAll();
    }
}
