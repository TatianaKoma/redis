package com.example.redis.controller;

import com.example.redis.model.Persone;
import com.example.redis.service.PersoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/persone")
public class PersoneController {

    private final PersoneService personeService;

    @Autowired
    public PersoneController(PersoneService personeService) {
        this.personeService = personeService;
    }

    @GetMapping
    public List<Persone> getPersons() {
        return personeService.getPersones();
    }

    @GetMapping(value = "{personeId}")
    public Persone getPersone(@PathVariable("personeId") Integer personeId) {
        return personeService.getPersone(personeId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Persone not found"));
    }

    @PostMapping
    public void registerNewPersone(@RequestBody Persone persone) {
        System.out.println(persone);
        personeService.addNewPersone(persone);
    }

    @PutMapping
    public void updatePersone(@RequestBody Persone persone) {
        System.out.println(persone);
       personeService.updatePersone(persone);
    }

    @DeleteMapping(path = "/{personeId}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void deletePersone(@PathVariable("personeId") Integer personeId) {
        if(personeId ==0){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Persone not found") ;
        }
        personeService.deletePersone(personeId);
    }
}
