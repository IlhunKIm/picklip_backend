package com.pickclip.pickclip_backend.controller;

import com.pickclip.pickclip_backend.dto.CommentRequestDto;
import com.pickclip.pickclip_backend.model.Comment;
import com.pickclip.pickclip_backend.repository.CommentRepository;
import com.pickclip.pickclip_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("user/comment") // 댓글 보기
    public List<Comment> getComment() {
        return commentService.getComment();
    }

    @PostMapping("user/comment") // 댓글 작성
    public void createComment(@RequestBody CommentRequestDto requestDto) {
        commentService.createComment(requestDto);
    }

    @PutMapping("/user/comment/{articleId}") // 댓글 수정하기대댓글 수정(id번호가 아니라 articleId 번호를 입력하여 수정)
    public void updateComment(@PathVariable Long articleId, @RequestBody CommentRequestDto requestDto) {
        commentService.updateComment(articleId, requestDto);
    }

    @DeleteMapping("/user/comment/{username}/{articleId}") // 댓글 삭제 username + articleId
    public void deleteComment(@PathVariable String username, @PathVariable Long articleId) {
        commentService.deleteComment(username, articleId);
    }

//    @DeleteMapping("/user/comment/{articleId}") //댓글 삭제
//    public void deleteComment(@PathVariable Long articleId) {
//        commentService.deleteComment(articleId);
//    }


}
