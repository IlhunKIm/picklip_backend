package com.pickclip.pickclip_backend.service;

import com.pickclip.pickclip_backend.dto.ArticleRequestDto;
import com.pickclip.pickclip_backend.model.Article;
import com.pickclip.pickclip_backend.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void createArticle(ArticleRequestDto requestDto) {
        Article article = new Article(requestDto);
        articleRepository.save(article);
    }

    @Transactional
    public List<Article> getArticle() {
        return articleRepository.findAll();
    }

    @Transactional
    public void updateArticle(Long articleId, ArticleRequestDto requestDto) {
        Article article = articleRepository.findById(articleId).orElseThrow(
                () -> new NullPointerException("ID not found")
        );
        article.updateArticle(requestDto);
    }

    @Transactional
    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }
}
