package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private final Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    @GetMapping()
    public List<Animal> getAllAnimals() {
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal addAnimal(@PathVariable Integer id, Animal animal) {
        if(animals.containsKey(id)) {
            animals.put(id, new Animal(id, animal.getName()));
            return animal;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        if(animals.remove(id) != null) {
            return "Animal is removed.";
        }
        return "Animal is not found.";
    }


}
