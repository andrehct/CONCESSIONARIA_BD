package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.CargoVO;

/**
 * Servlet implementation class CargoController
 */
@WebServlet("/CargoController")
public class CargoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CargoVO cargo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargoController() {
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
			response.sendRedirect("cargo/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("cargo/inserir.jsp");
		}else if(acao.equals("INSERIR CARGO")) {
			String _nome = request.getParameter("nome");
			cargo = new CargoVO(_nome);
			DAOFactory.createCargoDAO().inserir(cargo);
			response.sendRedirect("cargo/listar.jsp");
		}else if(acao.equals("edit")) {
			String idCargo = request.getParameter("id");
			CargoVO cargoVO =  DAOFactory.createCargoDAO().consultar(idCargo);
			request.getSession().setAttribute("cargo", cargoVO);
			response.sendRedirect("cargo/editar.jsp");
		}else if(acao.equals("remove")) {
			String idCargo = request.getParameter("id");
			DAOFactory.createCargoDAO().excluir(idCargo);
			response.sendRedirect("cargo/listar.jsp");
		}else if(acao.equals("ALTERAR CARGO")) {
			String idCargo = request.getParameter("idIni");
			String _nome = request.getParameter("nome");
			cargo = new CargoVO( _nome, Integer.parseInt(idCargo));
			DAOFactory.createCargoDAO().alterar(cargo, idCargo);
			response.sendRedirect("cargo/listar.jsp");
		}else{
			response.sendRedirect("cargo/listar.jsp");
		}
	}

}
