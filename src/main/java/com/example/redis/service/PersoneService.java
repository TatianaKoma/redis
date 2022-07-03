package com.example.redis.service;

import com.example.redis.model.Persone;

import java.util.List;

public interface PersoneService {

    Persone savePersone(Persone persone);

    Persone updatePersone(Persone persone, Integer personeId);

    void deletePersone(Integer personeId);

    Persone getOnePersone(Integer personeId);

    List<Persone> getAllPersones();

}
