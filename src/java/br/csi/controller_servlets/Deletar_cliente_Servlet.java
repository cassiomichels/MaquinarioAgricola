package br.csi.controller_servlets;



import br.csi.dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"deletar_cliente"})
public class Deletar_cliente_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        boolean retorno = new ClienteDAO().delete(id);
        
        if(retorno){
            req.setAttribute("mensagem", "Cliente deletado com sucesso!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/cliente_excluido.jsp");
            disp.forward(req,resp);

    }
        else{            
            req.setAttribute("mensagem","Desculpe o transtorno, mas não foi possivel excluir esse cliente no momento.");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/cliente_excluido.jsp");
            disp.forward(req,resp);
        }
    }
}