package org.example.article;

import org.example.global.Container;
import org.example.member.Member;

import java.util.List;

public class ArticleController {

    ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void create() {
        boolean check = _loginCheck(Container.getLoginedMember());
        if (check) return;
        System.out.print("제목 : ");
        String title = Container.getSc().nextLine();
        System.out.print("내용 : ");
        String content = Container.getSc().nextLine();

        int id = this.articleService.create(title, content);

        System.out.println(id + "번 게시글이 등록되었습니다.");
    }

    public void list() {
        List<Article> articleList = this.articleService.list();
        System.out.println("번호 | 제목 | 내용 | 작성자 | 작성일\n----------------------------------");
        for (Article article : articleList) {
            System.out.printf("%d | %s | %s | %d | %s\n",
                    article.getId(), article.getTitle(), article.getContent(),
                    article.getMemberId(), article.getRegDate());
        }
    }

    public void delete() {
        boolean check = _loginCheck(Container.getLoginedMember());
        if (check) return;
        System.out.print("삭제할 번호를 입력하세요.\n번호 : ");
        int removeId = Integer.parseInt(Container.getSc().nextLine().trim());
        Article article = this.articleService.getSameArticle(removeId);
        boolean articleCheck = _articleCheck(article);
        if (articleCheck) return;
        //id에 DB에서 수정한 번호 리턴하고 싶은데 못함
        int id = this.articleService.delete(removeId);

        System.out.println(removeId + "번 게시글 삭제");
    }

    public void modify() {
        boolean check = _loginCheck(Container.getLoginedMember());
        if (check) return;
        System.out.print("수정할 번호를 입력하세요.\n번호 : ");
        int modifyId = Integer.parseInt(Container.getSc().nextLine().trim());
        Article article = this.articleService.getSameArticle(modifyId);
        boolean articleCheck = _articleCheck(article);
        if (articleCheck) return;
        System.out.println("기존 제목 : " + article.getTitle());
        System.out.print("수정할 제목 : ");
        String title = Container.getSc().nextLine();
        System.out.println("기존 내용 : " + article.getContent());
        System.out.print("수정할 내용 : ");
        String content = Container.getSc().nextLine();
        //id에 DB에서 수정한 번호 리턴하고 싶은데 못함
        int id = this.articleService.modify(title, content, modifyId);

        System.out.println(modifyId + "번 게시글 수정");
    }

    private boolean _loginCheck(Member loginedMember) {
        if (loginedMember == null) {
            System.out.println("로그인을 먼저 해주세요.");
            return true;
        }
        return false;
    }

    private boolean _articleCheck(Article article) {
        if (article == null) {
            System.out.println("해당 게시글은 존재하지 않습니다.");
            return true;
        }
        if (article.getMemberId() != Container.getLoginedMember().getId()) {
            System.out.println("해당 작성자만 접근할 수 있습니다.");
            return true;
        }
        return false;
    }

}
