package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.RevisaoVO;

/**
 * Servlet implementation class RevisaoController
 */
@WebServlet("/RevisaoController")
public class RevisaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RevisaoVO rev;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevisaoController() {
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
		System.out.println("ACAO REVISAO = " + acao);
		if(acao == null) {
			response.sendRedirect("revisao/listar.jsp");
		}else if(acao.equals("INSERIR REVISAO")) {
			String _cpf = request.getParameter("cpf");
			String _chassi = request.getParameter("chassi");
			String _dta = request.getParameter("dta");
			String _aceite = request.getParameter("aceite");
			String _placa = request.getParameter("placa");
			String _preco = request.getParameter("preco");
			rev = new RevisaoVO(_chassi,_cpf,_dta,Boolean.parseBoolean(_aceite),_placa,Float.parseFloat(_preco));
			DAOFactory.createRevisaoDAO().inserir(rev);
			response.sendRedirect("revisao/listar.jsp");
		}else if(acao.equals("edit")) {
			String cpf = request.getParameter("id1");
			String chassi = request.getParameter("id2");
			String data = request.getParameter("id3");
			RevisaoVO revisaoVO =  DAOFactory.createRevisaoDAO().consultar(cpf,chassi,data);
			request.getSession().setAttribute("revisao", revisaoVO);
			response.sendRedirect("revisao/editar.jsp");
		}else if(acao.equals("remove")) {
			String cpf = request.getParameter("id1");
			String chassi = request.getParameter("id2");
			String data = request.getParameter("id3");
			DAOFactory.createRevisaoDAO().excluir(cpf,chassi,data);
			response.sendRedirect("revisao/listar.jsp");
		}else if(acao.equals("ALTERAR REVISAO")) {
			String cpfIni = request.getParameter("cpfIni");
			String chassiIni = request.getParameter("chassiIni");
			String dtaIni = request.getParameter("dtaIni");
			String _cpf = request.getParameter("cpf");
			String _chassi = request.getParameter("chassi");
			String _dta = request.getParameter("dta");
			String _aceite = request.getParameter("aceite");
			String _placa = request.getParameter("placa");
			String _preco = request.getParameter("preco");
			rev = new RevisaoVO(_chassi,_cpf,_dta,Boolean.parseBoolean(_aceite),_placa,Float.parseFloat(_preco));
			DAOFactory.createRevisaoDAO().alterar(rev, cpfIni,chassiIni,dtaIni);
			response.sendRedirect("revisao/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("revisao/listar.jsp");
		}
	}

}
