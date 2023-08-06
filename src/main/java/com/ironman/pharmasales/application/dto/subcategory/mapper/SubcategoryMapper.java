package com.ironman.pharmasales.application.dto.subcategory.mapper;

import com.ironman.pharmasales.application.dto.category.mapper.CategoryMapper;
import com.ironman.pharmasales.application.dto.subcategory.SubcategoryDto;
import com.ironman.pharmasales.application.dto.subcategory.SubcategorySaveDto;
import com.ironman.pharmasales.persistence.entity.Subcategory;
import com.ironman.pharmasales.shared.state.mapper.StateMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {CategoryMapper.class, StateMapper.class}

)
public interface SubcategoryMapper {
    // Dto from Entity Start

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "keyword", source = "keyword")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    SubcategoryDto toSubcategoryDto(Subcategory subcategory);
    List<SubcategoryDto> toSubcategoryDtos(List<Subcategory> subcategories);
    // Dto from Entity End

    // Entity from Dto Start

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "categoryId", source = "categoryId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "keyword", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Subcategory toSubcategory(SubcategorySaveDto subcategorySaveDto);

    @InheritConfiguration
    void updateSubcategory(@MappingTarget Subcategory subcategory, SubcategorySaveDto subcategorySaveDto);
    // Entity from Dto End


}
