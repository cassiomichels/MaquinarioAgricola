package br.csi.controller_servlets;


import br.csi.excecoes.AutenticacaoException;
import br.csi.model.Autenticavel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.csi.servicos.Autenticador;
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final Autenticador autenticador = new Autenticador();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        
        RequestDispatcher disp;
        try
        {
            Autenticavel usuarioAutenticado = autenticador.autenticar(email, senha);
            
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado", usuarioAutenticado);
            
            disp = req.getRequestDispatcher("/WEB-INF/views/pagina_inicial_cliente.jsp");
            disp.forward(req, resp);
        }
        catch(AutenticacaoException ex)
        {
            req.setAttribute("mensagem", "Usuário ou Senha INCORRETOS, Tente novamente ou cadastre-se");
            disp = req.getRequestDispatcher("login_cliente.jsp");
            disp.forward(req, resp);
        }
    }
}
