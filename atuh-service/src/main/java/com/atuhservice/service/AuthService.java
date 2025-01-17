package com.atuhservice.service;

import com.atuhservice.entity.AuthRequest;
import com.atuhservice.entity.AuthResponse;
import com.atuhservice.entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    private final RestTemplate restTemplate;
    private final JwtUtils jwtUtils;

    public AuthService(RestTemplate restTemplate, JwtUtils jwtUtils) {
        this.restTemplate = restTemplate;
        this.jwtUtils = jwtUtils;
    }

    public AuthResponse register(AuthRequest request){
        request.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        UserEntity user = restTemplate.postForEntity("http://localhost:9000/user/save", request, UserEntity.class).getBody();

        String accessToken = jwtUtils.generate(user.getId().toString(), user.getRole(),"ACCESS");
        String refreshToken = jwtUtils.generate(user.getId().toString(), user.getRole(),"REFRESH");


        return new AuthResponse(accessToken, refreshToken);
    }
}
