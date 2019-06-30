package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.AutomovelVO;

/**
 * Servlet implementation class AutomovelController
 */
@WebServlet("/AutomovelController")
public class AutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AutomovelVO automovel;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomovelController() {
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
		System.out.println("ACAO AUTOMOVEL = " + acao);
		if(acao == null) {
			response.sendRedirect("automovel/listar.jsp");
		}else if(acao.equals("INSERIR AUTOMOVEL")) {
			String _chassi = request.getParameter("chassi");
			String _marca = request.getParameter("marca");
			String _tipo = request.getParameter("tipo");
			String _modelo = request.getParameter("modelo");
			String _preco = request.getParameter("preco");
			String _cor = request.getParameter("cor");
			String _ano = request.getParameter("ano");
			automovel = new AutomovelVO(Integer.parseInt(_tipo), Integer.parseInt(_modelo), Integer.parseInt(_marca), Float.parseFloat(_preco), Integer.parseInt(_cor), _chassi, Integer.parseInt(_ano));
			DAOFactory.createAutomovelDAO().inserir(automovel);
			response.sendRedirect("automovel/listar.jsp");
		}else if(acao.equals("edit")) {
			String chassiIni = request.getParameter("id");
			AutomovelVO automovelVO =  DAOFactory.createAutomovelDAO().consultar(chassiIni);
			request.getSession().setAttribute("automovel", automovelVO);
			response.sendRedirect("automovel/editar.jsp");
		}else if(acao.equals("remove")) {
			String chassiIni = request.getParameter("id");
			DAOFactory.createAutomovelDAO().excluir(chassiIni);
			response.sendRedirect("automovel/listar.jsp");
		}else if(acao.equals("ALTERAR AUTOMOVEL")) {
			String chassiIni = request.getParameter("chassiIni");
			String _chassi = request.getParameter("chassi");
			String _marca = request.getParameter("marca");
			String _tipo = request.getParameter("tipo");
			String _modelo = request.getParameter("modelo");
			String _preco = request.getParameter("preco");
			String _cor = request.getParameter("cor");
			String _ano = request.getParameter("ano");
			automovel = new AutomovelVO(Integer.parseInt(_tipo), Integer.parseInt(_modelo), Integer.parseInt(_marca), Float.parseFloat(_preco), Integer.parseInt(_cor), _chassi, Integer.parseInt(_ano));
			DAOFactory.createAutomovelDAO().alterar(automovel,chassiIni);
			response.sendRedirect("automovel/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("automovel/listar.jsp");
		}
	}

}
