package org.idrist.idristamdoganspringproje.controller;


import ch.qos.logback.core.model.processor.ModelHandlerException;
import lombok.RequiredArgsConstructor;
import org.idrist.idristamdoganspringproje.dto.request.UserSaveRequestDto;
import org.idrist.idristamdoganspringproje.dto.response.UserFindAllResponseDto;
import org.idrist.idristamdoganspringproje.exception.ErrorType;
import org.idrist.idristamdoganspringproje.exception.MovieAppException;
import org.idrist.idristamdoganspringproje.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.idrist.idristamdoganspringproje.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody UserSaveRequestDto dto){
        if (!dto.email().endsWith("@gmail.com")) {

            throw new MovieAppException(ErrorType.WRONG_EMAIL_TYPE,"Wrong email Type");

        } else if (dto.password().length() != 8) {

            throw new MovieAppException(ErrorType.WRONG_PASSWORD_LENGTH,"Wrong password length");

        } else {
            userService.userSaveDto(dto);

            return ResponseEntity.ok("Kayit Basarili");    }
    }
    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<UserFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(userService.findUserDto());
    }
    @GetMapping(FINDBYNAMEANDLASTNAME)
    @CrossOrigin("*")
    public ResponseEntity<UserFindAllResponseDto> findUserByNameAndLastName(@RequestParam String name, @RequestParam String lastname){
        return ResponseEntity.ok(userService.findUserDto(name, lastname));
    }

    @GetMapping(FINDBYID)
    @CrossOrigin("*")
    public ResponseEntity<UserFindAllResponseDto> findByIdDto(@RequestParam Long id){
        return ResponseEntity.ok(userService.findUserDtoID(id));
    }



}
