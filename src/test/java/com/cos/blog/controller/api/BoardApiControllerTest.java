package com.cos.blog.controller.api;

import com.cos.blog.model.Board;
import com.cos.blog.service.BoardApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BoardApiControllerTest {

    @Autowired
    BoardApiService service;

    @Test
    Board save() {
        Board result =  service.boardDetail('1');
        System.out.println(result);
        return result;
    }
}