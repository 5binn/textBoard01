package org.example.article;

import org.example.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    List<Article> articleList = new ArrayList<>();
    int lastArticleId = 1;

    public int createPost(String title, String content) {
        String sql = String.format("""
                INSERT INTO article
                SET title = '%s',
                content = '%s',
                regDate = '%s',
                memberId = %d;""", title, content, Global.nowDateTime(), Global.getLoggedInMember().getId());
        int id = Global.getDBConnection().insert(sql);
        Article article = new Article(lastArticleId, title, content,
                Global.nowDateTime(), Global.getLoggedInMember().getId());
        articleList.add(article);
        this.lastArticleId++;
        return article.getId();
    }

    public List<Article> list() {
        List<Article> articleList = new ArrayList<>();
        List<Map<String, Object>> rows = Global.getDBConnection().selectRows("SELECT * FROM article");
        for (Map<String, Object> row : rows) {
            Article article = new Article(row);
            articleList.add(article);
        }
        return articleList;
    }

    public int delete(int deleteId) {
        String sql = String.format("DELETE FROM article WHERE id = %d;", deleteId);

        return Global.getDBConnection().delete(sql);
    }

    public int modify(String title, String content, int updateId) {
        String sql = String.format("UPDATE article SET title = '%s', content = '%s', regDate = NOW()," +
                "memberId = %d WHERE id = %d;", title, content, Global.getLoggedInMember().getId(), updateId);

        return Global.getDBConnection().update(sql);
    }


}



