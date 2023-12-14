package org.example.article;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int create(String title, String content) {
        return this.articleRepository.create(title, content);
    }

    public List<Article> findByAll() {
        return this.articleRepository.findByAll();
    }

    public int delete(int id) {
        return this.articleRepository.delete(id);
    }

    public int modify(String title, String content, int id) {
        return this.articleRepository.modify(title, content, id);
    }

    public Article getSameArticle(int id) {
        return this.articleRepository.getSameArticle(id);
    }
}
