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
               <% if(request.getParameter("id")!=null)out.println("<ul style=\"list-style-type:disc;color:red; position: static;margin-left:5px;margin-top:20px;\"><li>"+request.getParameter("id")+"</li></ul>"); %>
    <form method="post" action="generatepayslipbyaccz">
            <table style="margin-left:40px;">
                           <tr><td>Employee ID</td><td><input type="text" clospan="7" name="empid"></td></tr>

                           <tr><td>Month : </td><td><select name="month">
    <option selected value="0">Select Month</option>
    <option value="JAN">January</option>
    <option value="FEB">February</option>
    <option value="MAR">March</option>
    <option value="APRIL">April</option>
    <option value="MAY">May</option>
    <option value="JUNE">June</option>
    <option value="JULY">July</option>
    <option value="AUG">August</option>
    <option value="SEPT">September</option>
    <option value="OCT">October</option>
    <option value="NOV">November</option>
    <option value="DEC">December</option>
</select>
                    </td></tr>
                <tr><td>Year : </td><td><select name="year" size="1">
    <option selected value="0">Select Year</option>
    <option value="2005">2005</option>
    <option value="2006">2006</option>
    <option value="2007">2007</option>
    <option value="2008">2008</option>
    <option value="2009">2009</option>
    <option value="2010">2010</option>
    <option value="2011">2011</option>
    <option value="2012">2012</option>
    <option value="2013">2013</option>
    <option value="2014">2014</option>
    <option value="2015">2015</option>
</select>
                    </td></tr>
                <tr><td/><td><button class="btn" type="submit">View Payslip</button></td></tr>    
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
