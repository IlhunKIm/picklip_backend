package com.pickclip.pickclip_backend.controller;

import com.pickclip.pickclip_backend.dto.ArticleRequestDto;
import com.pickclip.pickclip_backend.model.Article;
import com.pickclip.pickclip_backend.repository.ArticleRepository;
import com.pickclip.pickclip_backend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @GetMapping("/user/article") // 게시글 보기
    public List<Article> getArticle() {
        return articleService.getArticle();
    }

    @PostMapping("/user/article") // 게시글 작성
    public void createArticle(@RequestBody ArticleRequestDto requestDto) {
        articleService.createArticle(requestDto);
    }

    @PutMapping("/user/article/{id}") // 게시글 수정
    public void updateArticle(@PathVariable Long id, @RequestBody ArticleRequestDto requestDto) {
        articleService.updateArticle(id, requestDto);
    }

    @DeleteMapping("/user/article/{id}") // 게시글 삭제
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }


}
