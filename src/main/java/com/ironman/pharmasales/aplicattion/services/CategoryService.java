package com.ironman.pharmasales.aplicattion.services;

import com.ironman.pharmasales.persistence.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);
}
