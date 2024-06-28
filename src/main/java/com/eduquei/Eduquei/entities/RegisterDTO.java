package com.eduquei.Eduquei.entities;

import com.eduquei.Eduquei.entities.enums.UserRole;

public record RegisterDTO (String login, String password, UserRole role) {
}
