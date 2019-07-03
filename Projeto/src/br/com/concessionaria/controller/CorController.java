package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.CorVO;

/**
 * Servlet implementation class CorController
 */
@WebServlet("/CorController")
public class CorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CorVO cor;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		System.out.println("ACAO COR = " + acao);
		if(acao == null) {
			response.sendRedirect("cor/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("cor/inserir.jsp");
		}else if(acao.equals("INSERIR COR")) {
			String _nome = request.getParameter("nome");
			cor = new CorVO(_nome);
			DAOFactory.createCorDAO().inserir(cor);
			response.sendRedirect("cor/listar.jsp");
		}else if(acao.equals("edit")) {
			String cor = request.getParameter("id");
			CorVO corVO =  DAOFactory.createCorDAO().consultar(cor);
			request.getSession().setAttribute("cor", corVO);
			response.sendRedirect("cor/editar.jsp");
		}else if(acao.equals("remove")) {
			String idIni = request.getParameter("id");
			DAOFactory.createCorDAO().excluir(idIni);
			response.sendRedirect("cor/listar.jsp");
		}else if(acao.equals("ALTERAR COR")) {
			String idIni = request.getParameter("idIni");
			String _nome = request.getParameter("nome");
			cor = new CorVO( _nome, Integer.parseInt(idIni));
			DAOFactory.createCorDAO().alterar(cor, idIni);
			response.sendRedirect("cor/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("cor/listar.jsp");
		}
	}

}
