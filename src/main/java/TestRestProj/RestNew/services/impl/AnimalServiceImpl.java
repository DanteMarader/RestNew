package TestRestProj.RestNew.services.impl;

import TestRestProj.RestNew.entity.Animal;
import TestRestProj.RestNew.entity.AnimalDto;
import TestRestProj.RestNew.mapper.AnimalMapper;
import TestRestProj.RestNew.mapper.CategoryMapper;
import TestRestProj.RestNew.repositories.AnimalRepository;
import TestRestProj.RestNew.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private AnimalMapper animalMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public AnimalDto addAnimal(AnimalDto animalDto) {
        Animal animal = new Animal();
        animal.setName(animalDto.getName());
        animal.setAge(animalDto.getAge());
        animal.setWeight(animalDto.getWeight());
        animal.setCategories(categoryMapper.mapToEntityList(animalDto.getCategories()));
        animal.setPromocode(UUID.randomUUID().toString());
        return animalMapper.mapToDto(animalRepository.save(animal));
    }

    @Override
    public List<AnimalDto> getAllAnimals() {
        return animalMapper.mapToDtoList(animalRepository.findAll());
    }

    @Override
    public AnimalDto updateAnimal(AnimalDto updAnimalDto) {
        Animal animal = animalRepository.findAllById(updAnimalDto.getId());
        animal.setName(updAnimalDto.getName());
        animal.setAge(updAnimalDto.getAge());
        animal.setWeight(updAnimalDto.getWeight());

//        Стирает все и присваевает новый массив(перезаливает все заново)
//        animal.setCategories(categoryMapper.mapToEntityList(updAnimalDto.getCategories()));

        for (int i = 0; i < updAnimalDto.getCategories().size(); i++) {
            boolean exist = false;
            for (int j = 0; j < animal.getCategories().size(); j++) {
                if (updAnimalDto.getCategories().get(i).getId() == animal.getCategories().get(j).getId()) {
                    exist = true;
                    break;
                }
            }
            if (exist == false) {
                animal.getCategories().add(categoryMapper.mapToEntity(updAnimalDto.getCategories().get(i)));
            }
        }
        //             обновляет категории объекту добавляя их в конец массива (без дублирования , не стирая предыдущие обновление)
        return animalMapper.mapToDto(animalRepository.save(animal));
    }

    @Override
    public AnimalDto getAnimal(Long id) {
        return animalMapper.mapToDto(animalRepository.findAllById(id));
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
