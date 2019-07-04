package br.com.concessionaria.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.vo.FuncionarioSalarioVO;

/**
 * Servlet implementation class FuncionarioSalarioController
 */
@WebServlet("/FuncionarioSalarioController")
public class FuncionarioSalarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FuncionarioSalarioVO funcSal;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionarioSalarioController() {
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
			response.sendRedirect("funcSal/listar.jsp");
		}else if(acao.equals("inserir")){
			response.sendRedirect("funcSal/inserir.jsp");
		}else if(acao.equals("INSERIR SALARIO")) {
			String _cpf = request.getParameter("cpf");
			String _sal = request.getParameter("sal");
			String _dtaIni = request.getParameter("dtaIni");
			funcSal = new FuncionarioSalarioVO(_cpf,Float.parseFloat(_sal),_dtaIni);
			DAOFactory.createFuncionarioSalarioDAO().inserir(funcSal);
			response.sendRedirect("funcSal/listar.jsp");
		}else if(acao.equals("edit")) {
			String cpfIni = request.getParameter("id1");
			String dataIni = request.getParameter("id2");
			FuncionarioSalarioVO funcionarioSalarioVO =  DAOFactory.createFuncionarioSalarioDAO().consultar(cpfIni,dataIni);
			request.getSession().setAttribute("funcSal", funcionarioSalarioVO);
			response.sendRedirect("funcSal/editar.jsp");
		}else if(acao.equals("remove")) {
			String cpfIni = request.getParameter("id1");
			String dataIni = request.getParameter("id2");
			DAOFactory.createFuncionarioSalarioDAO().excluir(cpfIni,dataIni);
			response.sendRedirect("funcSal/listar.jsp");
		}else if(acao.equals("ALTERAR SALARIO")) {
			String cpfIni = request.getParameter("cpfIni");
			String abc = request.getParameter("dataIni").substring(0,10);
			String def = request.getParameter("dataIni").substring(10,request.getParameter("dataIni").length());
			String dataIni = abc.concat("T").concat(def).replace(" ", "");
			String _dataIni = request.getParameter("dtaIni");
			String _cpf = request.getParameter("cpf");
			String _sal = request.getParameter("sal");
			funcSal = new FuncionarioSalarioVO(_cpf,Float.parseFloat(_sal),_dataIni);
			DAOFactory.createFuncionarioSalarioDAO().alterar(funcSal, cpfIni,dataIni);
			response.sendRedirect("funcSal/listar.jsp");
		}else{
			response.sendRedirect("funcSal/listar.jsp");
		}
	}

}
