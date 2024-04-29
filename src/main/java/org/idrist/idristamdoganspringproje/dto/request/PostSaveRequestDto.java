package org.idrist.idristamdoganspringproje.dto.request;

import org.idrist.idristamdoganspringproje.entity.User;

public record PostSaveRequestDto(String title, String content,Long user_id,Long categories_id) {
}
