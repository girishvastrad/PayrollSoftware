<%-- 
    Document   : actualupdate
    Created on : Mar 14, 2015, 10:21:42 PM
    Author     : Parth_Lathiya
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" media="screen,projection" type="text/css" href="./main.css" />
        <style>
          
            img
            {
                width:150px;
                height:50px;
                margin-left: 70px;
                margin-top: -5px;
            }
            strong
            {
            position: absolute;
            right: 15px;
            top :35px
                
            }
           
            td{padding-left: 10px}
        </style>
    </head>
    <body>
        <img src="cc.jpg">
           <strong><% out.println("Welcome "+session.getAttribute("username"));%></strong>
        
           <div class="well">  <ul>
  <li><a href="generatepayslip.jsp">View Pay-Slip</a></li>
  <li><a href="actualupdate.jsp">Update Employee</a></li>
  <li><a href="applyleave.jsp">Apply Leave</a></li>
  <li><a href="logout">Logout</a></li>
  </ul>
        </div>

        <div class="well1">
        <%
  
     //  HttpSession session=request.getSession();
 if(session.getAttribute("username")!=null)           
 {
      //    PrintWriter out = response.getWriter() ;
        String id = (String)session.getAttribute("id");
        String usertype = (String)session.getAttribute("usertype");
 try {       
      Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll123","root","");
     //(FirstName,LastName,ID,DOB,Designation) 
           
            PreparedStatement ps = con.prepareStatement("select * from "+usertype+" where id=?");
            ps.setString(1, id);
               ResultSet rs = ps.executeQuery();
            rs.next();
            
        %>
        <form method="post" action="update">
        <table style="margin-left:5px;align-content:center;width:100%;margin-top: 30px;border-spacing: 0.9em;font-family: tahoma">
            <tr><td>Employee ID</td><td><input type="text" clospan="7" name="empid" value="<%= rs.getString(1)%>"  disabled></td></tr>
            <tr><td>Salutation</td><td><input type="text" name="sal" value="<%= rs.getString(2)%>"></td>
            <td>First Name</td><td><input type="text" name="fname" Value="<%= rs.getString(3)%>"  disabled></td>
            <td>Middle Name</td><td><input type="text" name="mname" value="<%= rs.getString(4)%>"  disabled></td>
            <td>Last Name</td><td><input type="text" name="lname" value="<%= rs.getString(5)%>"  disabled></td></tr>
            <tr><td>Date Of Birth<br>(YYYY-MM-DD)</td><td><input type="date" name="dob" value="<%= rs.getDate(6)%>"  disabled></td>
            <td>Phone No</td><td><input type="text" name="phoneno" value="<%= rs.getString(7)%>"></td>
            <td>Email Id</td><td><input type="email" name="email" value="<%= rs.getString(8)%>"></td>
            <td>Date Of Joining<br>(YYYY-MM-DD)</td><td><input type="date" name="doj" value="<%= rs.getDate(10)%>"  disabled></td></tr>
            <tr><td>Designation</td><td><input type="text" name="designation" value="<%= rs.getString(9)%>"  disabled></td>
            <td>Bank Name</td><td><input type="text" name="bankname" value="<%= rs.getString(11)%>"  disabled></td>
            <td>Account No</td><td><input type="text" name="accno" value="<%= rs.getInt(12)%>"  disabled></td>
            <td></td><td></td></tr>
            <tr><td>Branch Name</td><td><input type="text" name="branchname" value="<%= rs.getString(13)%>"  disabled></td>
            <td>Department</td><td><input type="text" name="dep" value="<%= rs.getString(14)%>"  disabled></td>
            <td></td><td></td>
            <td></td><td></td></tr>
            <tr><td/><td><button class="btn" type="submit">Update</button></td>
            <td></td>
            <td></td>
            <td></td></tr>
        </table>
        </form></div></body></html>
        <%
      rs.close();
        ps.close();
        con.close();
      }catch(Exception e){System.out.println(e);}

 }
        else
 {
     response.sendRedirect("index.jsp?id=Your session may be expired. You have to login first");

    
 }
 
        %>
    </body>
</html>
