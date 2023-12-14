package org.example.member;

import org.example.global.Container;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<Member> memberList = new ArrayList<>();
    int lastMemberId = 1;
    public MemberRepository() {
        Member member1 = new Member(1, "user1", "1234", LocalDate.now().toString());
        memberList.add(member1);
        Member member2 = new Member(2, "user2", "1234", LocalDate.now().toString());
        memberList.add(member2);
        Member member3 = new Member(3, "user3", "1234", LocalDate.now().toString());
        memberList.add(member3);
    }
    public String create(String userId, String password) {
        Member member = new Member(lastMemberId, userId, password, Container.getNow().toString());
        memberList.add(member);
        lastMemberId++;
        return userId;
    }

    public Member getSameIdCheck(String id) {
        for (Member member : memberList) {
            if (id.equals(member.getUserId())) {
                return member;
            }
        }
        return null;
    }
}
