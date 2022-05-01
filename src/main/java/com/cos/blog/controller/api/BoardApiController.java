package com.cos.blog.controller.api;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.service.BoardApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @Autowired
    BoardApiService boardApiService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board , @AuthenticationPrincipal PrincipalDetail principal) {

        System.out.println("BoardApiController : save 호출");
//        userApiService.SignIn(user);
        boardApiService.regBoard(board,principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
