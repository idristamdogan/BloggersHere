package org.idrist.idristamdoganspringproje.controller;


import lombok.RequiredArgsConstructor;
import org.idrist.idristamdoganspringproje.dto.request.PostSaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.PostFindAllResponseDto;
import org.idrist.idristamdoganspringproje.dto.response.UserFindAllResponseDto;
import org.idrist.idristamdoganspringproje.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.idrist.idristamdoganspringproje.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + POST)
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<PostFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(postService.findPostDto());
    }
    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> savePost2(@RequestBody PostSaveRequestDto postSaveRequestDto){
        postService.savePost(postSaveRequestDto);
        return ResponseEntity.ok("Post saved successfully");
    }
    @GetMapping(FINDBYPOSTID)
    @CrossOrigin("*")
    public ResponseEntity<PostFindAllResponseDto> findByIdDto(@RequestParam Long id){
        return ResponseEntity.ok(postService.findPostDtoID(id));
    }
    @GetMapping(FINDBYUSERID)
    @CrossOrigin("*")
    public ResponseEntity<List<PostFindAllResponseDto>> findAllPostByUserId(@RequestParam Long id){
        return ResponseEntity.ok(postService.findAllPostByUserId(id));
    }
    @GetMapping(FINDBYCATEGORYID)
    @CrossOrigin("*")
    public ResponseEntity<List<PostFindAllResponseDto>> findAllPostByCategoryId(@RequestParam Long id){
        return ResponseEntity.ok(postService.findAllPostByCategoriesId(id));
    }
}
