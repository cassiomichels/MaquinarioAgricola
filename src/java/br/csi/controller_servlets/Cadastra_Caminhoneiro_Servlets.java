
package br.csi.controller_servlets;

import br.csi.dao.CaminhoneiroDAO;
import br.csi.model.Caminhoneiro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "cadastro_caminhoneiro")
public class Cadastra_Caminhoneiro_Servlets extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
                System.out.println("Chamou GET ....");
        RequestDispatcher disp 
            = req.getRequestDispatcher("/WEB-INF/views/cadastro_caminhoneiro.jsp");
            disp.forward(req, resp);
    }    
    
 @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("método post requisitado ....");
        
        PrintWriter resposta = resp.getWriter();
        
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String placa = req.getParameter("placa");
        Caminhoneiro caminhoneiro = new Caminhoneiro(nome,email, endereco, placa);
        
        boolean retorno = new CaminhoneiroDAO().create(caminhoneiro);
        if(retorno){

            req.setAttribute("caminhoneiro", nome);
 RequestDispatcher disp 
         = req.getRequestDispatcher("/WEB-INF/views/sucesso.jsp");
 disp.forward(req, resp);
           
            
        }else{            
resposta.println("<html><body><strong>ERRO</strong></body></html>");
        }
    }

    
    
}
