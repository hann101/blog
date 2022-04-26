package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

}
//    User findByUsernameAndPassword(String username, String password);
//네이밍 룰을 통해 쿼리가 자동으로 만들어진다.
