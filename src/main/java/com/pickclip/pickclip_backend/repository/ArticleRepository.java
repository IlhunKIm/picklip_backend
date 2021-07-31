package com.pickclip.pickclip_backend.repository;

import com.pickclip.pickclip_backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAll();



}
