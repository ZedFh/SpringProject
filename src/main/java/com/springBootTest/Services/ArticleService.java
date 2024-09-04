package com.springBootTest.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootTest.Beans.Article;
import com.springBootTest.Repositories.ArticleRepository;

import jakarta.transaction.Transactional;

@Service
public class ArticleService {
	
	private final ArticleRepository articleRepository;

	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}
	
	public List<Article> getArticles(){
		return articleRepository.findAll();
	}
	
	public Article addArticle(Article a) {
		return articleRepository.save(a);
	}
	
	public void deleteArticle(Article a){
		articleRepository.delete(a);
	}
	
	public Article findArticle(int id){
		Optional<Article> a = articleRepository.findById(id);
		return a.isPresent() ? a.get() : null ;
	}
	
	
	@Transactional
	public boolean updateArticle(int id, Article updatedArticle) {
		Article a= findArticle(id);
		
		if(a==null)
			return false;
		
		if(updatedArticle.getName()!=null)
			a.setName(updatedArticle.getName());

		if(updatedArticle.getMasse()>0)
			a.setMasse(updatedArticle.getMasse());
		
		if(updatedArticle.getPrice()>0)
			a.setPrice(updatedArticle.getPrice());
		
		if(updatedArticle.getStock()>0)
			a.setStock(updatedArticle.getStock());
			

		return true;
	}

}
