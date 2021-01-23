/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
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
public class paysalary extends HttpServlet {

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
           
     Calendar now=Calendar.getInstance();
    // String month=(now.get(Calendar.MONTH)+1);
     
     String[] mon = new String[12];
     mon[0]="JAN";
     mon[1]="FEB";
     mon[2]="MARCH";
     mon[3]="APRIL";
     mon[4]="MAY";
     mon[5]="JUNE";
     mon[6]="JULY";
     mon[7]="AUG";
     mon[8]="SEPT";
     mon[9]="OCT";
     mon[10]="NOV";
     mon[11]="DEC";
     
     Integer[] days = new Integer[12];
     days[0]=31;
     days[1]=28;
     days[2]=31;
     days[3]=30;
     days[4]=31;
     days[5]=30;
     days[6]=31;
     days[7]=31;
     days[8]=30;
     days[9]=31;
     days[10]=30;
     days[11]=31;
     
     String month=
             mon[now.get(Calendar.MONTH)+1];
     Integer tdays=
             days[now.get(Calendar.MONTH)+1];
             int year=now.get(Calendar.YEAR);
     
     Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll123","root","");
     
//           PreparedStatement ps1 = con.prepareStatement("SELECT  FROM payslip where month=? and year=?");
           
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
"  <li><a href=\"generatepayslipbyacc1.jsp\">Generate Pay-Slip</a></li>\n" +
"  <li><a href=\"generatereportbyacc1.jsp\">Generate Report</a></li>\n" +
"  <li><a href=\"add2.jsp\">Add Employee</a></li>\n" +
"  <li><a href=\"updatebyacc1.jsp\">Update Employee</a></li>\n" +
"  <li><a href=\"paysalary.jsp\">Pay Salary</a></li>\n" +
" " +
"  <li><a href=\"displayemployee1\">View Employee List</a></li>\n" +
"  <li><a href=\"logout\">Logout</a></li>\n" +
"  </ul>\n" +
"        </div>" +
"        <div class=\"well1\">");
            // border=\"1\" style=\"width:100%>
          //  out.println("<br><h2><center><b>Employee List</b></center></h2><br><table border=\"1\" style=\"width:100%;border-spacing: 0.5em;text-align: center;\">");
           // out.println("<tr><td><b>Name</b></td><td><b>ID</b></td><td><b>DOB</b></td><td><b>PhoneNo</b></td><td><b>Designation</b></td><td><b>Basic Salary(Per Month)</b></td><td><b>Date Of Join</b></td></tr></b>");
            while(rs.next())
            {
                PreparedStatement ps1=con.prepareStatement("INSERT INTO payslip VALUES (?,?,?,?,?)");
             ps1.setString(1,rs.getString(1));

                        ps1.setString(2,month);
            ps1.setInt(3,year);
            ps1.setInt(4,rs.getInt(15));
         
            ps1.setInt(5,tdays);
            int i,j;
                  PreparedStatement ps2=con.prepareStatement("INSERT INTO `leave` VALUES (?,?,?,?,?,?)");
             ps2.setInt(1,3);

                        ps2.setInt(2,2);
            ps2.setInt(3,2);
            ps2.setString(4,month);
         
            ps2.setInt(5,year);
            ps2.setString(6,rs.getString(1));
       try{     i=ps1.executeUpdate();
            j=ps2.executeUpdate();
       }catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e)
           
       { 
  //      out.println(e);
    //        if(e.equals("MySQLIntegrityConstraintViolationException"))
               response.sendRedirect("paysalary.jsp?id=Salary has been already allotted");     
            
       }
            }
            response.sendRedirect("paysalary.jsp?id=Salary has been successfully paid to all employees");
             
            out.println("</table>");
            //out.println("<br><br><center><button onclick=\"history.go(-1)\">Back</button></center></div>");
            out.println("</body>");
            out.println("</html>");
 }        else
 {
      response.sendRedirect("index.jsp?id=Your session may be expired. You have to login first");

 }
        }catch(Exception e){
      //  out.println(e);
         
            
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
