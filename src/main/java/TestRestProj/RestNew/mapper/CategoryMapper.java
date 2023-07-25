package TestRestProj.RestNew.mapper;

import TestRestProj.RestNew.entity.Category;
import TestRestProj.RestNew.entity.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto mapToDto(Category category);
    Category mapToEntity(CategoryDto categoryDto);
    List<CategoryDto> mapToDtoList(List<Category> categories);
    List<Category> mapToEntityList(List<CategoryDto> categoryDtoList);
}
