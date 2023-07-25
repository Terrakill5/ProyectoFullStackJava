package com.ironman.pharmasales.repository;

import com.ironman.pharmasales.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository  extends CrudRepository<Category, Long> {
}
