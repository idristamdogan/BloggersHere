package org.idrist.idristamdoganspringproje.mapper;


import org.idrist.idristamdoganspringproje.dto.request.PostSaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.request.UserSaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.PostFindAllResponseDto;
import org.idrist.idristamdoganspringproje.entity.Post;
import org.idrist.idristamdoganspringproje.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "categories_id", source = "post.categories.id")
   @Mapping(target = "user_id", source = "post.user.id")

   PostFindAllResponseDto postToPostFindAllResponseDto(Post post);
    Post postSaveRequestDtoToPost(PostSaveRequestDto postSaveRequestDto);


}
