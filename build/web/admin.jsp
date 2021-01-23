<%-- 
    Document   : index
    Created on : Mar 14, 2015, 9:41:56 PM
    Author     : Parth_Lathiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" media="screen,projection" type="text/css" href="./main.css" />
        <style>
            input[type="text"], input[type="password"],select{
                height:20px;
                width: 175px;
 //            display: inline-block;
 // padding: 4px 6px;
 // margin-bottom: 10px;
 // margin-top: 10px;
  //font-size: 14px;
  //line-height: 20px;
  //color: #555555;
  //-webkit-border-radius: 4px;
  //-moz-border-radius: 4px;
  //border-radius: 4px;
  //vertical-align: middle;
            }
 td {           font-size: 18px;}
 select{        height:30px;
                width: 190px;
                font-family: sans-serif;}

        </style>
    </head>
    <body>
        <div class="well" style="margin-top: 160px;height:230px;width:500px;margin-left:433px;">
            <form method="post" action="validateservlet1">
        <table align="center" style="margin-left: 70px ;margin-top: 8px ;">
            <tr>
                <td colspan="2"><center style="color:red;"><% if(request.getParameter("id")!=null)out.println("<span style=\"font-family:tahoma;\">"+request.getParameter("id")+"</span>");%></center></td>
            </tr>
            <tr>
                <td><h4>Username</h4></td><td><input type="text" name="uname" placeholder="Please Enter Username"/>
                </td>
            </tr>
            <tr>
                <td><h4>Password</h4></td><td><input type="password" name="pass" placeholder="Please Enter Password"/>
                </td>
            </tr>
                       <tr><td></td>
                <td>
                    <button class="btn" style="margin-left: 20px;" type="submit" name="login">Log In</button>
                </td>
            </tr>
        </table>
            
         
    </form>
        </div>
    </body>
</html>
