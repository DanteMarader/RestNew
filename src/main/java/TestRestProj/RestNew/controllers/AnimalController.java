package TestRestProj.RestNew.controllers;

import TestRestProj.RestNew.entity.Animal;
import TestRestProj.RestNew.entity.AnimalDto;
import TestRestProj.RestNew.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<AnimalDto> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @GetMapping(value = "/{id}")
    public AnimalDto getAnimal(@PathVariable("id") Long id){
        return animalService.getAnimal(id);
    }

    @PostMapping
    public AnimalDto addAnimal(@RequestBody AnimalDto animalDto){
        return animalService.addAnimal(animalDto);
    }

    @PutMapping
    public AnimalDto updateAnimal(@RequestBody AnimalDto updAnimalDto){
        return animalService.updateAnimal(updAnimalDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnimal(@PathVariable("id") Long id){
        animalService.deleteAnimal(id);
    }
}
