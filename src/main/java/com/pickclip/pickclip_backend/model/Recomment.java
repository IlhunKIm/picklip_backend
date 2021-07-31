package com.pickclip.pickclip_backend.model;

import com.pickclip.pickclip_backend.dto.RecommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Recomment {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;

    @Column(nullable = false)
    private Long commentId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = true)
    @Lob
    private String picture;


    public Recomment(RecommentRequestDto requestDto) {
        this.commentId = requestDto.getCommentId();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.picture = requestDto.getPicture();
    }


    public void updateRecomment(RecommentRequestDto requestDto) {
        this.commentId = requestDto.getCommentId();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.picture = requestDto.getPicture();

    }
}
