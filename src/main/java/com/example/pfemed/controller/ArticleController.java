package com.example.pfemed.controller;

import com.example.pfemed.models.Article;
import com.example.pfemed.models.Mission;
import com.example.pfemed.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/Article")
public class ArticleController {
    private ArticleService articleService;
    @PostMapping("/add/{id}")
    public ResponseEntity<Article> addArticle(@RequestBody Article a , @PathVariable Long id )
    {
        Article addedArticle = articleService.addArticle(a,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedArticle);
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<List<Article>> getAllArticle(@PathVariable Long id) {
        List<Article> articles = articleService.AllArticle(id);
        return ResponseEntity.ok(articles);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article a) {
        a.setId(id);
        Article updatedArticle = articleService.updateArticle(a);
        return ResponseEntity.ok(updatedArticle);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        articleService.removeArticle(id);
        return ResponseEntity.ok("Article deleted successfully");
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article Article = articleService.getArticleByid(id);
        return ResponseEntity.ok(Article);
    }
}
