package org.example.article;

import org.example.Global;

import java.util.List;

public class ArticleController {

    ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void createPost() {
        if (articleService.isLoggedIn()) {
            System.out.println("로그인을 먼저 해주세요.");
            return;
        }
        System.out.print("제목 : ");
        String title = Global.getSc().nextLine();
        System.out.print("내용 : ");
        String content = Global.getSc().nextLine();
        //id에 리포에서 받은거 넣음
        int id = articleService.createPost(title, content);

        System.out.println(id + "번 게시글 등록");
    }

    public void list() {
        System.out.println("번호 | 제목 | 내용 | 작성일 | 회원번호\n----------------------------------------");
        List<Article> articleList = articleService.list();
        for (Article article : articleList) {
            System.out.println(article.getId() + " | " + article.getTitle() + " | " + article.getContent() +
                    " | " + article.getRegDate() + " | " + article.getMemberId());
        }
    }

    public void delete() {
        if (articleService.isLoggedIn()) {
            System.out.println("로그인을 먼저 해주세요.");
            return;
        }
        System.out.println("삭제할 게시글의 번호를 입력하세요.");
        System.out.print("번호 > ");
        int deleteId = Integer.parseInt(Global.getSc().nextLine());
        Article article = articleService.findByArticleId(deleteId);
        if (article == null) {
            System.out.println(deleteId + "번 게시글이 존재하지 않습니다.");
            return;
        }
        if (article.getMemberId() != Global.getLoggedInMember().getId()) {
            System.out.println("작성자만 접근할 수 있습니다.");
            return;
        }
        //id에 리포에서 받은거 넣음
        int id = articleService.delete(deleteId);

        System.out.println(deleteId + "번 게시글을 삭제하였습니다.");
    }

    public void update() {
        if (articleService.isLoggedIn()) {
            System.out.println("로그인을 먼저 해주세요.");
            return;
        }
        System.out.println("수정할 게시글의 번호를 입력하세요.");
        System.out.print("번호 > ");
        int updateId = Integer.parseInt(Global.getSc().nextLine());
        Article article = articleService.findByArticleId(updateId);
        if (article == null) {
            System.out.println(updateId + "번 게시글이 존재하지 않습니다.");
            return;
        }
        if (article.getMemberId() != Global.getLoggedInMember().getId()) {
            System.out.println("작성자만 접근할 수 있습니다.");
            return;
        }
        System.out.println("기존 제목 : " + article.getTitle());
        System.out.print("수정할 제목 : ");
        String updateTitle = Global.getSc().nextLine();
        System.out.println("기존 내용 : " + article.getContent());
        System.out.print("수정할 내용 : ");
        String updateContent = Global.getSc().nextLine();
        //id에 리포에서 받은거 넣음
        int id = articleService.modify(updateTitle, updateContent, updateId);

        System.out.println(updateId + "번 게시글을 수정하였습니다.");
    }

}
