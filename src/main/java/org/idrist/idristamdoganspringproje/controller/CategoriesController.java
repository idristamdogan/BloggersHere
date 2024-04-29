package org.idrist.idristamdoganspringproje.controller;


import lombok.RequiredArgsConstructor;
import org.idrist.idristamdoganspringproje.dto.request.CategorySaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.CategoryFindAllResponseDto;
import org.idrist.idristamdoganspringproje.dto.response.PostFindAllResponseDto;
import org.idrist.idristamdoganspringproje.service.CategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.idrist.idristamdoganspringproje.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + CATEGORIES)
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;


    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> saveCategory(@RequestBody CategorySaveRequestDto categorySaveRequestDto){
        categoriesService.categorySaveDto(categorySaveRequestDto);
        return ResponseEntity.ok("Kayıt başarılı");
    }

    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<CategoryFindAllResponseDto>> findAllCategoriesDto(){
        return ResponseEntity.ok(categoriesService.findAllCategoriesDto());
    }

    @GetMapping(FINDBYID)
    @CrossOrigin("*")
    public ResponseEntity<CategoryFindAllResponseDto> findAllCategoriesById(@RequestParam Long id){
        return ResponseEntity.ok(categoriesService.findCategoryById(id));
    }
}
