package TestRestProj.RestNew.mapper;

import TestRestProj.RestNew.entity.Animal;
import TestRestProj.RestNew.entity.AnimalDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    AnimalDto mapToDto(Animal animal);
    Animal mapToEntity(AnimalDto animalDto);
    List<AnimalDto> mapToDtoList(List<Animal> animals);
    List<Animal> mapToEntityList(List<AnimalDto> animalDtos);
}
