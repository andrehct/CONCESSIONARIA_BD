package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.ModeloVO;

/**
 * Servlet implementation class ModeloController
 */
@WebServlet("/ModeloController")
public class ModeloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ModeloVO mod;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeloController() {
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
		System.out.println("ACAO MODELO = " + acao);
		if(acao == null) {
			response.sendRedirect("modelo/listar.jsp");
		}else if(acao.equals("INSERIR MODELO")) {
			String _nome = request.getParameter("modelo");
			String marca = request.getParameter("marca");
			String ano = request.getParameter("ano");
			mod = new ModeloVO(_nome,Integer.parseInt(ano),Integer.parseInt(marca));
			DAOFactory.createModeloDAO().inserir(mod);
			response.sendRedirect("modelo/listar.jsp");
		}else if(acao.equals("edit")) {
			String modeloIni = request.getParameter("id1");
			String marcaIni = request.getParameter("id2");
			String _ano = request.getParameter("id3");
			//System.out.println("mod = " +modeloIni+" marca = " +marcaIni+ " ano = " +_ano);
			ModeloVO modeloVO =  DAOFactory.createModeloDAO().consultar(modeloIni,marcaIni,_ano);
			request.getSession().setAttribute("modelo", modeloVO);
			response.sendRedirect("modelo/editar.jsp");
		}else if(acao.equals("remove")) {
			String modeloIni = request.getParameter("id1");
			String marcaIni = request.getParameter("id2");
			String _ano = request.getParameter("id3");
			DAOFactory.createModeloDAO().excluir(modeloIni,marcaIni,_ano);
			response.sendRedirect("modelo/listar.jsp");
		}else if(acao.equals("ALTERAR MODELO")) {
			String marcaIni = request.getParameter("MarcaIni");
			String modeloIni = request.getParameter("ModeloIni");
			String _ano = request.getParameter("AnoIni");
			String _nome = request.getParameter("modelo");
			String marca = request.getParameter("marca");
			String ano = request.getParameter("ano");
			mod = new ModeloVO(_nome,Integer.parseInt(ano),Integer.parseInt(marca));
			DAOFactory.createModeloDAO().alterar(mod, modeloIni,marcaIni,_ano);
			response.sendRedirect("modelo/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("modelo/listar.jsp");
		}
	}

}
