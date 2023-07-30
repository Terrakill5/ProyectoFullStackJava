package com.ironman.pharmasales.aplicattion.services;

import com.ironman.pharmasales.aplicattion.services.DTO.category.CategoryDto;
import com.ironman.pharmasales.aplicattion.services.DTO.category.CategorySaveDto;
import com.ironman.pharmasales.persistence.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto findById(Long id);

    CategoryDto edit(Long id, CategorySaveDto categoryBody);
    CategoryDto create(CategorySaveDto categoryBody);
    CategoryDto disabled(Long id);

}
