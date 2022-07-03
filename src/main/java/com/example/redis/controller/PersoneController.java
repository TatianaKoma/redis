package com.example.redis.controller;

import com.example.redis.model.Persone;
import com.example.redis.service.PersoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/persone")
public class PersoneController {

    @Autowired
    PersoneService personeService;

    @PostMapping
    public Persone savePersone(@RequestBody Persone persone) {
        return personeService.savePersone(persone);
    }

    @GetMapping
    public ResponseEntity<List<Persone>> getAllPersones() {
        return ResponseEntity.ok(personeService.getAllPersones());
    }

    @GetMapping("/{personeId}")
    public Persone getOnePersone(@PathVariable("personeId") Integer personeId) {
        return personeService.getOnePersone(personeId);
    }

    @PutMapping("/{personeId}")
    public Persone updatePersone(@RequestBody Persone persone,@PathVariable("personeId") Integer personeId) {
        return personeService.updatePersone(persone,personeId);
    }

    @DeleteMapping("/{personeId}")
    public String deletePersone(@PathVariable("personeId") Integer personeId) {
        personeService.deletePersone(personeId);
        return "Persone with id: " + personeId + " Deleted !";
    }

}
