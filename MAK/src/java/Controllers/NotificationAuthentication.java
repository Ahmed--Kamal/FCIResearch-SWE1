/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.LoginAuthentication.Uemail;
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

/**
 *
 * @author Sho3la
 */
public class NotificationAuthentication extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String gName = request.getParameter("gName");
            String rMail = request.getParameter("mail");
            String email = Uemail();
            if(acceptNotification(gName, rMail, email))
                response.sendRedirect("http://localhost:8090/MAK/Home.jsp");
            else
                response.sendRedirect("http://localhost:8090/MAK/Notification.jsp");
        } finally {
            out.close();
        }
    }
    public static boolean acceptNotification(String gName, String rMail, String email) throws Exception
    {
        FCIDB db = new FCIDB();
        db.statement = db.connection.prepareStatement("select * from group_request");
        ResultSet rs = db.statement.executeQuery();
        String emails = "";
        while (rs.next())
        {
            if(gName.equals(rs.getString(3)) && rMail.equals(rs.getString(2)) && email.equals(rs.getString(1)))
            {
                
                db.statement = db.connection.prepareStatement("select * from groups");
                ResultSet rss = db.statement.executeQuery();
                while(rss.next())
                {
                    if(gName.equals(rss.getString(2)) && email.equals(rss.getString(1)))
                    {
                        emails = rss.getString(5);
                        emails += ", ";
                        emails += rMail;
                        String da="UPDATE groups SET Members='"+emails+"' WHERE Admin=?  AND Name=? ";
                        //db.statement = db.connection.prepareStatement("UPDATE groups SET Members='name@example.com' WHERE Admin=? AND Name=? ");
                        db.statement = db.connection.prepareStatement(da);
                        db.statement.setString(1, email);
                        db.statement.setString(2, gName);
                        db.statement.executeUpdate();
                        
                        db.statement = db.connection.prepareStatement("DELETE FROM group_request WHERE mailAdmin=? AND gRequestMail=? AND request_group_name=?");
                        db.statement.setString(1, email);
                        db.statement.setString(2, rMail);
                        db.statement.setString(3, gName);
                        db.statement.executeUpdate();
                        
                        break;
                    }
                }
                
                
                
                
                
                db.connection.close();
                return true;
            }
        }
        return false;
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
            Logger.getLogger(NotificationAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NotificationAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
