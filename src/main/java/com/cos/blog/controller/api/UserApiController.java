package com.cos.blog.controller.api;


import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Security;

@RestController
public class UserApiController {
    @Autowired
    private UserApiService userApiService;
//    @Autowired
//    private HttpSession session;
    @Autowired
    private BCryptPasswordEncoder encode;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user , HttpSession session){
        System.out.println("UserApiController : save 호출");
        userApiService.SignIn(user);
        return  new ResponseDto<Integer>(HttpStatus.OK.value(),1) ;
    }
    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user){
        System.out.println("UserApiController : update 호출");
        userApiService.update(user);

        //트렌젝션 종료로 DB는 변경되었지만 session은 변경되지 않았다.
        //직접 변겨해줘야한다. spring security
//        Authentication authentication =
//                new UsernamePasswordAuthenticationToken(principal, null,principal.getAuthorities());
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        securityContext.setAuthentication(authentication);
//        session.setAttribute("SPRING_SECURITY_CONTEXT",securityContext);

        //세션등록(강제로 세션을 다시 넣어줌)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return  new ResponseDto<Integer>(HttpStatus.OK.value(),1) ;
    }



}
