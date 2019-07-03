package br.com.concessionaria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.FuncionarioVO;

/**
 * Servlet implementation class FuncionarioController
 */
@WebServlet("/FuncionarioController")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FuncionarioVO func;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuncionarioController() {
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
		System.out.println("ACAO FUNCIONARIO = " + acao);
		if(acao == null) {
			response.sendRedirect("funcionario/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("funcionario/inserir.jsp");
		}else if(acao.equals("INSERIR FUNCIONARIO")) {
			String _nome = request.getParameter("nome");
			String _cpf = request.getParameter("cpf");
			String _dataCon = request.getParameter("contratacao");
			String _dataNasc = request.getParameter("nascimento");
			String _nivel = request.getParameter("nivel");
			String _cargo = request.getParameter("cargo");
			String _ende = request.getParameter("endereco");
			String _rg = request.getParameter("rg");
			func = new FuncionarioVO(_cpf, _nome, _ende, _dataNasc, _rg, _dataCon, Integer.parseInt(_cargo), Integer.parseInt(_nivel));
			DAOFactory.createFuncionarioDAO().inserir(func);
			response.sendRedirect("funcionario/listar.jsp");
		}else if(acao.equals("edit")) {
			String cpf = request.getParameter("id");
			FuncionarioVO funcionarioVO =  DAOFactory.createFuncionarioDAO().consultar(cpf);
			request.getSession().setAttribute("funcionario", funcionarioVO);
			response.sendRedirect("funcionario/editar.jsp");
		}else if(acao.equals("remove")) {
			String cpf = request.getParameter("id");
			DAOFactory.createFuncionarioDAO().excluir(cpf);
			response.sendRedirect("funcionario/listar.jsp");
		}else if(acao.equals("ALTERAR FUNCIONARIO")) {
			String cpfIni = request.getParameter("cpfIni");
			String _nome = request.getParameter("nome");
			String _cpf = request.getParameter("cpf");
			String _dataCon = request.getParameter("contratacao");
			String _dataNasc = request.getParameter("nascimento");
			String _nivel = request.getParameter("nivel");
			String _cargo = request.getParameter("cargo");
			String _ende = request.getParameter("endereco");
			String _rg = request.getParameter("rg");
			func = new FuncionarioVO(_cpf, _nome, _ende, _dataNasc, _rg, _dataCon, Integer.parseInt(_cargo), Integer.parseInt(_nivel));
			DAOFactory.createFuncionarioDAO().alterar(func, cpfIni);
			response.sendRedirect("funcionario/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("funcionario/listar.jsp");
		}
	}

}
