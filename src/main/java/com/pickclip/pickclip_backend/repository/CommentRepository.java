package com.pickclip.pickclip_backend.repository;

import com.pickclip.pickclip_backend.model.Article;
import com.pickclip.pickclip_backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();

    void deleteByUsernameAndArticleId(String username, Long articleId);
//    List<Comment> findAllByUsernameAndArticleId(String username, Long commentId)

    Optional<Comment> findByArticleId(Long ArticleId);

//    void deleteByArticleId(Long articleId);

}
