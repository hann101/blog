package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//views로 지정해야하고 RestController말고 Controller를 사용해야한다.

@Controller
public class BoardController {

    @GetMapping("/")
    public  String index(){
        return "index";
    }
}
