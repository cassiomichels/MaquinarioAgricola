package br.csi.controller_servlets;

import br.csi.dao.CaminhoneiroDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/busca_caminhoneiro"})
public class Busca_Caminhoneiro_Servlet extends HttpServlet {

    public Busca_Caminhoneiro_Servlet() {

    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("INICIALIZOU Busca_Motoboy_Servlet: " + this);
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("DESTRUIU Busca_Motoboy_Servlet: " + this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Chamou doGet do Servlet ....");
        request.setAttribute("caminhoneiros", new CaminhoneiroDAO().getCaminhoneiros());

        RequestDispatcher disp
                = request.getRequestDispatcher("/WEB-INF/views/busca_caminhoneiro.jsp");
        disp.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
