
import java.io.IOException;
import java.io.PrintWriter;
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
public class add1 extends HttpServlet {

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
     String empid=request.getParameter("empid");
     //   String empid =(String)session.getAttribute("id");
        String sal = request.getParameter("sal");
        String fname = request.getParameter("fname");
        String mname = request.getParameter("mname");
        String lname = request.getParameter("lname");
       // System.out.println(fname);
        
         //   java.util.Date parsed = format.parse(request.getParameter("dob"));
          //  java.sql.Date dob = new java.sql.Date(parsed.getTime());
       //         java.util.Date dob = format.parse();
        String dob=request.getParameter("dob");
        String phoneno = request.getParameter("phoneno");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String doj=request.getParameter("doj");
    
        //       java.util.Date parsed1 = format.parse(request.getParameter("doj"));
      //      java.sql.Date doj = new java.sql.Date(parsed1.getTime());
      //          java.sql.Date doj = format.parse(request.getParameter("doj"));
        String bankname = request.getParameter("bankname");
        Integer accno = Integer.parseInt(request.getParameter("accno"));
        String branchname = request.getParameter("branchname");
        String dep = request.getParameter("dep");
        Float bs = Float.parseFloat(request.getParameter("bs"));
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
            PreparedStatement ps=con.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        ps.setString(1,empid);

                        ps.setString(2,sal);
            ps.setString(3,fname);
            ps.setString(4,mname);
           ps.setString(5,lname);
            ps.setString(6,dob);
            ps.setString(7,phoneno);
            ps.setString(8,email);
            ps.setString(9,designation);
            ps.setString(10,doj);
            ps.setString(11,bankname);
            ps.setInt(12,accno);
            ps.setString(13,branchname);
            ps.setString(14,dep);
            ps.setFloat(15,bs);
            int i;
            i=ps.executeUpdate();
            //System.out.println(i);
            if(i!=0)
             response.sendRedirect("welcomeaccountantz.jsp?id=Employee Details Successfully added !!");
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