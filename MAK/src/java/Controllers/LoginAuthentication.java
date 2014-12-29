/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Models.FCIDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Sho3la
 */
public class LoginAuthentication extends HttpServlet {
    public static String userEmail;
    public HttpSession session;
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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            response.setContentType("text/html;charset=UTF-8");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            /*FCIDB db = new FCIDB();
            db.statement = db.connection.prepareStatement("select * from researchers ");
            ResultSet rs = db.statement.executeQuery();
            while(rs.next())
            {
                email = rs.getString(3);
                password = rs.getString(6);
                {
                    //response.sendRedirect("http://localhost:8090/MAK/Home.jsp");
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");          
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>" + email + " " + password + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }*/
            boolean check = validation(email, password);
            if(check){
                userEmail = email;
                HttpSession session = request.getSession(true);
                session.setAttribute("email", email);
                response.sendRedirect("http://localhost:8090/MAK/Home.jsp");
            }
            
            else
                response.sendRedirect("http://localhost:8090/MAK/SignUp.jsp");
            
        } finally {
            out.close();
        }
    }
    public static boolean validation (String email, String password)throws Exception
    {
        FCIDB db = new FCIDB();
        db.statement = db.connection.prepareStatement("select * from researchers ");
        ResultSet rs = db.statement.executeQuery();
        while(rs.next())
	{
           if(email.equals(rs.getString(3)) && password.equals(rs.getString(6))){
               return true;}
	}
        return false;
    }
    public static String Uemail()
    {
        return userEmail;
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
        } catch (Exception ex) {
            Logger.getLogger(LoginAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(LoginAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
