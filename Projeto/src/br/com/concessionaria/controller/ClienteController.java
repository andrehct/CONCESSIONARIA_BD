package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.ClienteVO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteVO cli = new ClienteVO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
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
		System.out.println("ACAO CLIENTE = " + acao);
		if(acao == null) {
			response.sendRedirect("cliente/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("cliente/inserir.jsp");
		}else if(acao.equals("INSERIR CLIENTE")) {
			String _nome = request.getParameter("nome");
			String _cpf = request.getParameter("cpf");
			String _dataNasc = request.getParameter("nascimento");
			String _ende = request.getParameter("endereco");
			String _rg = request.getParameter("rg");
			cli = new ClienteVO(_cpf, _nome, _ende, _dataNasc, _rg);
			DAOFactory.createClienteDAO().inserir(cli);
			response.sendRedirect("cliente/listar.jsp");
		}else if(acao.equals("edit")) {
			String cpf = request.getParameter("id");
			ClienteVO clienteVO =  DAOFactory.createClienteDAO().consultar(cpf);
			request.getSession().setAttribute("cliente", clienteVO);
			response.sendRedirect("cliente/editar.jsp");
		}else if(acao.equals("remove")) {
			String cpf = request.getParameter("id");
			DAOFactory.createClienteDAO().excluir(cpf);
			response.sendRedirect("cliente/listar.jsp");
		}else if(acao.equals("ALTERAR CLIENTE")) {
			String cpfIni = request.getParameter("cpfIni");
			String _nome = request.getParameter("nome");
			String _cpf = request.getParameter("cpf");
			String _dataNasc = request.getParameter("nascimento");
			String _ende = request.getParameter("endereco");
			String _rg = request.getParameter("rg");
			cli = new ClienteVO(_cpf, _nome, _ende, _dataNasc, _rg);
			DAOFactory.createClienteDAO().alterar(cli, cpfIni);
			response.sendRedirect("cliente/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("cliente/listar.jsp");
		}
	}

	}
