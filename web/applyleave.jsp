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
            select
            {
                height: 27px;
                width:157px;
            }
            
            
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
      
        %>
        <form method="post" action="applyleave">
        <table style="margin-left:40px;">
            <tr><td>Leave Type</td><td><select name="leavetype">        
    <option selected value="0">Select Leave Type</option>
    <option value="CL">Casual Leave</option>
    <option value="EL">Earned Leave</option>
   <option value="SL">Sick Leave</option>
   <!-- <option value="hr">HR Manager</option>
    <option value="manager">General Manager</option>-->
    </select> </td></tr>
            <tr><td>Start Date<br>(YYYY-MM-DD)</td><td><input type="date" name="start"></td></tr>
            <tr><td>End Date<br>(YYYY-MM-DD)</td><td><input type="date" name="end"></td>
            </tr>
            <tr><td>Total no of days</td><td><input type="text" name="totaldays"></td>
            </tr>
            <tr><td>Reason</td><td><input type="text" name="reason" style="width:450px"></td>
            </tr>
            <tr><td/><td><button class="btn" type="submit">Apply</button></td>
         </tr>
        </table>
        </form></div></body></html>
        <%
    
 }
        else
 {
     response.sendRedirect("index.jsp?id=Your session may be expired. You have to login first");

    
 }
 
        %>
    </body>
</html>
