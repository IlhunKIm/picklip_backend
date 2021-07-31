package com.pickclip.pickclip_backend.service;

import com.pickclip.pickclip_backend.dto.RecommentRequestDto;
import com.pickclip.pickclip_backend.model.Recomment;
import com.pickclip.pickclip_backend.repository.RecommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecommentService {

    private final RecommentRepository recommentRepository;

    @Transactional
    public void createRecomment(RecommentRequestDto requestDto) {
        Recomment recomment = new Recomment(requestDto);
        recommentRepository.save(recomment);
    }

    public List<Recomment> getRecomment() {
        return recommentRepository.findAll();
    }

    @Transactional
    public void updateRecomment(Long commentId, RecommentRequestDto requestDto) {
        Recomment recomment = recommentRepository.findByCommentId(commentId).orElseThrow(
                () -> new NullPointerException("ID not found")
        );
        recomment.updateRecomment(requestDto);

    }

    @Transactional
    public void deleteRecomment(String username, Long commentId) {
        recommentRepository.deleteByUsernameAndCommentId(username, commentId);
    }

//    @Transactional
//    public void deleteRecomment(Long commentId) {
//        recommentRepository.deleteByCommentId(commentId);
//    }


}
