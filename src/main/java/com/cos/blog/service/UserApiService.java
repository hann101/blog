package com.cos.blog.service;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
