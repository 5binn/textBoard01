package org.example;

import lombok.Getter;
import org.example.DB.DBConnection;
import org.example.member.Member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Global {
    @Getter
    private static Scanner sc;
    @Getter
    private static Member loggedInMember;

    private static DBConnection dbConnection;
    public static void initScanner() {
        sc =new Scanner(System.in);
    }
    public static void exitScanner() {
        sc.close();
    }

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public static void setLoggedInMember(Member member) {
        loggedInMember = member;
    }

    public static String nowDateTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        return format.format(time);
    }
}
