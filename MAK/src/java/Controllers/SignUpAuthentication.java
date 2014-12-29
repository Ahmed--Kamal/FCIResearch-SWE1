/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.FCIDB;
import Models.ResearcherInfo;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SignUpAuthentication extends HttpServlet {
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
            String name = request.getParameter("name");
            String uName = request.getParameter("uName");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            String job = request.getParameter("job");
            String password = request.getParameter("password");
            String[] tag = request.getParameterValues("tags");
            String val = "";
            for(int i=0; i<tag.length-1;i++)
                val+= tag[i]+",";
            val+=(tag[tag.length-1]);
            ResearcherInfo res = new ResearcherInfo(name,uName,email,age,job,password,val);
            addResearcher(res);
            session = request.getSession();
                session.setAttribute("userName", name);
            response.sendRedirect("http://localhost:8090/MAK/index.jsp");
        } finally {
            out.close();
        }
    }
    public static boolean addResearcher(ResearcherInfo res)throws Exception
    {
        if(res.name!= null && res.userName!= null && res.email!= null &&  res.password!= null)
        {
            FCIDB db = new FCIDB();
            db.statement = db.connection.prepareStatement("INSERT INTO researchers(name,userName,email,age,job,password,Categories)VALUES(?,?,?,?,?,?,?)");
            
            db.statement.setString(1, res.name);
            db.statement.setString(2, res.userName);
            db.statement.setString(3, res.email);
            db.statement.setString(4, Integer.toString(res.age));
            db.statement.setString(5, res.job);
            db.statement.setString(6, res.password);
            db.statement.setString(7, res.category);
            db.statement.executeUpdate();
            return true;
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
            Logger.getLogger(SignUpAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SignUpAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
