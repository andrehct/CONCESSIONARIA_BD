package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.SeguradoraVO;

/**
 * Servlet implementation class SeguradoraController
 */
@WebServlet("/SeguradoraController")
public class SeguradoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SeguradoraVO seg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguradoraController() {
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
			response.sendRedirect("seguradora/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("seguradora/inserir.jsp");
		}else if(acao.equals("INSERIR SEGURADORA")) {
			String _nome = request.getParameter("nome");
			String _end = request.getParameter("end");
			String _tele = request.getParameter("tele");
			seg = new SeguradoraVO(_nome, _end, _tele);
			DAOFactory.createSeguradoraDAO().inserir(seg);
			response.sendRedirect("seguradora/listar.jsp");
		}else if(acao.equals("edit")) {
			String segu = request.getParameter("id");
			SeguradoraVO seguradoraVO =  DAOFactory.createSeguradoraDAO().consultar(segu);
			request.getSession().setAttribute("seguradora", seguradoraVO);
			response.sendRedirect("seguradora/editar.jsp");
		}else if(acao.equals("remove")) {
			String idIni = request.getParameter("id");
			DAOFactory.createSeguradoraDAO().excluir(idIni);
			response.sendRedirect("seguradora/listar.jsp");
		}else if(acao.equals("ALTERAR SEGURADORA")) {
			String idIni = request.getParameter("idIni");
			String _nome = request.getParameter("nome");
			String _end = request.getParameter("end");
			String _tele = request.getParameter("tele");
			seg = new SeguradoraVO( _nome, _end, _tele);
			DAOFactory.createSeguradoraDAO().alterar(seg, idIni);
			response.sendRedirect("seguradora/listar.jsp");
		}else{
			response.sendRedirect("seguradora/listar.jsp");
		}
	}

}
