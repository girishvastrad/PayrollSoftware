/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
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
public class applyleave extends HttpServlet {

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
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        //Date parsed = format.parse("20110210");DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
     //String empid=request.getParameter("empid");
        String empid =(String)session.getAttribute("id");
        String ltype = request.getParameter("leavetype");
       // String fname = request.getParameter("fname");
       // String mname = request.getParameter("mname");
       // String lname = request.getParameter("lname");
       // System.out.println(fname);
        
         //   java.util.Date parsed = format.parse(request.getParameter("dob"));
          //  java.sql.Date dob = new java.sql.Date(parsed.getTime());
       //         java.util.Date dob = format.parse();
        String start = request.getParameter("start");
        String end = request.getParameter("end");
    //    String designation = request.getParameter("designation");
     //       java.util.Date parsed1 = format.parse(request.getParameter("doj"));
      //      java.sql.Date doj = new java.sql.Date(parsed1.getTime());
      //          java.sql.Date doj = format.parse(request.getParameter("doj"));
        Integer totaldays=Integer.parseInt(request.getParameter("totaldays"));
        String reason = request.getParameter("reason");
        String month="FEB";
        String year="2015";
        //int accno = Integer.parseInt(request.getParameter("accno"));
       // String branchname = request.getParameter("branchname");
       // String dep = request.getParameter("dep");
        
        //out.println(empid);
      //  out.println(fname);
       // out.println(email);
      //  out.println(phoneno);
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll123","root","");
     //(FirstName,LastName,ID,DOB,Designation) 
            //String query = "INSERT INTO Employee " + " VALUES ('"+fname+"','"+lname+"','"+id+"','"+dob+"','"+phoneno+"','"+designation+"','"+date+"')";
            
            //   String query = "INSERT INTO table1 " + "VALUES ('" + name + "')";
       
        //   String query1 = "UPDATE salary SET BS='"+salary+"' WHERE EmployeeID='"+id+"'";
           System.out.println(ltype);
            PreparedStatement ps=con.prepareStatement("select * from `leave` WHERE employeeid=? and month=? and year=?");
            PreparedStatement ps1=con.prepareStatement("UPDATE `leave` SET "+ltype+"=? WHERE employeeid=? and month=? and year=?");
            ps.setString(1,empid);
           ps.setString(2,month);
           ps.setString(3,year);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Integer a=rs.getInt(ltype);
// ps.setString(2,fname);
           // ps.setString(3,mname);
           // ps.setString(4,lname);
           // ps.setDate(5,dob);
            ps1.setInt(1,a-totaldays);
            ps1.setString(2,empid);
           ps1.setString(3,month);
           ps1.setString(4,year);
          //  ps.setString(8,designation);
    //        ps.setDate(9,doj);
           //   ps.setString(12,branchname);
        //    ps.setString(13,dep);
           // ps.setString(6,empid);
            int i=5;
            i=ps1.executeUpdate();
       //     System.out.println(i);
            
            if(i!=0)
             response.sendRedirect("welcomeemployee.jsp?id=Leave Applied Successfully !!");
                else
                System.out.println("error");
                
       ps.close();
 con.close();
 }else
 {
   //out.println("<h4 style=\"color:red;margin-bottom: 5px;padding-left: 5px;\">Your session may be expired. You have to login first</h4>");
              
     response.sendRedirect("index.jsp?id=Your session may be expired. You have to login first");
 }
        }catch(Exception e){
        e.printStackTrace();
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