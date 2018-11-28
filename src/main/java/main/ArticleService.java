package main;

import model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Service
public class ArticleService {

  List<Article> articleList = new ArrayList<Article>(Arrays.asList(
                new Article(  "1",  "Article 01",  "Description 01"),
                new Article(  "2",  "Article 02",  "Description 02"),
                new Article(  "3",  "Article 03",  "Description 03")
        ));

        public List<Article> getAllArticles() {
            return articleList;
        }

        public Article getAtricle(String id){
            return articleList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        }

        public void addArticle(Article article){
            articleList.add(article);
        }

    public void updateArticle(Article art, String id) {
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);

            if (article.getId().equals(id)) {
                articleList.set(i, art);
            }
        }
    }

    public void deleteArticle(String id){
            articleList.removeIf(t ->t.getId().equals(id));
    }
}
