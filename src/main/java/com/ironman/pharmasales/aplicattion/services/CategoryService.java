package com.ironman.pharmasales.aplicattion.services;

import com.ironman.pharmasales.persistence.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category edit(Long id, Category categoryBody);
    Category create(Category categoryBody);
    Category disabled(Long id);

}
