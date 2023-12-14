package org.example.member;

import org.example.global.Container;

public class MemberService {

    MemberRepository memberRepository;

    MemberService() {
        memberRepository = new MemberRepository();
    }

    public String create(String userId, String password) {
        return memberRepository.create(userId, password);
    }
    public void login(Member checkedMember) {
        Container.setLoginedMember(checkedMember);
    }
    public void logOut() {
        if (Container.getLoginedMember() == null) {
            System.out.println("로그인을 먼저 해주세요.");
            return;
        }
        Container.setLoginedMember(null);
        System.out.println("로그아웃 되었습니다.");
    }
    public Member getSameIdCheck(String id) {
        return memberRepository.getSameIdCheck(id);
    }

    public boolean getFindById(Member checkedMember, String loginPassword) {
        if (checkedMember == null) {
            System.out.println("해당 아이디는 존재하지 않습니다.");
            return true;
        } else if (!checkedMember.getPassword().equals(loginPassword)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return true;
        }return false;
    }
}
