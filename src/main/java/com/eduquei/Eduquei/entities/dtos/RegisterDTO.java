package com.eduquei.Eduquei.entities.dtos;

import com.eduquei.Eduquei.entities.enums.UserRole;

public record RegisterDTO (String login, String password, UserRole role) {
}
