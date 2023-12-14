package org.example.article;

import org.example.Global;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public int createPost(String title, String content) {
        return articleRepository.createPost(title, content);
    }

    public List<Article> list() {
        return articleRepository.list();
    }

    public int delete(int deleteId) {
        return articleRepository.delete(deleteId);
    }

    public int modify(String title, String content, int updateId) {
        return articleRepository.modify(title, content, updateId);
    }

    public Article findByArticleId(int id) {
        List<Article> articleList = articleRepository.list();
        for (Article article : articleList) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public boolean isLoggedIn() {
        if (Global.getLoggedInMember() != null) {
            return false;
        }
        return true;
    }
}
