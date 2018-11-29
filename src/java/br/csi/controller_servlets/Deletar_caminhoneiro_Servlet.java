package br.csi.controller_servlets;


import br.csi.dao.CaminhoneiroDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"deletar_caminhoneiro"})
public class Deletar_caminhoneiro_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        boolean retorno = new CaminhoneiroDAO().delete(id);
        
        if(retorno){
            req.setAttribute("mensagem", "caminhoneiro deletado com sucesso!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/caminhoneiro_excluido.jsp");
            disp.forward(req,resp);

    }
        else{            
            req.setAttribute("mensagem","Desculpe o transtorno, mas esse caminhoneiro ainda precisa fazer algumas entregas e não poderá ser excluido no momento");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/caminhoneiro_excluido.jsp");
            disp.forward(req,resp);
        }
    }
}