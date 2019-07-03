package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.MarcaVO;

/**
 * Servlet implementation class MarcaController
 */
@WebServlet("/MarcaController")
public class MarcaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MarcaVO marca;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarcaController() {
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
		System.out.println("ACAO MARCA = " + acao);
		if(acao == null) {
			response.sendRedirect("marca/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("marca/inserir.jsp");
		}else if(acao.equals("INSERIR MARCA")) {
			String _nome = request.getParameter("nome");
			marca = new MarcaVO(_nome);
			DAOFactory.createMarcaDAO().inserir(marca);
			response.sendRedirect("marca/listar.jsp");
		}else if(acao.equals("edit")) {
			String idMarca = request.getParameter("id");
			MarcaVO marcaVO =  DAOFactory.createMarcaDAO().consultar(idMarca);
			request.getSession().setAttribute("marca", marcaVO);
			response.sendRedirect("marca/editar.jsp");
		}else if(acao.equals("remove")) {
			String idMarca = request.getParameter("id");
			DAOFactory.createMarcaDAO().excluir(idMarca);
			response.sendRedirect("marca/listar.jsp");
		}else if(acao.equals("ALTERAR MARCA")) {
			String marcaIni = request.getParameter("marcaIni");
			String _nome = request.getParameter("nome");
			marca = new MarcaVO(_nome, Integer.parseInt(marcaIni));
			DAOFactory.createMarcaDAO().alterar(marca, marcaIni);
			response.sendRedirect("marca/listar.jsp");
		}else{
			System.out.println("n deveria");
			response.sendRedirect("marca/listar.jsp");
		}
	}

}
