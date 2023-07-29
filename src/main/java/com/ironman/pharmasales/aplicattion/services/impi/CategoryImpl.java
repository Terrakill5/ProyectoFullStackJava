package com.ironman.pharmasales.aplicattion.services.impi;

import com.ironman.pharmasales.aplicattion.services.CategoryService;
import com.ironman.pharmasales.aplicattion.services.DTO.category.CategorySaveDto;
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



    @GetMapping
    public List<Category> findAll() {
        List<Category> categories =  (List<Category>) categoryRepository.findAll();
        return categories;
    }

    @GetMapping("/{id}")
    public Category findById(Long id) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @PutMapping
    public Category edit(Long id, Category categoryBody) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @PostMapping
    public Category create(CategorySaveDto categoryBody) {
        Category categorySave = new Category();
        categorySave.setName(categoryBody.getName());
        categorySave.setDescription(categoryBody.getDescription());
        categorySave.setKeyword(categoryBody.getName());

        categorySave.setState("A");
        categorySave.setCreatedAt(LocalDateTime.now());
        Category category = categoryRepository.save(categorySave);
        return category;
    }

    public Category disabled(Long id) {
        Category categoryDb = categoryRepository.findById(id).get();
        categoryDb.setState("E");

        Category category = categoryRepository.save(categoryDb);
        return category;

    }


}
