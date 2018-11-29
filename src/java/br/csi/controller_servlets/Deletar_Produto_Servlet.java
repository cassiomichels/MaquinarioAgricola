package br.csi.controller_servlets;


import br.csi.dao.ProdutoDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"deletar_produto"})
public class Deletar_Produto_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        boolean retorno = new ProdutoDAO().delete(id);
        
        if(retorno){
            req.setAttribute("mensagem", "Máquina deletada com sucesso!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/produto_excluido.jsp");
            disp.forward(req,resp);

    }
                else{            
            req.setAttribute("mensagem","pedimos desculpas pelo transtorno, mas não foi possivel excluir no momento");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/caminhoneiro_excluido.jsp");
            disp.forward(req,resp);
        }
    }
}