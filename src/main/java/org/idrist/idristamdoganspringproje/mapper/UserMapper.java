package org.idrist.idristamdoganspringproje.mapper;


import org.idrist.idristamdoganspringproje.dto.request.UserSaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.UserFindAllResponseDto;
import org.idrist.idristamdoganspringproje.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    User userSaveRequestDtoToUser(UserSaveRequestDto userSaveRequestDto);

    UserFindAllResponseDto userToUserFindAllResponseDto(User user);
}
