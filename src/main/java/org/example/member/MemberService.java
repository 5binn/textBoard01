package org.example.member;

import java.util.List;

public class MemberService {
    MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public String signUp(String newId, String newPassword) {
        return memberRepository.signUp(newId, newPassword);
    }

    public Member login(Member idCheckResult) {
        return memberRepository.login(idCheckResult);
    }

    public void logout() {
        memberRepository.logout();
    }

    public Member findByMember(String userId) {
        List<Member> memberList = memberRepository.findByAll();
        for (Member member : memberList) {
            if (member.getUserId().equals(userId)) {
                return member;
            }
        }
        return null;
    }
}

