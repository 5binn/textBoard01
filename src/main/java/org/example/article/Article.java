package org.example.article;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class Article {
    private int id;
    private String title;
    private String content;
    private String regDate;
    private int memberId;
    private String userId;

    Article(Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.title = (String) row.get("title");
        this.content = (String) row.get("content");
        this.regDate = row.get("regDate").toString();
        this.memberId = (int) row.get("memberId");
        this.userId = (String) row.get("userId");
    }
    /*Article(Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.title = (String) row.get("title");
        this.content = (String) row.get("content");
        this.regDate = row.get("regDate").toString();
        this.memberId = (int) row.get("memberId");
    }*/


}
