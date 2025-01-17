package com.userservice.service;

import com.userservice.entity.RoleName;
import com.userservice.entity.UserEntity;
import com.userservice.entity.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserEntity toUserEntity(UserRequest request) {
        var role = request.role().trim().toUpperCase();

        return UserEntity.builder()
                .email(request.email())
                .password(request.password())
                .role(RoleName.valueOf(role))
                .build();
    }
}
