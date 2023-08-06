package com.ironman.pharmasales.aplicattion.services.impi;

import com.ironman.pharmasales.aplicattion.services.CategoryService;
import com.ironman.pharmasales.aplicattion.services.DTO.category.CategoryDto;
import com.ironman.pharmasales.aplicattion.services.DTO.category.CategorySaveDto;
import com.ironman.pharmasales.aplicattion.services.DTO.category.mapper.CategoryMapper;
import com.ironman.pharmasales.persistence.entity.Category;
import com.ironman.pharmasales.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDateTime;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;



    @GetMapping
    public List<CategoryDto> findAll() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();

        List<CategoryDto> categoryDtos = categoryMapper.toCategoryDtos(categories);

        return categoryDtos;
    }

    @GetMapping("/{id}")
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).get();
        CategoryDto categoryDto = categoryMapper.toCategoryDto(category);
        return categoryDto;
    }

    @Override
    public CategoryDto edit(Long id, CategorySaveDto categoryBody) {
        Category categoryDb = categoryRepository.findById(id).get();
        Category categorySave = categoryMapper.toCategory(categoryBody);
        categorySave.setId(categoryDb.getId());
        categorySave.setKeyword(categoryDb.getName());
        categorySave.setState(categoryDb.getState());
        categorySave.setCreatedAt(categoryDb.getCreatedAt());
        categorySave.setUpdatedAt(LocalDateTime.now());
        Category category = categoryRepository.save(categorySave);
        return categoryMapper.toCategoryDto(category);
    }

    @PostMapping
    public CategoryDto create(CategorySaveDto categoryBody) {
        Category categorySave = categoryMapper.toCategory(categoryBody);
        categorySave.setKeyword(categoryBody.getName());
        categorySave.setState("A");
        categorySave.setCreatedAt(LocalDateTime.now());
        Category category = categoryRepository.save(categorySave);
        return categoryMapper.toCategoryDto(category);
    }

    public CategoryDto disabled(Long id) {
        Category categoryDb = categoryRepository.findById(id).get();
        categoryDb.setState("E");

        Category category = categoryRepository.save(categoryDb);
        return categoryMapper.toCategoryDto(category);

    }


}
