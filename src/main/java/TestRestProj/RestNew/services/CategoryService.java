package TestRestProj.RestNew.services;

import TestRestProj.RestNew.entity.Category;
import TestRestProj.RestNew.entity.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
}
