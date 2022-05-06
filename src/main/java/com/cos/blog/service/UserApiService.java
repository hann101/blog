package com.cos.blog.service;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.AbstractUriTemplateHandler;

@Service
public class UserApiService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;



    @Transactional
    public void SignIn(User user){
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);

//        user.setPassword(encPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);

        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        User persistance = userRepository.findById(user.getId())
                .orElseThrow(() -> {
                    return new IllegalArgumentException("못찾음");
                });
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);

        persistance.setEmail(user.getEmail());
        persistance.setPassword(encPassword);


    }
}
