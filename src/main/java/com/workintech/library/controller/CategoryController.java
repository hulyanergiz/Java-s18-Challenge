package com.workintech.library.controller;

import com.workintech.library.dto.CategoryResponse;
import com.workintech.library.entity.Category;
import com.workintech.library.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable long id){
        Category category=categoryService.findById(id);
        return new CategoryResponse(category.getId(),category.getName());
    }
    @PostMapping
    public CategoryResponse save(@RequestBody Category category){
        Category savedCategory=categoryService.save(category);
        return new CategoryResponse(savedCategory.getId(),savedCategory.getName());
    }
}
