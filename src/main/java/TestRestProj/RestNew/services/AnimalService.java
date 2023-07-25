package TestRestProj.RestNew.services;

import TestRestProj.RestNew.entity.AnimalDto;

import java.util.List;

public interface AnimalService {
    AnimalDto addAnimal(AnimalDto animalDto);
    List<AnimalDto> getAllAnimals();
    AnimalDto updateAnimal(AnimalDto updAnimalDto);
    AnimalDto getAnimal(Long id);
    void deleteAnimal(Long id);
}
