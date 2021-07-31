package com.pickclip.pickclip_backend.service;

import com.pickclip.pickclip_backend.dto.CommentRequestDto;
import com.pickclip.pickclip_backend.model.Comment;
import com.pickclip.pickclip_backend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void createComment(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);
    }

    @Transactional
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }

    @Transactional
    public void updateComment(Long articleId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findByArticleId(articleId).orElseThrow(
                () -> new NullPointerException("ID not found")
        );
        comment.updateComment(requestDto);
    }

    @Transactional
    public void deleteComment(String username, Long articleId) {
        commentRepository.deleteByUsernameAndArticleId(username, articleId);
    }

//    @Transactional
//    public void deleteComment(Long articleId) {
//        commentRepository.deleteByArticleId(articleId);
//    }


}
