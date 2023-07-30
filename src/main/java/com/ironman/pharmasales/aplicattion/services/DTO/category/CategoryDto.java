package com.ironman.pharmasales.aplicattion.services.DTO.category;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
@Data

public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private String keyword;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
