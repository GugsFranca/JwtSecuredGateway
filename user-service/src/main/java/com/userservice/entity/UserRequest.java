package com.userservice.entity;

import java.io.Serializable;

/**
 * DTO for {@link UserEntity}
 */
public record UserRequest(String email, String password, String role) implements Serializable {
}