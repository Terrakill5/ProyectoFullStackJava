package com.ironman.pharmasales.expose.web;

import com.ironman.pharmasales.aplicattion.services.CategoryService;
import com.ironman.pharmasales.aplicattion.services.DTO.category.CategoryDto;
import com.ironman.pharmasales.aplicattion.services.DTO.category.CategorySaveDto;
import com.ironman.pharmasales.persistence.entity.Category;
import com.ironman.pharmasales.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@RequestMapping("categories")
@RestController
public class CategoryController {
    @Autowired
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @GetMapping
    ResponseEntity<List<CategoryDto>> findAll(){
        List<CategoryDto> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    ResponseEntity<CategoryDto> findById(@PathVariable("id") Long id) {
        CategoryDto category = categoryService.findById(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping
    ResponseEntity<Category> create(@RequestBody CategorySaveDto categoryBody) {
        Category category = categoryService.create(categoryBody);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    ResponseEntity edit(@PathVariable("/{id}") Long id, @RequestBody CategorySaveDto categoryBody) {


        Category category = categoryService.edit(id,categoryBody);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Category> disabled(@PathVariable("id") Long id) {


        Category category = categoryService.disabled(id);
        return ResponseEntity.ok(category);

    }
}

