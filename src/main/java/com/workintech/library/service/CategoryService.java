package com.workintech.library.service;

import com.workintech.library.entity.Category;

public interface CategoryService {

    Category findById(long id);

    Category save(Category category);

    Category update(Category category);
}
