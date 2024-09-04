package com.springBootTest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootTest.Beans.Article;
import com.springBootTest.Services.ArticleService;


@RestController
@RequestMapping(path = "/api/article")
public class ArticleController {

	private final ArticleService articleService;
	
	@Autowired
	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	
	@GetMapping(path = "/all")
	public List<Article> getArticles(){
		return articleService.getArticles();
	}
	
	@PostMapping
	public String setArticle(@RequestBody Article article) {
		Article a=articleService.addArticle(article);
		if(a != null)
			return "Article added"; 
		return "Problem while adding article ot existing one";
	}
	
    @PutMapping("update/{id}")
    public String updateClient(@PathVariable("id") int id, @RequestBody Article updatedArticle) {
        boolean success = articleService.updateArticle(id, updatedArticle);
        return success ? "Client updated successfully!" : "Client not found!";
    }
    
    @DeleteMapping(path = "delete/{id}")
    public String deleteArticle(@PathVariable("id") int id) {
    	Article a=articleService.findArticle(id);
    	
    	if(a==null)
    		return "Missing article";
    	articleService.deleteArticle(a);
    	return "Deleted article";
    }
    
	
	
	
}
