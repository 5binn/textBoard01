package org.example.member;

import org.example.global.Container;

public class MemberController {

    MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }

    public void create() {
        String userId;
        String password;
        while (true) {
            System.out.print("ID 입력 : ");
            String id = Container.getSc().nextLine().trim();
            Member checkedMember = this.memberService.getSameIdCheck(id);
            if (checkedMember != null) {
                System.out.println("중복된 아이디가 존재합니다.");
            } else {
                userId = id;
                break;
            }
        }
        while (true) {
            System.out.print("비밀번호 입력 : ");
            String passwordCheck1 = Container.getSc().nextLine().trim();
            System.out.print("비밀번호 확인 : ");
            String passwordCheck2 = Container.getSc().nextLine().trim();
            if (!passwordCheck1.equals(passwordCheck2)) {
                System.out.println("비밀번호를 확인하고 다시 입력하세요.");
            } else {
                password = passwordCheck1;
                break;
            }
        }
        String id = this.memberService.create(userId, password);

        System.out.println(id + "님 가입을 환영합니다.");
    }

    public void logIn() {
        if (Container.getLoginedMember() != null) {
            System.out.println("현재 " + Container.getLoginedMember().getUserId() + " 님이 로그인 중입니다.");
            return;
        }
        System.out.print("아이디 : ");
        String loginId = Container.getSc().nextLine().trim();
        System.out.print("비밀번호 : ");
        String loginPassword = Container.getSc().nextLine().trim();
        Member checkedMember = this.memberService.getSameIdCheck(loginId);
        boolean logInCheck = this.memberService.getFindById(checkedMember, loginPassword);
        if (logInCheck) return;
        this.memberService.login(checkedMember);
        System.out.println(Container.getLoginedMember().getUserId() + "님 환영합니다.");
    }

    public void logOut() {
        this.memberService.logOut();
    }

}
