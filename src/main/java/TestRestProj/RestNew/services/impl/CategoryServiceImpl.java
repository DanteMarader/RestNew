package TestRestProj.RestNew.services.impl;

import TestRestProj.RestNew.entity.Category;
import TestRestProj.RestNew.entity.CategoryDto;
import TestRestProj.RestNew.mapper.CategoryMapper;
import TestRestProj.RestNew.repositories.CategoryRepository;
import TestRestProj.RestNew.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setPostCode(UUID.randomUUID().toString());
        return categoryMapper.mapToDto(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryMapper.mapToDtoList(categoryRepository.findAll());
    }
}
