package org.example.article;

import org.example.global.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {


    public int create(String title, String content) {
        String sql = String.format("INSERT INTO article SET title = '%s', content = '%s' , memberId = %d , regDate = now()",
                title, content, Container.getLoginedMember().getId());
        return Container.getDBConnection().insert(sql);
    }
    public List<Article> list() {
        List<Article> articleList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("SELECT * FROM article");
        for (Map<String, Object> row : rows) {
            Article article = new Article(row);
            articleList.add(article);
        }
        return articleList;
    }
    public int delete(int id) {
        String sql = String.format("DELETE FROM article WHERE id = %d",id);
        return Container.getDBConnection().delete(sql);
    }
    public int modify(String title, String content, int id) {
        String sql = String.format("UPDATE article SET title = '%s', content = '%s' WHERE id = %d",
                title, content, id);
        return Container.getDBConnection().update(sql);
    }
    public Article getSameArticle(int id) {
        List<Article> articleList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("SELECT * FROM article");
        for (Map<String, Object> row : rows) {
            Article article = new Article(row);
            articleList.add(article);
        }
        for (Article value : articleList) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }
}
