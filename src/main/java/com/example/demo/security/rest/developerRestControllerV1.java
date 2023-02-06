package com.example.demo.security.rest;

import com.example.demo.security.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class developerRestControllerV1 {

    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L,"ivan", "ivan"),
            new Developer(2L,"oleg", "lol"),
            new Developer(3L,"filipp", "jek")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id){
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
    }

}
