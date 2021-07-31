package com.pickclip.pickclip_backend.controller;

import com.pickclip.pickclip_backend.dto.RecommentRequestDto;
import com.pickclip.pickclip_backend.model.Recomment;
import com.pickclip.pickclip_backend.repository.RecommentRepository;
import com.pickclip.pickclip_backend.service.RecommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RecommentController {

    private final RecommentRepository recommentRepository;
    private final RecommentService recommentService;

    @GetMapping("/user/recomment") // 대댓글 보기
    public List<Recomment> getRecomment() {
        return recommentService.getRecomment();
    }

    @PostMapping("/user/recomment") // 대댓글 작성
    public void createRecomment(@RequestBody RecommentRequestDto requestDto) {
        recommentService.createRecomment(requestDto);
    }

    @PutMapping("/user/recomment/{commentId}") // 대댓글 수정(id번호가 아니라 commentId 번호를 입력하여 수정)
    public void updateRecomment(@PathVariable Long commentId, @RequestBody RecommentRequestDto requestDto) {
        recommentService.updateRecomment(commentId, requestDto);
    }

    @DeleteMapping("/user/recomment/{username}/{commentId}") // 대댓글 삭제 username + commentId
    public void deleteRecomment(@PathVariable String username, @PathVariable Long commentId) {
        recommentService.deleteRecomment(username, commentId);
    }

//    @DeleteMapping("/user/recomment/{commentId}") // 대댓글 삭제
//    public void deleteRecomment(@PathVariable Long commentId) {
//        recommentService.deleteRecomment(commentId);
//    }


}
