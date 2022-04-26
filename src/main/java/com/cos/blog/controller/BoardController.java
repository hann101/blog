package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//views로 지정해야하고 RestController말고 Controller를 사용해야한다.

@Controller
public class BoardController {


    @GetMapping({"","/"})
    public  String index(){
        return "index";
    }
//    @GetMapping({"","/"})
//    public  String index(@AuthenticationPrincipal PrincipalDetail principal){
//        System.out.println("로그인 사용자 아이디 "+ principal.getUsername());
//
//        return "index";
//    }
}
