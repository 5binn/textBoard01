package org.example.global;


import lombok.Getter;
import org.example.DB.DBConnection;
import org.example.member.Member;

import java.time.LocalDate;
import java.util.Scanner;

public class Container {
    @Getter
    static private Scanner sc;
    @Getter
    static private Member loginedMember;
    private static DBConnection dbConnection;
    @Getter
    public static LocalDate now = LocalDate.now();

    public static void initScanner() {
        sc = new Scanner(System.in);
    }

    public static void closeScanner() {
        sc.close();
    }

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public static void setLoginedMember(Member loginedMember1) {
        loginedMember = loginedMember1;
    }
}

