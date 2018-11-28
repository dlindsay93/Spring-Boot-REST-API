package main;

import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public List<Article> getAllArticles(){

        return articleService.getAllArticles();
    }

    @RequestMapping("/articles/{id}")
    public Article getArticle(@PathVariable String id){
        return articleService.getAtricle(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/article")
    public void addArticle(@RequestBody Article article){
        articleService.addArticle(article);
    }
    @RequestMapping(method = RequestMethod.PUT, value ="/article/{id}")
    public void updateArticle(@RequestBody Article article, @PathVariable String id){
        articleService.updateArticle(article,id);

    }

    @RequestMapping(method = RequestMethod.PUT, value ="/article/{id}")
    public void deleteArticle(@PathVariable String id){
        articleService.deleteArticle(id);

    }

}

