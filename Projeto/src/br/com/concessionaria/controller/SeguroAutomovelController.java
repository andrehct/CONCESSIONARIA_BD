package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.SeguroAutomovelVO;

/**
 * Servlet implementation class SeguroAutomovelController
 */
@WebServlet("/SeguroAutomovelController")
public class SeguroAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SeguroAutomovelVO segAuto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguroAutomovelController() {
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
			response.sendRedirect("seguroAutomovel/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("seguroAutomovel/inserir.jsp");
		}else if(acao.equals("INSERIR SEGURO AUTOMOVEL")) {
			String _chassi = request.getParameter("chassi");
			String _seguro = request.getParameter("seguro");
			String _dta = request.getParameter("dta");
			String _cpf = request.getParameter("cpf");
			segAuto = new SeguroAutomovelVO (_chassi, Integer.parseInt(_seguro), _dta, _cpf);
			DAOFactory.createSeguroAutomovelDAO().inserir(segAuto);
			response.sendRedirect("seguroAutomovel/listar.jsp");
		}else if(acao.equals("edit")) {
			String idSegIni = request.getParameter("id1");
			String chassiIni = request.getParameter("id2");
			String dtaIni = request.getParameter("id3");
			SeguroAutomovelVO seguroAutomovelVO =  DAOFactory.createSeguroAutomovelDAO().consultar(idSegIni,chassiIni,dtaIni);
			request.getSession().setAttribute("seguroAuto", seguroAutomovelVO);
			response.sendRedirect("seguroAutomovel/editar.jsp");
		}else if(acao.equals("remove")) {
			String modeloIni = request.getParameter("id1");
			String marcaIni = request.getParameter("id2");
			String _ano = request.getParameter("id3");
			DAOFactory.createSeguroAutomovelDAO().excluir(modeloIni,marcaIni,_ano);
			response.sendRedirect("seguroAutomovel/listar.jsp");
		}else if(acao.equals("ALTERAR SEGURO AUTOMOVEL")) {
			String idSegIni = request.getParameter("idSegIni");
			String chassiIni = request.getParameter("chassiIni");
			String abc = request.getParameter("dataIni").substring(0,10);
			String def = request.getParameter("dataIni").substring(10,request.getParameter("dataIni").length());
			String dtaIni = abc.concat("T").concat(def).replace(" ", "");
			String _chassi = request.getParameter("chassi");
			String _seguro = request.getParameter("seguro");
			String _dta = request.getParameter("dta");
			String _cpf = request.getParameter("cpf");
			segAuto = new SeguroAutomovelVO (_chassi, Integer.parseInt(_seguro), _dta, _cpf);
			DAOFactory.createSeguroAutomovelDAO().alterar(segAuto, idSegIni,chassiIni,dtaIni);
			response.sendRedirect("seguroAutomovel/listar.jsp");
		}else{
			response.sendRedirect("seguroAutomovel/listar.jsp");
		}
	}

}
