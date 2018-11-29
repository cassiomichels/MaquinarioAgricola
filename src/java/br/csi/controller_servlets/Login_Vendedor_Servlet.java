package br.csi.controller_servlets;

import br.csi.dao.VendedorDAO;
import br.csi.dao.Login_VendedorDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logar_vendedor")
public class Login_Vendedor_Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        System.err.println(email + " - " + senha);

        boolean autenticado
                = new Login_VendedorDAO().autenticar(email, senha);

        RequestDispatcher disp;

        if (autenticado) {
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado",
                    new VendedorDAO().read(email, senha));

            disp = req.getRequestDispatcher("/WEB-INF/views/pagina_inicial_vendedor.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("mensagem", "Usuário ou Senha INCORRETOS, Tente novamente ou cadastre-se");
            disp = req.getRequestDispatcher("login_vendedor.jsp");
            disp.forward(req, resp);
        }

    }

}
