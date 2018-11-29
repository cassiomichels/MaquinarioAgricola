
package br.csi.controller_servlets;

import br.csi.dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/busca_cliente"})
public class Busca_Cliente_Servlet extends HttpServlet {


    public Busca_Cliente_Servlet() {
    
    }

   
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Chamou doGet do Servlet ....");
      request.setAttribute("clientes", new ClienteDAO().getClientes());      

            RequestDispatcher disp 
            = request.getRequestDispatcher("/WEB-INF/views/busca_cliente.jsp");
            disp.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
