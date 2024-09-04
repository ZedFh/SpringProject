package com.springBootTest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootTest.Beans.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
