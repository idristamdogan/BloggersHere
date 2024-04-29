package org.idrist.idristamdoganspringproje.service;

import org.idrist.idristamdoganspringproje.dto.request.CategorySaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.CategoryFindAllResponseDto;
import org.idrist.idristamdoganspringproje.dto.response.UserFindAllResponseDto;
import org.idrist.idristamdoganspringproje.entity.Categories;
import org.idrist.idristamdoganspringproje.entity.User;
import org.idrist.idristamdoganspringproje.mapper.CategoriesMapper;
import org.idrist.idristamdoganspringproje.mapper.UserMapper;
import org.idrist.idristamdoganspringproje.repository.CategoriesRepository;
import org.idrist.idristamdoganspringproje.repository.PostRepository;
import org.idrist.idristamdoganspringproje.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService extends ServiceManager<Categories,Long> {
    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        super(categoriesRepository);
        this.categoriesRepository = categoriesRepository;
    }


    public void categorySaveDto(CategorySaveRequestDto dto) {
        categoriesRepository.save(CategoriesMapper.INSTANCE.categoriesSaveRequestDtoToCategory(dto));
    }

    public List<CategoryFindAllResponseDto> findAllCategoriesDto() {
        List<CategoryFindAllResponseDto> categoryFindAllResponseDtos = new ArrayList<>();

        findAll().forEach(categories -> {
            categoryFindAllResponseDtos.add(CategoriesMapper.INSTANCE.categoryFindAllResponseDtoToCategories(categories));
        });
        return categoryFindAllResponseDtos;
    }
    public CategoryFindAllResponseDto findCategoryById(Long id){
        return CategoriesMapper.INSTANCE.categoryFindAllResponseDtoToCategories(categoriesRepository.findById(id).get());
    }

}
