/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import static Controllers.LoginAuthentication.Uemail;
import Models.FCIDB;
import Models.Research;
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
public class ResearchAuthentication extends HttpServlet {
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
            //response.sendRedirect("http://localhost:8090/MAK/Home.jsp");
            response.setContentType("text/html;charset=UTF-8");
            String name = request.getParameter("name");
            String content = request.getParameter("content");
            String[] tag = request.getParameterValues("tags");
            //String email = (String) session.getAttribute("Savedemail");
            String val = "";
            for(int i=0; i<tag.length-1;i++)
                val+= tag[i]+",";
                val+=(tag[tag.length-1]);
            String email = Uemail();
            Research res = new Research(name, content, val);
            AddResearch(res, email);
            response.sendRedirect("http://localhost:8090/MAK/Home.jsp");
            
        } finally {
            out.close();
        }
    }
    public static boolean AddResearch(Research res, String email) throws Exception
    {
            FCIDB db = new FCIDB();
            db.statement = db.connection.prepareStatement("INSERT INTO research(email,resName,content,category)VALUES(?,?,?,?)");
            db.statement.setString(1, email);
            db.statement.setString(2, res.name);
            db.statement.setString(3, res.content);
            db.statement.setString(4, res.tags);
            db.statement.executeUpdate();
            db.connection.close();
            return true;
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
            Logger.getLogger(ResearchAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ResearchAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
