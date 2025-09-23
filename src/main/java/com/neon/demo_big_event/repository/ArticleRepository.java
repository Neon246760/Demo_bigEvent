package com.neon.demo_big_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neon.demo_big_event.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
    
}
