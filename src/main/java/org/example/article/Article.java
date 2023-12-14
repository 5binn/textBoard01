package org.example.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class Article {
    private int id;
    private String title;
    private String content;
    private String regDate;
    private int memberId;


    Article(Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.title = (String) row.get("title");
        this.content = (String) row.get("content");
        this.regDate = row.get("regDate").toString();
        this.memberId = (int) row.get("memberId");

    }
}
