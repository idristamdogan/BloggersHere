package org.idrist.idristamdoganspringproje.dto.response;

import java.util.List;

public record UserFindAllResponseDto(String name, String lastname, List<UserPostFindAllResponseDto> posts) {
}
