package org.example.member;

import org.example.global.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    public String create(String userId, String password) {
        String sql = String.format("INSERT INTO `member` SET userId = '%s', `password` = '%s' ,regDate = now()",
                userId, password);
        Container.getDBConnection().insert(sql);
        return userId;
    }
    public void remove() {
        String sql = String.format("DELETE FROM `member` WHERE id = %d", Container.getLoginedMember().getId());
        Container.getDBConnection().delete(sql);
        Container.setLoginedMember(null);
    }
    public List<Member> findByAll() {
        List<Member> memberList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("SELECT * FROM `member`");
        for (Map<String, Object> row : rows) {
            Member member = new Member(row);
            memberList.add(member);
        }
        return memberList;
    }

    public Member getSameIdCheck(String id) {
        List<Member> memberList = this.findByAll();
        for (Member member : memberList) {
            if (id.equals(member.getUserId())) {
                return member;
            }
        }
        return null;
    }
}
