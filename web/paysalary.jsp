    <%-- 
    Document   : generatepayslip
    Created on : Mar 12, 2015, 1:28:55 PM
    Author     : Parth_Lathiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen,projection" type="text/css" href="./main.css" />
        <style>
            input[type="text"], input[type="password"],select{
                height:20px;
                width: 175px;
            margin-left: 10px;
            }
            select
            {
                height: 30px;
                width:150px;
            }
            
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
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <% if(session.getAttribute("username")!=null){ %>
        <img src="cc.jpg">
           <strong><% out.println("Welcome "+session.getAttribute("username"));%></strong>
        
  <div class="well">  <ul>
  <li><a href="generatepayslipbyacc1.jsp">Generate Pay-Slip</a></li>
  <li><a href="generatereportbyacc1.jsp">Generate Report</a></li>
  <li><a href="add2.jsp">Add Employee</a></li>
  <li><a href="updatebyacc1.jsp">Update Employee</a></li>
  <li><a href="paysalary.jsp">Pay Salary</a></li>
  <li><a href="displayemployee1">View Employee List</a></li>
  <li><a href="logout">Logout</a></li>
  </ul>
        </div>
         <div class="well1">
               <% if(request.getParameter("id")!=null)out.println("<ul style=\"list-style-type:disc;color:#2F9DD1; position: static;margin-left:20px;margin-top:20px;\"><li>"+request.getParameter("id")+"</li></ul>"); %>
    <form method="post" action="validate1">
            <table style="margin-left:40px;">
               
                <tr>
                <td><h4>Enter Password</h4></td><td><input type="password" name="pass" placeholder="Please Enter Password"/>
                </td>
            </tr>
                <tr><td/><td><button style="margin-left:10px;" class="btn" type="submit">Pay Salary to all Employees ...</button></td></tr>    
            </table>
        </form>
           </div>
    
      <% }
        else
        {
            response.sendRedirect("index.jsp?id=Your session may be expired. You have to login first");
        }
      %>
    
    </body>
</html>
