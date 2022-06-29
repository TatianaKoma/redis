package com.example.redis.repository;

import com.example.redis.model.Persone;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersoneRepository {

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public PersoneRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(Persone persone) {
        hashOperations.put("PERSONE", persone.getId(), persone);
    }

    public List<Persone> findAll() {
        return hashOperations.values("PERSONE");
    }

    public Persone findById(Integer id) {
        return (Persone) hashOperations.get("PERSONE", id);
    }

    public void deleteById(Integer id) {
        hashOperations.delete("PERSONE", id);
    }
}
