/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jdbc;
import java.sql.*;
/**
 *
 * @author Parth_Lathiya
 */
public class Jdbc {
    public static void main(String[] args)
    {
        try
        {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Statement stmt;
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
    stmt=con.createStatement();
    ResultSet rs1=stmt.executeQuery("select * from Employee");
    while(rs1.next())
       {
        System.out.println("First Name : "+rs1.getString(1));
        System.out.println("Last Name : "+rs1.getString(2));
        System.out.println("ID : "+rs1.getString(3));
        System.out.println("DOB : "+rs1.getDate(4));
        System.out.println("Phone No : "+rs1.getString(5));
        System.out.println("Designation : "+rs1.getString(6));
      //  ResultSet rs2=stmt.executeQuery("select * from salary where EmployeeID=rs1.getString(3)");
        //System.out.println("Salary : "+rs2.getInt(1));                          
       }
    stmt.close();
    }
    catch(Exception e)
    {
    System.out.println(e);
    }
    }
}
