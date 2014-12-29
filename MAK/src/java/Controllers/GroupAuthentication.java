/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.LoginAuthentication.Uemail;
import Models.FCIDB;
import Models.Group;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sho3la
 */
public class GroupAuthentication extends HttpServlet {

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
            String Description = request.getParameter("des");
            String []tag = request.getParameterValues("tags");
            String val = "";
            for(int i=0; i<tag.length-1;i++)
                val+= tag[i]+",";
                val+=(tag[tag.length-1]);
            String email = Uemail();
            Group group=new Group(name,Description,val);
            //response.sendRedirect("http://localhost:8090/MAK/Home.jsp");
            if(AddGroup(group, email)){
                response.sendRedirect("http://localhost:8090/MAK/Home.jsp");
                /*List l = new ArrayList();
                l.add("ahmed");
                l.add("hamada");
                l.add("medo");
                request.setAttribute("data", l);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Group.jsp"); 
                if (dispatcher != null){  
                dispatcher.forward(request, response);  
                }*/
            }
            else
                response.sendRedirect("http://localhost:8090/MAK/index.jsp");
        } finally {
            out.close();
        }
    }
    public static boolean AddGroup(Group group, String email) throws Exception
    {
        FCIDB db = new FCIDB();
        //db.statement = db.connection.prepareStatement("INSERT INTO research(email,resName,content,category)VALUES(?,?,?,?)");
            db.statement = db.connection.prepareStatement("INSERT INTO groups (Admin,Name,Description,Tags,Members) VALUES (?,?,?,?,?)");
            db.statement.setString(1, email);
            db.statement.setString(2, group.Name);
            db.statement.setString(3, group.Description);
            db.statement.setString(4, group.tag);
            db.statement.setString(5, email);
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
            Logger.getLogger(GroupAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GroupAuthentication.class.getName()).log(Level.SEVERE, null, ex);
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
