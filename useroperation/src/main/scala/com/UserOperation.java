package com;

import com.DBOperation;
import com.Entity;

import java.sql.ResultSet;
import java.util.Scanner;

public class UserOperation {


    public void operation()
    {
        System.out.println("Hello,Enter your choice");
        Scanner sc = new Scanner(System.in);
        DBOperation db= new DBOperation();
       Entity e = new Entity();
        int ch=0;
        int i=0;
        do{
            System.out.println("1.Add \n2.read\n3.update \n4.delete \n5.List \n6.exit");
            ch=sc.nextInt();


            switch (ch)
            {
                case 1:

                    System.out.println("enter id");
                    e.user_Id = sc.next();
                    System.out.println("enter name");
                     e.user_Name = sc.next();
                    System.out.println("enter age");
                     e.user_Age = sc.nextInt();
                    System.out.println("enter phone no");
                    e.user_phNo = sc.next();

                   db. add(e.user_Id,e.user_Name,e.user_Age,e.user_phNo);
                    break;
               case 2:
                   System.out.println("enter id to read record");
                   e.user_Id=sc.next();
                   db.read(  e.user_Id);
                   break;

                case 3:
                System.out.println("enter id to update record");
                    e.user_Id=sc.next();
                    System.out.println("enter name to update");
                    e.user_Name = sc.next();
                    System.out.println("enter age to update");
                    e.user_Age = sc.nextInt();
                    System.out.println("enter phone no to update");
                    e.user_phNo = sc.next();
                    db.update(  e.user_Id,e.user_Name,e.user_Age,e.user_phNo);
                    break;

                case 4:
                    System.out.println("enter id to delete record");
                      String id1=sc.next();
                      db.delete(id1);

                 case 5:
                  db.list();
                    break;




            }
        } while(ch<6);
    }
}
