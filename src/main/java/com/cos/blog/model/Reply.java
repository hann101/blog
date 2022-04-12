package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //내용
    @Column(nullable = false,length = 200)
    private String content;

    @ManyToOne //여러개의 게시글을 한명읫 User가 쓸 수 있다.
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne //여러개의 답변을 하나의 User가 쓸 수 있따.
    @JoinColumn(name="userId")
    private User user;


    @CreationTimestamp
    private Timestamp createDate;
}
