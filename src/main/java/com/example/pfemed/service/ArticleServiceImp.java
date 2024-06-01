package com.example.pfemed.service;

import com.example.pfemed.models.Article;
import com.example.pfemed.models.Mission;
import com.example.pfemed.repository.ArticleRepository;
import com.example.pfemed.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ArticleServiceImp implements ArticleService{
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private MissionRepository missionRepository ;

    @Override
    public List<Article> AllArticle(Long idM) {
        Mission m = missionRepository.findById(idM).orElse(null);
        if (m != null) {
            return m.getArticles();
        } else {
            return new ArrayList<>();
        }
    }


    @Override
    public Article updateArticle(Article a) {
        return articleRepository.save(a);
    }

    @Override
    public Article getArticleByid(Long idA) {
        return articleRepository.findById(idA).orElse(null);
    }

    @Override
    public Article addArticle(Article a , Long idM) {
        Mission m = missionRepository.findById(idM).orElse(null) ;
        a.setMission(m);
        return articleRepository.save(a);
    }

    @Override
    public void removeArticle(Long idA) {
articleRepository.deleteById(idA);
    }
}
