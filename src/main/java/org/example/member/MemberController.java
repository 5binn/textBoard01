package org.example.member;

import org.example.Global;

public class MemberController {
    MemberService memberService;
    public MemberController() {
        memberService = new MemberService();
    }

    public void signUp() {
        String newID;
        String newPassword;
        System.out.println("회원가입을 진행합니다.");
        System.out.print("ID : ");
        String targetId = Global.getSc().nextLine();
        Member idCheckResult = memberService.findByMember(targetId);
        if (idCheckResult != null) {
            System.out.println("중복된 ID가 존재합니다.");
            return;
        } else {
            newID = targetId;
        }
        System.out.print("PASSWORD : ");
        String password = Global.getSc().nextLine();
        System.out.print("PASSWORD확인 : ");
        String passwordCheck = Global.getSc().nextLine();
        if (password.equals(passwordCheck)) {
            newPassword = password;
        } else {
            System.out.println("비밀번호를 확인하고 다시 입력해주세요.");
            return;
        }
        String id = memberService.signUp(newID, newPassword);
        System.out.println(id + "님의 가입을 환영합니다.");
    }

    public void login() {
        if (Global.getLoggedInMember() != null) {
            System.out.println(Global.getLoggedInMember().getUserId() + "님이 로그인중입니다.");
            return;
        }
        System.out.print("ID : ");
        String targetId = Global.getSc().nextLine();
        System.out.print("PASSWORD : ");
        String targetPassword = Global.getSc().nextLine();

        Member idCheckResult = memberService.findByMember(targetId);

        if (idCheckResult == null) {
            System.out.println("해당 ID는 존재하지 않습니다.");
            return;
        } else if (!idCheckResult.getPassword().equals(targetPassword)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }

        Member member= memberService.login(idCheckResult);

        System.out.println(member.getUserId() + "님 환영합니다.");
    }

    public void logout() {
        if (Global.getLoggedInMember() == null) {
            System.out.println("로그인을 먼저 해주세요.");
            return;
        }
        memberService.logout();
        System.out.println("로그아웃 되었습니다.");
    }




}
