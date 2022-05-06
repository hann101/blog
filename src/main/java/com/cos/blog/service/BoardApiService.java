package com.cos.blog.service;

import com.cos.blog.dto.ReplySaveRequestDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.Reply;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class BoardApiService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public void regBoard(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        System.out.println(board.getUser());
        System.out.println("title: "+board.getTitle());
        System.out.println("Content:"+board.getContent());
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board boardDetail(int id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("상세보기 실패");
                });
    }
    @Transactional
    public void delete(int id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Board requestBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 찾기 실패");
                });    //영속화

        board.setTitle(requestBoard. getTitle());
        board.setContent(requestBoard.getContent());
        //영속화 되어 있는 객체를 수정해서 자동으로 수정됨 (더티체킹)
    }

    @Transactional
    public void regReply(ReplySaveRequestDto replySaveRequestDto) {
        User user = userRepository.findById(replySaveRequestDto.getUserId())
                .orElseThrow(() -> {
                    return new IllegalArgumentException("댓글쓰기 실패: 사용자를 찾을 수 없음");
                });
        Board board = boardRepository.findById(replySaveRequestDto.getBoardId())
                .orElseThrow(() -> {
                    return new IllegalArgumentException("댓글쓰기 실패: 게시글을 찾을 수 없음");
                });

        Reply reply = Reply.builder()
                .user(user)
                .board(board)
                .content(replySaveRequestDto.getContent())
                .build();




        replyRepository.save(reply);

    }
}


