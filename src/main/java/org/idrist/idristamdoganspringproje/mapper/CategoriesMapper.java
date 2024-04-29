package org.idrist.idristamdoganspringproje.mapper;


import org.idrist.idristamdoganspringproje.dto.request.CategorySaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.request.PostSaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.CategoryFindAllResponseDto;
import org.idrist.idristamdoganspringproje.entity.Categories;
import org.idrist.idristamdoganspringproje.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriesMapper {

    CategoriesMapper INSTANCE = Mappers.getMapper(CategoriesMapper.class);


    Categories categoriesSaveRequestDtoToCategory(CategorySaveRequestDto categorySaveRequestDto);

    CategoryFindAllResponseDto categoryFindAllResponseDtoToCategories(Categories categories);
}
