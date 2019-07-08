package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn =
                         DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                 "root", "new-password")) {


                Statement st = conn.createStatement();
                int a=st.executeUpdate("insert into userinfo1 values("+user_Id+",'"+user_Name+"',"+user_Age+",'"+user_phNo+"')");

                if (a > 0)
                    System.out.println("Successfully Inserted");
                else
                    System.out.println("Insert Failed");


            }
        } catch (Exception e) {
            System.err.println("Something went wrong!");
            e.printStackTrace();
        }


    }
    public void delete(String id) {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn =
                         DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                 "root", "new-password")) {


                Statement st = conn.createStatement();

                int a=st.executeUpdate("DELETE FROM userinfo1 WHERE id="+id+"");


                if (a > 0)
                    System.out.println("Successfully Deleted");
                else
                    System.out.println("Deletion Failed");

            }
        } catch (Exception e) {
            System.err.println("Something went wrong!");
            e.printStackTrace();
        }
    }
    public void read(String id) {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn =
                         DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                 "root", "new-password")) {


                Statement st = conn.createStatement();

               ResultSet rs = st.executeQuery("select * from userinfo1 where id='" + id + "'");
                if (rs.next()) {
                    System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getString(4));
                } else {
                    System.out.println("No such user id is already registered");
                }
            }
        } catch (Exception e) {
            System.err.println("e");
            e.printStackTrace();
        }
    }
        public void update(String id, String user_Name,int user_Age,String user_phNo) {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                try (Connection conn =
                             DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                     "root", "new-password")) {



                    Statement st = conn.createStatement();

                    int i=st.executeUpdate("UPDATE userinfo1 SET  name='"+user_Name+"', age="+user_Age+",phno='"+user_phNo+"' WHERE id='"+id+"'");

                    if (i > 0)
                        System.out.println("Record Updated Successfully ");
                    else
                        System.out.println("ERROR OCCURED :(");
                }
            } catch (Exception e) {
                System.err.println("Something went wrong!");
                e.printStackTrace();
            }

        }

    public void list() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn =
                         DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata",
                                 "root", "new-password")) {


                Statement st = conn.createStatement();


               ResultSet rs = st.executeQuery("select * from userinfo1");
                while(rs.next()) {
                    System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getString(4));
                }
            }
        } catch (Exception e) {
            System.err.println("e");
            e.printStackTrace();
        }
    }




}
