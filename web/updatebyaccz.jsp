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
  <li><a href="generatepayslipbyaccz.jsp">Generate Pay-Slip</a></li>
  <li><a href="generatereportbyaccz.jsp">Generate Report</a></li>
  <li><a href="add.jsp">Add Employee</a></li>
  <li><a href="updatebyaccz.jsp">Update Employee</a></li>
 
  <li><a href="addaccountant.jsp">Add Accountant</a></li>
  <li><a href="displayemployee">View Employee List</a></li>
  <li><a href="logout">Logout</a></li>
  </ul>
        </div>
           <div class="well1">
               <% if(request.getParameter("id")!=null)out.println("<ul style=\"list-style-type:disc;color:red; position: static;margin-left:5px;margin-top:20px;\"><li>"+request.getParameter("id")+"</li></ul>"); %>
    <form method="post" action="actualupdatebyaccz.jsp">
             <table style="margin-left:5px;margin-top: 30px;border-spacing: 0.9em;font-family: tahoma">
           
                <tr><td>Employee ID</td><td><input type="text" name="id"></td></tr>
                <tr><td/><td><button class="btn" type="submit">Update</button></td></tr>    
            
       
             
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
