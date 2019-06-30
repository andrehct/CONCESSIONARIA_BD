package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.SeguroVO;

/**
 * Servlet implementation class SeguroController
 */
@WebServlet("/SeguroController")
public class SeguroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SeguroVO seg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguroController() {
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
		System.out.println("ACAO SEGURO = " + acao);
		if(acao == null) {
			response.sendRedirect("seguro/listar.jsp");
		}else if(acao.equals("INSERIR SEGURO")) {
			String _nome = request.getParameter("nome");
			String _seg = request.getParameter("seguradora");
			String _preco = request.getParameter("preco");
			seg = new SeguroVO(_nome, Float.parseFloat(_preco), Integer.parseInt(_seg));
			DAOFactory.createSeguroDAO().inserir(seg);
			response.sendRedirect("seguro/listar.jsp");
		}else if(acao.equals("edit")) {
			String segu = request.getParameter("id");
			SeguroVO seguroVO =  DAOFactory.createSeguroDAO().consultar(segu);
			request.getSession().setAttribute("seguro", seguroVO);
			response.sendRedirect("seguro/editar.jsp");
		}else if(acao.equals("remove")) {
			String idIni = request.getParameter("id");
			DAOFactory.createSeguroDAO().excluir(idIni);
			response.sendRedirect("seguro/listar.jsp");
		}else if(acao.equals("ALTERAR SEGURO")) {
			String idIni = request.getParameter("idIni");
			String _nome = request.getParameter("nome");
			String _seg = request.getParameter("seguradora");
			String _preco = request.getParameter("preco");
			seg = new SeguroVO(_nome, Float.parseFloat(_preco), Integer.parseInt(_seg));
			DAOFactory.createSeguroDAO().alterar(seg, idIni);
			response.sendRedirect("seguro/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("seguro/listar.jsp");
		}
	}

}
