package com.pickclip.pickclip_backend.repository;

import com.pickclip.pickclip_backend.model.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {

    List<Recomment> findAll();

    void deleteByUsernameAndCommentId(String username, Long commentId);
//    List<Recomment> findAllByUsernameAndCommentId(String username, Long commentId);

    Optional<Recomment> findByCommentId(Long commentId);

//    void deleteByCommentId(Long commentId);

}
