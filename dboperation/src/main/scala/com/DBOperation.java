package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBOperation
{
    String user_Id;
    String user_Name;
    int user_Age;
    String user_phNo;

    public void add(String user_Id, String user_Name,int user_Age,String user_phNo) {
        this.user_Id= user_Id;
        this.user_Name= user_Name;
        this.user_Age= user_Age;
        this.user_phNo= user_phNo;
        try {
            System.out.println("ajsjbdkjasnda");
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn =
                         DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                 "root", "new-password")) {


                Statement st = conn.createStatement();
                int a=st.executeUpdate("insert into userinfo1 values("+user_Id+",'"+user_Name+"',"+user_Age+",'"+user_phNo+"')");



            }
        } catch (Exception e) {
            System.err.println("Something went wrong!");
            e.printStackTrace();
        }
        System.out.println("ajsjbdkjasnda");




    }

}
