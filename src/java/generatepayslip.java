//generatepayslip
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itextpdf.text.BaseColor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://tutorials.jenkov.com/java-itext/index.html 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Parth_Lathiya
 */
public class generatepayslip extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
            // setting the content type
        response.setContentType("application/pdf");
                  try {
              HttpSession session=request.getSession();
 if(session.getAttribute("username")!=null)  {
            // Get the text that will be added to the PDF
           
       String month=request.getParameter("month");
       String year=request.getParameter("year");
       String id=(String)session.getAttribute("id");
         //  System.out.println(id);
          //   String text = request.getParameter("text");
          //  if (text == null || text.trim().length() == 0) {
          //       text = "You didn't enter any text.";
          //  }
     //String id="Ultimate01";    
     Class.forName("com.mysql.jdbc.Driver").newInstance();
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll123","root","");
     
            PreparedStatement ps = con.prepareStatement("SELECT * from employee where id=?");
            ps.setString(1, id);
        //   ps.setString(2, pass);
            PreparedStatement ps1 = con.prepareStatement("SELECT * from payslip where employeeid=? and month=? and year=?");
            ps1.setString(1, id);
            ps1.setString(2, month);
            ps1.setString(3, year);
            

          //  PreparedStatement ps2 = con.prepareStatement("SELECT * from leave ");
                    PreparedStatement ps2 = con.prepareStatement("SELECT * from `leave` where employeeid=? and month=? and year=?");
    ps2.setString(1, id);  
            ps2.setString(2, month);
            ps2.setString(3, year);
        //    
            ResultSet rs = ps.executeQuery();
rs.next();
            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
if(rs1.next()==false)
{
    response.sendRedirect("generatepayslip.jsp?id=Payslip of "+month+"/"+year+" is not generated OR Record of this Payslip is not available in our Database");
}
// step 1
           
  //System.out.println("sssssssssssssssssss");
     
  Document document = new Document();
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);

            
            Font font0 = new Font(Font.FontFamily.TIMES_ROMAN  , 11);
            Font font1 = new Font(Font.FontFamily.HELVETICA  , 11, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.HELVETICA  , 18, Font.BOLD);
            Font font3 = new Font(Font.FontFamily.HELVETICA  , 9, Font.BOLD);
            Font font4 = new Font(Font.FontFamily.HELVETICA  , 10);
            Font font5 = new Font(Font.FontFamily.HELVETICA  , 12, Font.BOLD);
            Font font6 = new Font(Font.FontFamily.HELVETICA  , 12);

//font1.setColor(BaseColor.WHITE);
  BaseColor myColor = WebColors.getRGBColor("#F78181");
              BaseColor myColor1 = WebColors.getRGBColor("#FAFAFA");
          

//step 3
            document.open();
            // step 3.5
            PdfPTable table1 = new PdfPTable(3); // 1 columns.
  PdfPCell cell00 = new PdfPCell(new Paragraph("Payslip\nFEB-2015",font2));
  cell00.setBorder(PdfPCell.NO_BORDER);
  cell00.setPaddingTop(18);
    PdfPCell cell01 = new PdfPCell(new Paragraph(""));
  cell01.setBorder(PdfPCell.NO_BORDER);
          
            Image image = Image.getInstance("cc.jpg");
            PdfPCell cell0 = new PdfPCell(image, true);
cell0.setBorder(PdfPCell.NO_BORDER);
          
           // cell0.setHorizontalAlignment(Element.ALIGN_RIGHT);
            //PdfPCell cell1 = new PdfPCell(new Paragraph("Mr. NILESH POPATBHAI LATHIYA"));
            table1.addCell(cell00);
            table1.addCell(cell01);
            table1.addCell(cell0);
          //  table1.addCell(cell1);
//            table.addCell(cell2);
  //          table.addCell(cell3);
            table1.setWidthPercentage(100);
            table1.setSpacingAfter(2f);
            //table1.setSpacingBefore(20f);

//table1.setSpacingAfter(10f);
 
            document.add(table1);
          //  table1.setWidthPercentage(100);
            PdfPTable table2 = new PdfPTable(6); // 3 columns.
            table2.setWidthPercentage(100);
            PdfPCell cell11 = new PdfPCell(new Paragraph((String)session.getAttribute("username"),font0));
            cell11.setColspan(6);
        //cell11.setBorder(PdfPCell.NO_BORDER);
            cell11.setLeading(10f, 0f);
            cell11.setBorderWidth(1f);
            cell11.setPadding(4);           
              cell11.setBackgroundColor(myColor1);
            PdfPCell cell12 = new PdfPCell(new Paragraph("Employee Details",font1));
            cell12.setColspan(2);
            
          
            cell12.setBorderWidth(1f);
            cell12.setLeading(10f, 0f);
            cell12.setPadding(4);
            cell12.setBackgroundColor(myColor);
            PdfPCell cell13 = new PdfPCell(new Paragraph("Payment & Leave Details",font1));
            cell13.setColspan(2);
            cell13.setLeading(10f, 0f);
            cell13.setPadding(4);
            cell13.setBorderWidth(1f);
            cell13.setBackgroundColor(myColor);
            // cell11.setLeading(15f, 1.5f);
            PdfPCell cell14 = new PdfPCell(new Paragraph("Location Details",font1));
            cell14.setColspan(2);
            cell14.setLeading(10f, 0f);
            cell14.setPadding(4);
            cell14.setBorderWidth(1f);
            cell14.setBackgroundColor(myColor);
//            PdfPTable nestedTable1 = new PdfPTable(2);
  //    nestedTable1.addCell(new Paragraph("Emp No."));
   //   nestedTable1.addCell(new Paragraph("379666"));

//      cell41.addElement(nestedTable1);
            table2.addCell(cell11);
            table2.addCell(cell12);
            table2.addCell(cell13);
            table2.addCell(cell14);
            
            
            PdfPCell cell15 = new PdfPCell(new Paragraph("Emp ID.",font3));
            //cell15.setLeading(10f, 0f);
            cell15.setPadding(3);
            cell15.setBorderWidth(1f);
            cell15.setBackgroundColor(myColor1);
            PdfPCell cell16 = new PdfPCell(new Paragraph(rs.getString(1),font4));
          //  cell16.setLeading(10f, 0f);
            cell16.setPadding(3);
            cell16.setBorderWidth(1f);
            cell16.setBackgroundColor(myColor1);
            PdfPCell cell17 = new PdfPCell(new Paragraph("Bank Name",font3));
            //cell17.setLeading(10f, 0f);
            cell17.setPadding(3);
            cell17.setBorderWidth(1f);
            cell17.setBackgroundColor(myColor1);
            PdfPCell cell18 = new PdfPCell(new Paragraph(rs.getString(11),font4));
            //cell18.setLeading(10f, 0f);
            cell18.setPadding(3);
            cell18.setBorderWidth(1f);
            cell18.setBackgroundColor(myColor1);
            PdfPCell cell19 = new PdfPCell(new Paragraph("Location",font3));
            //cell19.setLeading(10f, 0f);
            cell19.setPadding(3);
            cell19.setBorderWidth(1f);
            cell19.setBackgroundColor(myColor1);
            PdfPCell cell20 = new PdfPCell(new Paragraph(rs.getString(13),font4));
            //cell20.setLeading(10f, 0f);
            cell20.setPadding(3);
            cell20.setBorderWidth(1f);
            cell20.setBackgroundColor(myColor1);
            
            table2.addCell(cell15);
            table2.addCell(cell16);
            table2.addCell(cell17);
            table2.addCell(cell18);
            table2.addCell(cell19);
            table2.addCell(cell20);
            
            
            PdfPCell cell21 = new PdfPCell(new Paragraph("Dsgn.",font3));
            //cell21.setLeading(10f, 0f);
            cell21.setPadding(3);
            cell21.setBorderWidth(1f);
            cell21.setBackgroundColor(myColor1);
            PdfPCell cell22 = new PdfPCell(new Paragraph(rs.getString(9),font4));
          //  cell22.setLeading(10f, 0f);
            cell22.setPadding(3);
            cell22.setBorderWidth(1f);
            cell22.setBackgroundColor(myColor1);
            PdfPCell cell23 = new PdfPCell(new Paragraph("Acc No.",font3));
            //cell23.setLeading(10f, 0f);
            cell23.setPadding(3);
            cell23.setBorderWidth(1f);
            cell23.setBackgroundColor(myColor1);
            
            int accno=Integer.parseInt(rs.getString(12));
            String accno1[]=new String[4];
            for(int i=0;i<4;i++)
            {
                accno1[i]=Integer.toString(accno%10);
                accno/=10;
            }
            
            PdfPCell cell24 = new PdfPCell(new Paragraph("XXXXXXX"+accno1[3]+""+accno1[2]+""+accno1[1]+""+accno1[0],font4));
            //cell24.setLeading(10f, 0f);
            cell24.setPadding(3);
            cell24.setBorderWidth(1f);
            cell24.setBackgroundColor(myColor1);
            PdfPCell cell25 = new PdfPCell(new Paragraph("Base Br.",font3));
            //cell25.setLeading(10f, 0f);
            cell25.setPadding(3);
            cell25.setBorderWidth(1f);
            cell25.setBackgroundColor(myColor1);
            PdfPCell cell26 = new PdfPCell(new Paragraph("CC - Ahmedabad",font4));
            //cell26.setLeading(10f, 0f);
            cell26.setPadding(3);
            cell26.setBorderWidth(1f);
            cell26.setBackgroundColor(myColor1);
            
            table2.addCell(cell21);
            table2.addCell(cell22);
            table2.addCell(cell23);
            table2.addCell(cell24);
            table2.addCell(cell25);
            table2.addCell(cell26);
            
            
             PdfPCell cell27 = new PdfPCell(new Paragraph("Grade",font3));
            //cell27.setLeading(10f, 0f);
            cell27.setPadding(3);
            cell27.setBorderWidth(1f);
            cell27.setBackgroundColor(myColor1);
            PdfPCell cell28 = new PdfPCell(new Paragraph("C2",font4));
          //  cell28.setLeading(10f, 0f);
            cell28.setPadding(3);
            cell28.setBorderWidth(1f);
            cell28.setBackgroundColor(myColor1);
            PdfPCell cell29 = new PdfPCell(new Paragraph("Days paid",font3));
            //cell29.setLeading(10f, 0f);
            cell29.setPadding(3);
            cell29.setBorderWidth(1f);
            cell29.setBackgroundColor(myColor1);
            PdfPCell cell30 = new PdfPCell(new Paragraph(Integer.toString(rs1.getInt(5)),font4));
            //cell30.setLeading(10f, 0f);
            cell30.setPadding(3);
            cell30.setBorderWidth(1f);
            cell30.setBackgroundColor(myColor1);
            PdfPCell cell31 = new PdfPCell(new Paragraph("Depute Br.",font3));
            //cell31.setLeading(10f, 0f);
            cell31.setPadding(3);
            cell31.setBorderWidth(1f);
            cell31.setBackgroundColor(myColor1);
            PdfPCell cell32 = new PdfPCell(new Paragraph("CC - Ahmedabad",font4));
            //cell32.setLeading(10f, 0f);
            cell32.setPadding(3);
            cell32.setBorderWidth(1f);
            cell32.setBackgroundColor(myColor1);
            
            table2.addCell(cell27);
            table2.addCell(cell28);
            table2.addCell(cell29);
            table2.addCell(cell30);
            table2.addCell(cell31);
            table2.addCell(cell32);
            
            
            PdfPCell cell33 = new PdfPCell(new Paragraph("PAN",font3));
            //cell33.setLeading(10f, 0f);
            cell33.setPadding(3);
            cell33.setBorderWidth(1f);
            cell33.setBackgroundColor(myColor1);
            PdfPCell cell34 = new PdfPCell(new Paragraph("XXXXXXX792E",font4));
          //  cell34.setLeading(10f, 0f);
            cell34.setPadding(3);
            cell34.setBorderWidth(1f);
            cell34.setBackgroundColor(myColor1);
            PdfPCell cell35 = new PdfPCell(new Paragraph("Leave Balance",font3));
            //cell35.setLeading(10f, 0f);
            cell35.setPadding(3);
            cell35.setBorderWidth(1f);
            cell35.setBackgroundColor(myColor1);
            PdfPCell cell36 = new PdfPCell(new Paragraph("EL "+rs2.getInt(1)+"  SL "+rs2.getInt(2)+"  CL "+rs2.getInt(3),font4));
           // PdfPCell cell36 = new PdfPCell(new Paragraph("EL "+rs2.getInt(2),font4));
            //cell36.setLeading(10f, 0f);rs2.getInt(1)
            cell36.setPadding(3);
            cell36.setBorderWidth(1f);
            cell36.setBackgroundColor(myColor1);
            PdfPCell cell37 = new PdfPCell(new Paragraph(" WON/SWON",font3));
            //cell37.setLeading(10f, 0f);
            cell37.setPadding(3);
            cell37.setBorderWidth(1f);
            cell37.setBackgroundColor(myColor1);
            PdfPCell cell38 = new PdfPCell(new Paragraph("2616141",font4));
            //cell38.setLeading(10f, 0f);
            cell38.setPadding(3);
            cell38.setBorderWidth(1f);
            cell38.setBackgroundColor(myColor1);
            
            table2.addCell(cell33);
            table2.addCell(cell34);
            table2.addCell(cell35);
            table2.addCell(cell36);
            table2.addCell(cell37);
            table2.addCell(cell38);
            
             table2.setSpacingAfter(12f);
             
            document.add(table2);
            
            PdfPTable table3 = new PdfPTable(5); // 5 columns.
            table3.setWidthPercentage(100);
           
            PdfPCell cell39 = new PdfPCell(new Paragraph("Earnings",font1));
            cell39.setLeading(10f, 0f);
            cell39.setPadding(4);
            cell39.setBorderWidth(1f);
            cell39.setBackgroundColor(myColor);
            PdfPCell cell40 = new PdfPCell(new Paragraph("Arrears (INR)",font1));
            cell40.setLeading(10f, 0f);
            cell40.setPadding(4);
            cell40.setBorderWidth(1f);
            cell40.setBackgroundColor(myColor);
            PdfPCell cell41 = new PdfPCell(new Paragraph("Current (INR)",font1));
            cell41.setLeading(10f, 0f);
            cell41.setPadding(4);
            cell41.setBorderWidth(1f);
            cell41.setBackgroundColor(myColor);
            PdfPCell cell42 = new PdfPCell(new Paragraph("Deductions",font1));
            cell42.setLeading(10f, 0f);
            cell42.setPadding(4);
            cell42.setBorderWidth(1f);
            cell42.setBackgroundColor(myColor);
            PdfPCell cell43 = new PdfPCell(new Paragraph("Amount (INR)",font1));
            cell43.setLeading(10f, 0f);
            cell43.setPadding(4);
            cell43.setBorderWidth(1f);
            cell43.setBackgroundColor(myColor);
            
            table3.addCell(cell39);
            table3.addCell(cell40);
            table3.addCell(cell41);
            table3.addCell(cell42);
            table3.addCell(cell43);
            
            String[] sal = new String[10];
            sal[0]="Basic Salary";
            sal[1]="House Rent Allowance";
            sal[2]="Medical Allowance";
            sal[3]="Travelling Allowance";
            sal[4]="Personal Allowance";
            sal[5]="City Allowance";
            sal[6]="Performance Pay";
            sal[7]="Provident Fund";
            sal[8]="Professional Tax";
            sal[9]="Extra Leaves";
            
            Float[] val = new Float[10];
            val[0]=rs1.getFloat(4);
            val[1]=6000.00f;
            val[2]=1000.00f;
            val[3]=1000.00f;
            val[4]=val[0]/2;
            val[5]=1000.00f;
            val[6]=val[4];
            val[7]=val[0]*12/100;
            val[8]=0.00f;
            if((val[0]+val[4]+val[6])*12>250000.00f)
            {
                val[8]=(val[0]+val[4]+val[6])/10;
            }
            val[9]=0.0f;
            if(rs2.getInt(1)<0)
                val[9] -= (rs2.getInt(1)*val[0])/30;
            if(rs2.getInt(2)<0)
                 val[9] -= rs2.getInt(2)*val[0]/30;
            if(rs2.getInt(3)<0)
                val[9] -= rs2.getInt(3)*val[0]/30;
            
           for(int i=0;i<7;i++)
            {
             PdfPCell cell44 = new PdfPCell(new Paragraph(sal[i],font3));
            //cell27.setLeading(10f, 0f);
            cell44.setPadding(3);
            cell44.setBorderWidth(1f);
            cell44.setBackgroundColor(myColor1);
            PdfPCell cell45 = new PdfPCell(new Paragraph("",font4));
          //  cell45.setLeading(10f, 0f);
            cell45.setPadding(3);
            cell45.setBorderWidth(1f);
            cell45.setBackgroundColor(myColor1);
            PdfPCell cell46 = new PdfPCell(new Paragraph(val[i].toString(),font3));
            //cell46.setLeading(10f, 0f);
            cell46.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell46.setPadding(3);
            cell46.setBorderWidth(1f);
            cell46.setBackgroundColor(myColor1);
                
            table3.addCell(cell44);
            table3.addCell(cell45);
            table3.addCell(cell46);
            
            
            if(i==0 || i==1 || i==2) {       
            PdfPCell cell47 = new PdfPCell(new Paragraph(sal[7+i],font4));
            //cell47.setLeading(10f, 0f);
            cell47.setPadding(3);
            cell47.setBorderWidth(1f);
            cell47.setBackgroundColor(myColor1);
            table3.addCell(cell47);
            PdfPCell cell48 = new PdfPCell(new Paragraph(val[i+7].toString(),font3));
            //cell48.setLeading(10f, 0f);
            cell48.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell48.setPadding(3);
            cell48.setBorderWidth(1f);
            cell48.setBackgroundColor(myColor1);
            table3.addCell(cell48);
            }
            else
            {
            PdfPCell cell47 = new PdfPCell(new Paragraph("",font4));
            cell47.setBorder(PdfPCell.NO_BORDER);
            cell47.setBorderWidthRight (1f);
            cell47.setColspan(2);
            table3.addCell(cell47);
            }
                        
            }
            
            PdfPCell cell48 = new PdfPCell(new Paragraph("",font4));
            //cell48.setBorder(PdfPCell.NO_BORDER);
            cell48.setColspan(3);
            table3.addCell(cell48);
            
            PdfPCell cell49 = new PdfPCell(new Paragraph("",font4));
            //cell49.setBorder(PdfPCell.NO_BORDER);
            cell49.setColspan(2);
            table3.addCell(cell49);
            table3.addCell(cell48);
            table3.addCell(cell49);
            table3.addCell(cell48);
            table3.addCell(cell49);
            table3.addCell(cell48);
            table3.addCell(cell49);

            
            PdfPCell cell50 = new PdfPCell(new Paragraph("Total Earnings (Current + Arrears)",font3));
            //cell27.setLeading(10f, 0f);
            cell50.setColspan(2);
            cell50.setPadding(3);
            cell50.setBorderWidth(1f);
            cell50.setBackgroundColor(myColor1);
            table3.addCell(cell50);
                     
            float a = 0.0f;
                    for(int i=0;i<7;i++)
                    {a+=val[i];}
            PdfPCell cell55 = new PdfPCell(new Paragraph(Float.toString(a),font3));
            //cell27.setLeading(10f, 0f);
            cell55.setPadding(3);
            cell55.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell55.setBorderWidth(1f);
            cell55.setBackgroundColor(myColor1);
            table3.addCell(cell55);
            
            
            PdfPCell cell51 = new PdfPCell(new Paragraph("Total Deductions",font3));
            //cell27.setLeading(10f, 0f);
            //cell51.setColspan(3);
            cell51.setPadding(3);
            cell51.setBorderWidth(1f);
            cell51.setBackgroundColor(myColor1);
            table3.addCell(cell51);
            
            float b = val[7]+val[8]+val[9];

            PdfPCell cell56 = new PdfPCell(new Paragraph(Float.toString(b),font3));
            //cell27.setLeading(10f, 0f);
            //cell56.setColspan(3);
            cell56.setPadding(3);
            cell56.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell56.setBorderWidth(1f);
            cell56.setBackgroundColor(myColor1);
            table3.addCell(cell56);
            
            table3.setSpacingAfter(12f);
      
            document.add(table3);
         
            PdfPTable table4 = new PdfPTable(5); // 2 columns.
            table4.setWidthPercentage(100);
            
            PdfPCell cell54 = new PdfPCell(new Paragraph("",font3));
            cell54.setBorder(PdfPCell.NO_BORDER);
            cell54.setColspan(3);
            table4.addCell(cell54);
            
            PdfPCell cell52 = new PdfPCell(new Paragraph("Net Pay",font5));
          cell52.setLeading(10f, 0f);
           // cell52.setBorder(PdfPCell.ALIGN_CENTER);
            cell52.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell52.setVerticalAlignment(Element.ALIGN_CENTER);
            
            cell52.setPadding(6f);
            cell52.setBorderWidth(1f);
            cell52.setBackgroundColor(myColor);
            table4.addCell(cell52);
            
            PdfPCell cell53 = new PdfPCell(new Paragraph(""+(a-b),font6));
            cell53.setLeading(10f, 0f);
            cell53.setPadding(6f);
                 cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell53.setVerticalAlignment(Element.ALIGN_CENTER);
cell53.setBorderWidth(1f);
            
            table4.addCell(cell53);
            
            document.add(table4);
           
       
           
            // step 4
           // document.add(new Paragraph(String.format(
       //         "You have submitted the following text using the %s method:%s",
        //        request.getMethod(),uname)));
         //   document.add(new Paragraph(text));
            // step 5
            document.close();
 
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
  
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        }
         else
          {
                   response.sendRedirect("index.jsp?id=Your session may be expired. You have to login first");

          }
     }
        catch(Exception e) {
     //       throw new IOException(e.getMessage());
       System.out.println(e);
       System.out.println("sssssssssssssssssss");
       
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(generatepayslip.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(generatepayslip.class.getName()).log(Level.SEVERE, null, ex);
        }
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


 
