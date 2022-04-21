package com.cos.blog.service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserApiService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void SignIn(User user){
            userRepository.save(user);
    }

    @Transactional(readOnly = true) //select시 트랜젝션 시작, 서비스 종료시 트랜젝션 종료(정합성)
    public User login(User user) {

        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }


}
