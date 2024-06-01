package com.example.pfemed.service;

import com.example.pfemed.models.Article;


import java.util.List;

public interface ArticleService {
    List<Article> AllArticle( Long idM);

    Article updateArticle(Article a);

    Article getArticleByid(Long idA);

    Article addArticle(Article a , Long idM);

    void removeArticle(Long idA);
}
