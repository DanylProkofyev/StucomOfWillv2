/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.willEJB;
import entities.Ruler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AltaUsuario", urlPatterns = {"/AltaUsuario"})
public class AltaUsuario extends HttpServlet {

    @EJB
    willEJB ejb;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<!-- Latest compiled and minified CSS -->\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n"
                    + "\n"
                    + "<!-- Optional theme -->\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n"
                    + "\n"
                    + "<!-- Latest compiled and minified JavaScript -->\n"
                    + "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>");
            out.println("<title>Servlet AltaUsuario</title>");
            out.println("</head>");
            out.println("<body class='container'>");
            out.println("<h1>Servlet AltaUsuario at " + request.getContextPath() + "</h1>");
            out.println("<div class=\"form-group\">");
            out.println("<form action=\"AltaUsuarioFuncion\" method=\"GET\">");
            out.println("<br/>");
            out.println("<p><label class=\"control-label\">nombre</label></p>");
            out.println("<input class=\"form-control\" type=\"text\" name=\"nombre\">");
            out.println("<br/>");
            out.println("<p><label class=\"control-label\">pass</label></p>");
            out.println("<input class=\"form-control\" type=\"password\"  name=\"pass\">");
            out.println("<br/>");
            out.println("<p><label class=\"control-label\">ruler</label></p>");
            out.println("<select class=\"form-control\" name=\"idruler\">");
            try {
                List<Ruler> todosRulers = ejb.selectRulers();
                todosRulers.forEach((rulerAhora) -> {
                    out.println("<option value=" + rulerAhora.getIdruler() + ">" + rulerAhora.getNombre() + "</option>");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.println("</select>");
            out.println("</div>");
            out.println("<br/>");
            out.println("<input class=\"btn btn-default\" type=\"submit\" value=\"ok\">");
            out.println("</form>");
            out.println("<br/>");
            out.println("<form action='index.html'><input class=\"btn btn-default\" type='submit' name='volverInicio' value='Ir de vuelta a Inicio'/></form>");
            out.println("</body>");
            out.println("</html>");
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
