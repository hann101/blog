package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service//Bean등록
public class PrincipalDetailService implements UserDetailsService {

    private User user;

    @Autowired
    private UserRepository userRepository;

    @Override //로그인 요청시, 2개의 변수가로챔 password는 알아서 처리, 로그인은 DB와 비교해 그걸  loadUserByUsername가 해
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{ //optional이라서 elseThrow
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다." +username);
                });

        return new PrincipalDetail(principal);
    }
}
