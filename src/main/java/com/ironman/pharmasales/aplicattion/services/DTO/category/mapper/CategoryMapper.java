package com.ironman.pharmasales.aplicattion.services.DTO.category.mapper;

import com.ironman.pharmasales.aplicattion.services.DTO.category.CategoryDto;
import com.ironman.pharmasales.aplicattion.services.DTO.category.CategorySaveDto;
import com.ironman.pharmasales.persistence.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING )
public interface CategoryMapper {

    //Entity to Dto Start
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "keyword", target = "keyword")
    @Mapping(source = "state",target = "state")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    @Mapping(source = "id", target = "id")
    CategoryDto toCategoryDto(Category category);
    List<CategoryDto> toCategoryDtos(List<Category> categories);


    //Entity to Dto End

    /*
    private Long id;


    private String name;
    private String description;
    private String keyword;
    private String state;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;
    * */
@Mapping(source = "name", target = "name")
@Mapping(source = "description", target = "description")
@Mapping(target = "createdAt", ignore = true)
@Mapping(target = "id", ignore = true)
@Mapping(target = "keyword", ignore = true)
@Mapping(target = "state", ignore = true)


    //Dto to Entity Start
 Category toCategory(CategorySaveDto categorySaveDto);

    //Dto to Entity End
}
