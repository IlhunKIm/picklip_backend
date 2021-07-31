package com.pickclip.pickclip_backend.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private Long articleId;

    private String username;

    private String contents;

    private String picture;


}
