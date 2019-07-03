package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.FuncVendaAutoVO;

/**
 * Servlet implementation class FuncVendaAutoController
 */
@WebServlet("/FuncVendaAutoController")
public class FuncVendaAutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FuncVendaAutoVO fva;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncVendaAutoController() {
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
		System.out.println("ACAO VENDA AUTOMOVEL = " + acao);
		if(acao == null) {
			response.sendRedirect("vendaAuto/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("vendaAuto/inserir.jsp");
		}else if(acao.equals("INSERIR")) {
			String _cpf = request.getParameter("cpf");
			String _chassi = request.getParameter("chassi");
			String _dta = request.getParameter("dta");
			fva = new FuncVendaAutoVO(_cpf,_chassi,_dta);
			DAOFactory.createFuncVendaAutoDAO().inserir(fva);
			response.sendRedirect("vendaAuto/listar.jsp");
		}else if(acao.equals("edit")) {
			String cpf = request.getParameter("id1");
			String chassi = request.getParameter("id2");
			String data = request.getParameter("id3");
			FuncVendaAutoVO funcVendaAutoVO =  DAOFactory.createFuncVendaAutoDAO().consultar(cpf,chassi,data);
			request.getSession().setAttribute("fva", funcVendaAutoVO);
			response.sendRedirect("vendaAuto/editar.jsp");
		}else if(acao.equals("remove")) {
			String cpf = request.getParameter("id1");
			String chassi = request.getParameter("id2");
			String data = request.getParameter("id3");
			DAOFactory.createFuncVendaAutoDAO().excluir(cpf,chassi,data);
			response.sendRedirect("vendaAuto/listar.jsp");
		}else if(acao.equals("ALTERAR")) {
			String cpfIni = request.getParameter("cpfIni");
			String chassiIni = request.getParameter("chassiIni");
			String abc = request.getParameter("dataIni").substring(0,10);
			String def = request.getParameter("dataIni").substring(10,request.getParameter("dataIni").length());
			String dtaIni = abc.concat("T").concat(def).replace(" ", "");
			String _cpf = request.getParameter("cpf");
			String _chassi = request.getParameter("chassi");
			String _dta = request.getParameter("dta");
			fva = new FuncVendaAutoVO(_cpf,_chassi,_dta);
			DAOFactory.createFuncVendaAutoDAO().alterar(fva, cpfIni,chassiIni,dtaIni);
			response.sendRedirect("vendaAuto/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("vendaAuto/listar.jsp");
		}
	}

}
