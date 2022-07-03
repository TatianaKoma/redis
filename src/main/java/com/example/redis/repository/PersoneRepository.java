package com.example.redis.repository;

import com.example.redis.model.Persone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersoneRepository extends JpaRepository<Persone, Integer> {

}
