package org.example.member;

import org.example.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    List<Member> memberList = new ArrayList<>();
    int lastMemberId = 1;

    public String signUp(String newID, String newPassword) {
        String sql = String.format("""
                INSERT INTO `member`
                SET userId = '%s',
                `password` = '%s',
                regDate = '%s';""", newID, newPassword, Global.nowDateTime());
        int id = Global.getDBConnection().insert(sql);

        Member member = new Member(lastMemberId, newID, newPassword, Global.nowDateTime());
        memberList.add(member);
        lastMemberId++;
        return member.getUserId();
    }
    public Member login(Member idCheckResult) {
        Global.setLoggedInMember(idCheckResult);
        return Global.getLoggedInMember();
    }
    public void logout() {
        Global.setLoggedInMember(null);
    }
    public List<Member> findByAll() {
        List<Member> memberList1 = new ArrayList<>();
        List<Map<String, Object>> rows = Global.getDBConnection().selectRows("SELECT * FROM `member`");
        for (Map<String, Object> row : rows) {
            Member member = new Member(row);
            memberList1.add(member);
        }
        return memberList1;
    }

}
