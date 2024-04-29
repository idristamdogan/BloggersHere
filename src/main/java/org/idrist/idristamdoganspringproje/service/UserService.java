package org.idrist.idristamdoganspringproje.service;

import org.idrist.idristamdoganspringproje.dto.request.UserSaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.CategoryFindAllResponseDto;
import org.idrist.idristamdoganspringproje.dto.response.UserFindAllResponseDto;
import org.idrist.idristamdoganspringproje.entity.User;
import org.idrist.idristamdoganspringproje.mapper.CategoriesMapper;
import org.idrist.idristamdoganspringproje.mapper.UserMapper;
import org.idrist.idristamdoganspringproje.repository.UserRepository;
import org.idrist.idristamdoganspringproje.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public void userSaveDto(UserSaveRequestDto userSaveRequestDto){
        userRepository.save(UserMapper.INSTANCE.userSaveRequestDtoToUser(userSaveRequestDto));
    }



    public List<UserFindAllResponseDto> findUserDto() {
        List<UserFindAllResponseDto> userFindAllResponseDtos = new ArrayList<>();

        findAll().forEach(user -> {
            userFindAllResponseDtos.add(UserMapper.INSTANCE.userToUserFindAllResponseDto(user));
        });
        return userFindAllResponseDtos;
    }


    public UserFindAllResponseDto findUserDto(String name, String lastname) {

        User findByNameAndByLastname = userRepository.findByNameIgnoreCaseAndLastnameIgnoreCase(name, lastname);
        UserFindAllResponseDto userFindAllResponseDto = UserMapper.INSTANCE.userToUserFindAllResponseDto(findByNameAndByLastname);
        return userFindAllResponseDto;
    }
    public UserFindAllResponseDto findUserDtoID(Long id) {
        Optional<User> byId = userRepository.findById(id);
        UserFindAllResponseDto userFindAllResponseDto = UserMapper.INSTANCE.userToUserFindAllResponseDto(byId.get());
        return userFindAllResponseDto;
    }

}


