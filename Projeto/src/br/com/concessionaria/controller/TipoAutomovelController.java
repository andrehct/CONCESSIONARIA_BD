package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.TipoAutomovelVO;

/**
 * Servlet implementation class TipoAutomovelController
 */
@WebServlet("/TipoAutomovelController")
public class TipoAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TipoAutomovelVO tpAuto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoAutomovelController() {
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
		if(acao == null) {
			response.sendRedirect("tipoAutomovel/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("tipoAutomovel/inserir.jsp");
		}else if(acao.equals("INSERIR TIPO")) {
			String _nome = request.getParameter("nome");
			tpAuto = new TipoAutomovelVO(_nome);
			DAOFactory.createTipoAutomovelDAO().inserir(tpAuto);
			response.sendRedirect("tipoAutomovel/listar.jsp");
		}else if(acao.equals("edit")) {
			String tipoAuto = request.getParameter("id");
			TipoAutomovelVO tipoAutomovelVO =  DAOFactory.createTipoAutomovelDAO().consultar(tipoAuto);
			request.getSession().setAttribute("tpauto", tipoAutomovelVO);
			response.sendRedirect("tipoAutomovel/editar.jsp");
		}else if(acao.equals("remove")) {
			String tipoAuto = request.getParameter("id");
			DAOFactory.createTipoAutomovelDAO().excluir(tipoAuto);
			response.sendRedirect("tipoAutomovel/listar.jsp");
		}else if(acao.equals("ALTERAR TIPO")) {
			String tpAutoIni = request.getParameter("tpautoIni");
			String _nome = request.getParameter("nome");
			tpAuto = new TipoAutomovelVO(_nome, Integer.parseInt(tpAutoIni));
			DAOFactory.createTipoAutomovelDAO().alterar(tpAuto, tpAutoIni);
			response.sendRedirect("tipoAutomovel/listar.jsp");
		}else{
			response.sendRedirect("tipoAutomovel/listar.jsp");
		}
	}

}
