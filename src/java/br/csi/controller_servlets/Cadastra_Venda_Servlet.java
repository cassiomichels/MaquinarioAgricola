package br.csi.controller_servlets;

import br.csi.dao.CaminhoneiroDAO;
import br.csi.dao.ClienteDAO;
import br.csi.dao.VendaDAO;
import br.csi.dao.ProdutoDAO;
import br.csi.model.Caminhoneiro;
import br.csi.model.Cliente;
import br.csi.model.Venda;
import br.csi.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "cadastro_venda")
public class Cadastra_Venda_Servlet extends HttpServlet{

 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
      System.out.println("Chamou doGet do Servlet ....");
      //processRequest(request, response);
      req.setAttribute("clientes", new ClienteDAO().getClientes());      
      req.setAttribute("caminhoneiros", new CaminhoneiroDAO().getCaminhoneiros());      
      req.setAttribute("produtos", new ProdutoDAO().getProdutos());
      //lista somente os veiculos disponiveis:
      ArrayList<Cliente> clientes = new ClienteDAO().getClientes(); 
      ArrayList<Caminhoneiro> caminhoneiros = new CaminhoneiroDAO().getCaminhoneiros();
      ArrayList<Produto> produtos = new ProdutoDAO().getProdutos();
     
      
      
            RequestDispatcher disp 
            = req.getRequestDispatcher("/WEB-INF/views/cadastro_venda.jsp");
            disp.forward(req, resp);
            

    }

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("método post requisitado ....");
        
        PrintWriter resposta = resp.getWriter();

        Venda pd = new Venda();
        pd.setId_cliente(Integer.parseInt(req.getParameter("id_cliente")));
        pd.setId_caminhoneiro(Integer.parseInt(req.getParameter("id_caminhoneiro")));
        pd.setId_produto(Integer.parseInt(req.getParameter("id_produto")));
        pd.setEndereco(req.getParameter("endereco"));
       boolean retorno = new VendaDAO().create(pd);
       
        if (retorno) {
            
            RequestDispatcher disp
                    = req.getRequestDispatcher("/WEB-INF/views/sucesso_venda.jsp");
            disp.forward(req, resp);
            

        } else {
            resposta.println("<html><body><strong>ERRO</strong></body></html>");
        }
    }

    
    
}
