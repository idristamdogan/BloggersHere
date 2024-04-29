package org.idrist.idristamdoganspringproje.service;

import org.idrist.idristamdoganspringproje.dto.request.PostSaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.PostFindAllResponseDto;
import org.idrist.idristamdoganspringproje.dto.response.UserFindAllResponseDto;
import org.idrist.idristamdoganspringproje.entity.Categories;
import org.idrist.idristamdoganspringproje.entity.Post;

import org.idrist.idristamdoganspringproje.entity.User;
import org.idrist.idristamdoganspringproje.mapper.PostMapper;
import org.idrist.idristamdoganspringproje.mapper.UserMapper;
import org.idrist.idristamdoganspringproje.repository.PostRepository;
import org.idrist.idristamdoganspringproje.repository.UserRepository;
import org.idrist.idristamdoganspringproje.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService extends ServiceManager<Post,Long> {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        super(postRepository);
        this.postRepository = postRepository;
    }



    public List<PostFindAllResponseDto> findPostDto() {
        List<PostFindAllResponseDto> postFindAllResponseDtos = new ArrayList<>();

        findAll().forEach(post -> {
            postFindAllResponseDtos.add(PostMapper.INSTANCE.postToPostFindAllResponseDto(post));
        });
        return postFindAllResponseDtos;
    }
    public String savePost(PostSaveRequestDto postSaveRequestDto){
        User user = User.builder()
                .id(postSaveRequestDto.user_id())
                .build();
        Categories categories = Categories.builder().id(postSaveRequestDto.categories_id()).build();
        Post post = Post.builder()
                .user(user)
                .title(postSaveRequestDto.title())
                .content(postSaveRequestDto.content())
                .categories(categories)
                .build();
        user.setPosts(List.of(post));


        postRepository.save(post);
        return "Kayit Basarili";
    }

    public PostFindAllResponseDto findPostDtoID(Long id) {
        Optional<Post> byId = postRepository.findById(id);
        PostFindAllResponseDto postFindAllResponseDto = PostMapper.INSTANCE.postToPostFindAllResponseDto(byId.get());
        return postFindAllResponseDto;
    }


    public List<PostFindAllResponseDto> findAllPostByUserId(Long userId) {
        return postRepository.findAllPostByUserId(userId).stream().map(PostMapper.INSTANCE::postToPostFindAllResponseDto).collect(Collectors.toList());
    }
    public List<PostFindAllResponseDto> findAllPostByCategoriesId(Long categoriesId) {
        return postRepository.findAllPostByCategoriesId(categoriesId).stream().map(PostMapper.INSTANCE::postToPostFindAllResponseDto).collect(Collectors.toList());
    }
}
