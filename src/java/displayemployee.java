/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Parth_Lathiya
 */
public class displayemployee extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter() ;
        try {
           // PrintWriter out = response.getWriter() ;
                        HttpSession session=request.getSession();
 if(session.getAttribute("username")!=null)           
 {
           
     
                   Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll123","root","");
     
            PreparedStatement ps = con.prepareStatement("SELECT * from employee");
      //      ps.setString(1, uname);
        //   ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            
                /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Employee List</title>");            
            out.println("   <link rel=\"stylesheet\" media=\"screen,projection\" type=\"text/css\" href=\"./main.css\" /> <style>\n" +
"            img\n" +
"            {\n" +
"                width:150px;\n" +
"                height:50px;\n" +
"                margin-left: 70px;\n" +
"                margin-top: -5px;\n" +
"            }\n" +
"            strong\n" +
"            {\n" +
"            position: absolute;\n" +
"            right: 15px;\n" +
"            top :35px\n" +
"                \n" +
"            }\n" +
"        </style></head><body>");
        
        
        out.println("<img src=\"cc.jpg\"> <strong>Welcome "+session.getAttribute("username")+"</strong>");
     
            out.println("<div class=\"well\">  <ul>\n" +
"  <li><a href=\"generatepayslipbyaccz.jsp\">Generate Pay-Slip</a></li>\n" +
"  <li><a href=\"generatereportbyaccz.jsp\">Generate Report</a></li>\n" +
"  <li><a href=\"add.jsp\">Add Employee</a></li>\n" +
"  <li><a href=\"updatebyaccz.jsp\">Update Employee</a></li>\n" +
" \n" +
"  <li><a href=\"addaccountant.jsp\">Add Accountant</a></li>\n" +
"  <li><a href=\"displayemployee\">View Employee List</a></li>\n" +
"  <li><a href=\"logout\">Logout</a></li>\n" +
"  </ul>\n" +
"        </div>" +
"        <div class=\"well1\">");
            // border=\"1\" style=\"width:100%>
            out.println("<br><h2><center><b>Employee List</b></center></h2><br><table border=\"1\" style=\"width:100%;border-spacing: 0.5em;text-align: center;\">");
            out.println("<tr><td><b>Name</b></td><td><b>ID</b></td><td><b>DOB</b></td><td><b>PhoneNo</b></td><td><b>Designation</b></td><td><b>Basic Salary(Per Month)</b></td><td><b>Date Of Join</b></td></tr></b>");
            while(rs.next())
            {
             out.println("<tr><td>"+rs.getString(2)+" "+rs.getString(3)+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getDate(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(9)+"</td>");
           
            out.println("<td>"+rs.getInt(15)+"</td>");
            out.println("<td>"+rs.getDate(10)+"</td></tr>");
            
            }
            out.println("</table>");
            //out.println("<br><br><center><button onclick=\"history.go(-1)\">Back</button></center></div>");
            out.println("</body>");
            out.println("</html>");
 }        else
 {
      response.sendRedirect("index.jsp?id=Your session may be expired. You have to login first");

 }
        }catch(Exception e){
        out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
