package org.example.member;

import org.example.global.Container;

import java.util.List;

public class MemberService {

    MemberRepository memberRepository;

    MemberService() {
        memberRepository = new MemberRepository();
    }

    public String create(String userId, String password) {
        return memberRepository.create(userId, password);
    }
    public void remove() {
        memberRepository.remove();
    }
    public void login(Member checkedMember) {
        Container.setLoginedMember(checkedMember);
    }
    public boolean logOut() {
        if (Container.getLoginedMember() == null) {
            return true;
        }
        Container.setLoginedMember(null);
        return false;
    }
    public Member getSameIdCheck(String id) {
        return memberRepository.getSameIdCheck(id);
    }
    public List<Member> findByAll() {
        return memberRepository.findByAll();
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
