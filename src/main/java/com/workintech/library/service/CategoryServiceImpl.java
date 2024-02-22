package com.workintech.library.service;

import com.workintech.library.entity.Category;
import com.workintech.library.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(long id) {
        Optional<Category> categoryOptional=categoryRepository.findById(id);
        return categoryOptional.orElseThrow(()->new RuntimeException("Category is not found with id: "+id));
    }

    @Override
    public Category save(Category category) {
        Optional<Category> categoryOptional=categoryRepository.findById(category.getId());
        if(categoryOptional.isPresent()){
            throw new RuntimeException("Book already exist");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category categoryToUpdate=findById(category.getId());
        if(category.getName()!=null) {
            categoryToUpdate.setName(category.getName());
        }
        return categoryRepository.save(categoryToUpdate);
    }
}
