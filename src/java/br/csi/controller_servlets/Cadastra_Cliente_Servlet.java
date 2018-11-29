package br.csi.controller_servlets;

import br.csi.dao.ClienteDAO;
import br.csi.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "cadastro_cliente")
public class Cadastra_Cliente_Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
        RequestDispatcher disp 
            = req.getRequestDispatcher("/WEB-INF/views/cadastro_cliente.jsp");
            disp.forward(req, resp);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("método post requisitado ....");
        
        PrintWriter resposta = resp.getWriter();
        
        String nome = req.getParameter("nome");
        String email= req.getParameter("email");
        String senha= req.getParameter("senha");
        String endereco = req.getParameter("endereco");
       
        Cliente cliente = new Cliente(nome, email, senha, endereco);
        
        boolean retorno = new ClienteDAO().create(cliente);
        if(retorno){

            req.setAttribute("nome_cliente", nome);
 RequestDispatcher disp 
         = req.getRequestDispatcher("/WEB-INF/views/sucesso_cliente.jsp");
 disp.forward(req, resp);
          
            
        }else{            
resposta.println("<html><body><strong>ERRO</strong></body></html>");
        }
    }

    
    
}
