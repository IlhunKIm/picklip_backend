package com.pickclip.pickclip_backend.model;

import com.pickclip.pickclip_backend.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long articleId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = true)
    @Lob
    private String picture;

    public Comment(CommentRequestDto requestDto) {
        this.articleId = requestDto.getArticleId();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.picture = requestDto.getPicture();
    }

    public void updateComment(CommentRequestDto requestDto) {
        this.articleId = requestDto.getArticleId();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.picture = requestDto.getPicture();
    }


}
