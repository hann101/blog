package com.cos.blog.controller.api;


import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {
    @Autowired
    private UserApiService userApiService;
//    @Autowired
//    private HttpSession session;
    @Autowired
    private BCryptPasswordEncoder encode;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user ,HttpSession session){
        System.out.println("UserApiController : save 호출");
        user.setRole(RoleType.USER);


        userApiService.SignIn(user);
        return  new ResponseDto<Integer>(HttpStatus.OK.value(),1) ;
    }
}
