package com.ironman.pharmasales.aplicattion.services.impi;

import com.ironman.pharmasales.aplicattion.services.CategoryService;
import com.ironman.pharmasales.persistence.entity.Category;
import com.ironman.pharmasales.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;



    @Override
    public List<Category> findAll() {
        List<Category> categories =  (List<Category>) categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }
}
