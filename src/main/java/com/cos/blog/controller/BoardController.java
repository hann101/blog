package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.BoardApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//views로 지정해야하고 RestController말고 Controller를 사용해야한다.
//Front end
@Controller
public class BoardController {

    @Autowired
    BoardApiService boardApiService;

    @GetMapping({"","/"})
    public  String index(Model model,@PageableDefault( size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("boards",boardApiService.boardList(pageable));
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm(){

        return "board/saveForm";
    }
}
