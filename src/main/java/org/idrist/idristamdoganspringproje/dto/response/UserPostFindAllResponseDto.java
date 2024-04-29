package org.idrist.idristamdoganspringproje.dto.response;

import java.time.LocalDate;

public record UserPostFindAllResponseDto(String title, String content, LocalDate published_at) {
}
