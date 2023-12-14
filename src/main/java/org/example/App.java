package org.example;

import org.example.DB.DBConnection;
import org.example.article.ArticleController;
import org.example.global.Container;
import org.example.member.MemberController;

public class App {
    private final ArticleController articleController;
    private final MemberController memberController;

    App() {
        DBConnection.DB_NAME = "textBoard";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.getDBConnection().connect();

        articleController = new ArticleController();
        memberController = new MemberController();
    }

    public void run() {
        System.out.println("=== 시스템 시작 ===");
        while (true) {
            System.out.print("명령 > ");
            String command = Container.getSc().nextLine().trim();
            switch (command) {
                case "종료":
                    Container.getSc().close();
                    return;
                case "등록":
                    articleController.create();
                    break;
                case "목록":
                    articleController.list();
                    break;
                case "삭제":
                    articleController.delete();
                    break;
                case "수정":
                    articleController.modify();
                    break;
                case "회원가입":
                    memberController.create();
                    break;
                case "로그인":
                    memberController.logIn();
                    break;
                case "로그아웃":
                    memberController.logOut();
                    break;
            }
        }

    }
}