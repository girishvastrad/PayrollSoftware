
//package validator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;


public class validateservlet1 extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
      //  String usertype = request.getParameter("usertype");//its actually db name
              
             if(pass.equals("admin") && uname.equals("admin"))
             {
             
            HttpSession session=request.getSession();
            String username1="administrator";
            session.setAttribute("username",username1);
            session.setAttribute("id",uname);
//            session.setAttribute("usertype",usertype);
                RequestDispatcher rd = request.getRequestDispatcher("welcomeaccountantz.jsp");
                rd.forward(request, response);
            
         }
             else {
              

                //out.println("<h4 style=\"color:red;\">Invalid username & password</h4>");
                response.sendRedirect("admin.jsp?id=Invalid username or password");
                //RequestDispatcher rd = request.getRequestDispatcher("index.html");
                //rd.include(request, response);
                
        
        }
       
         
       
    }
}

   
