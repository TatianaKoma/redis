package com.example.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persone implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
}
