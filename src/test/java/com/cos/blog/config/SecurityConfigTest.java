package com.cos.blog.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigTest {
    @Test
    public void ENC(){
        String encPassword = new BCryptPasswordEncoder().encode("1234");
        System.out.println("1234 해쉬 " +encPassword);
    }

}