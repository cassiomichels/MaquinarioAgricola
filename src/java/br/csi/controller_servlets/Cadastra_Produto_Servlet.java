package br.csi.controller_servlets;


import br.csi.dao.ProdutoDAO;
import br.csi.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(urlPatterns = "cadastro_produto")
public class Cadastra_Produto_Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
                System.out.println("Chamou GET ....");
        RequestDispatcher disp 
            = req.getRequestDispatcher("/WEB-INF/views/cadastro_produto.jsp");
            disp.forward(req, resp);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("método post requisitado ....");
        
        PrintWriter resposta = resp.getWriter();
        
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
       
        Produto produto = new Produto(nome, descricao);
        
        boolean retorno = new ProdutoDAO().create(produto);
        if(retorno){

            req.setAttribute("nome_produto", nome);
 RequestDispatcher disp 
         = req.getRequestDispatcher("/WEB-INF/views/sucesso_produto.jsp");
 disp.forward(req, resp);
           // resp.sendRedirect(req.getContextPath()+"/sucesso.html");
            
        }else{            
resposta.println("<html><body><strong>ERRO</strong></body></html>");
        }
    }

    
    
}
