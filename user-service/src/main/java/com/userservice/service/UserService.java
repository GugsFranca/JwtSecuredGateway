package com.userservice.service;

import com.userservice.entity.UserEntity;
import com.userservice.entity.UserRequest;
import com.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserEntity save(UserRequest request){
        UserEntity entity = mapper.toUserEntity(request);
        return repository.save(entity);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
