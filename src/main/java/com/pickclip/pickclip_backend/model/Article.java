package com.pickclip.pickclip_backend.model;

import com.pickclip.pickclip_backend.dto.ArticleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Article {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(length = 12, nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = true)
    private String video;


    public Article(ArticleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.picture = requestDto.getPicture();
        this.video = requestDto.getVideo();

    }

    public void updateArticle(ArticleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.picture = requestDto.getPicture();
        this.video = requestDto.getVideo();
    }


}
