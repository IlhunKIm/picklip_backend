package com.pickclip.pickclip_backend.dto;

import lombok.Getter;

@Getter
public class RecommentRequestDto {

    private Long commentId;

    private String username;

    private String contents;

    private String picture;

}
