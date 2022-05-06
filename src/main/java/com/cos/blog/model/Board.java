package com.cos.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //제목
    @Column(nullable = false, length = 100)
    private String title;

    //내용
    @Lob
    private String content;

    //조회수
    private int count;

    //사용자 아이디
    @ManyToOne(fetch = FetchType.EAGER) //한명의 User는 여러개의 Board를 만들 수 있다.
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //하나의 게시글의 여러개의 댓글들.Mapped by 연관관계의 주인이 아닌것을 명시.
    @JsonIgnoreProperties({"board"}) //무한참조를 막기위함
    private List<Reply> Replys;


    @CreationTimestamp
    private Timestamp createDate;

}
