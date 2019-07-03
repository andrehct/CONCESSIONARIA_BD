package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.ClienteAutomovelVO;

/**
 * Servlet implementation class ClienteAutomovelController
 */
@WebServlet("/ClienteAutomovelController")
public class ClienteAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteAutomovelVO cliAuto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteAutomovelController() {
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
		System.out.println("ACAO CLIENTE AUTOMOVEL = " + acao);
		if(acao == null) {
			response.sendRedirect("clienteAuto/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("clienteAuto/inserir.jsp");
		}else if(acao.equals("INSERIR")) {
			String _cpf = request.getParameter("cpf");
			String _chassi = request.getParameter("chassi");
			String _placa = request.getParameter("placa");
			String _dta = request.getParameter("dtaIni");
			cliAuto = new ClienteAutomovelVO(_chassi,_cpf, _dta);
			if(_placa != null || _placa != ""){
				cliAuto.setPlaca(_placa);
			}
			DAOFactory.createClienteAutomovelDAO().inserir(cliAuto);
			response.sendRedirect("clienteAuto/listar.jsp");
		}else if(acao.equals("edit")) {
			String cpfIni = request.getParameter("id1");
			String chassiIni = request.getParameter("id2");
			String dataIni = request.getParameter("id3");
			ClienteAutomovelVO clienteAutomovelVO =  DAOFactory.createClienteAutomovelDAO().consultar(chassiIni,cpfIni,dataIni);
			request.getSession().setAttribute("cliAuto", clienteAutomovelVO);
			response.sendRedirect("clienteAuto/editar.jsp");
		}else if(acao.equals("remove")) {
			String cpfIni = request.getParameter("id1");
			String chassiIni = request.getParameter("id2");
			String dataIni = request.getParameter("id3");
			DAOFactory.createClienteAutomovelDAO().excluir(chassiIni,cpfIni,dataIni);
			response.sendRedirect("clienteAuto/listar.jsp");
		}else if(acao.equals("ALTERAR")) {
			String cpfIni = request.getParameter("cpfIni");
			String chassiIni = request.getParameter("chassiIni");
			String abc = request.getParameter("dtaIni").substring(0,10);
			String def = request.getParameter("dtaIni").substring(10,request.getParameter("dtaIni").length());
			String dataIni = abc.concat("T").concat(def).replace(" ", "");
			String _cpf = request.getParameter("cpf");
			String _chassi = request.getParameter("chassi");
			String _placa = request.getParameter("placa");
			String _dta = request.getParameter("dataIni");
			cliAuto = new ClienteAutomovelVO(_chassi,_cpf,_placa,_dta);
			DAOFactory.createClienteAutomovelDAO().alterar(cliAuto, chassiIni,cpfIni,dataIni);
			response.sendRedirect("clienteAuto/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("clienteAuto/listar.jsp");
		}
	}

}
