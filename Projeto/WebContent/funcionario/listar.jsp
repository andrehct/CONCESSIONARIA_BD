<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<FuncionarioVO> lista = DAOFactory.createFuncionarioDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Funcionários :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(cpf){
	if(window.confirm("Deseja realmente remover esse funcionário?")){
		document.formListar.action="../FuncionarioController?acao=remove&id="+cpf;
		document.formListar.submit();
	}
}
function inserir(){
	document.formListar.action="../FuncionarioController?acao=inserir";
	document.formListar.submit();
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <div align="right" style="margin-right: 90px;margin-top: 30px;margin-bottom: 50px">
      	<button onclick="inserir()" class="btn waves-effect waves-light">CADASTRAR FUNCIONÁRIO
	   		 	<i class="material-icons right">control_point</i>
	    </button>
	</div>
    <table class="striped" style="width: 90%; margin-left: 5%;">
     <thead>
     	<tr>
     	 <th width="15%">CPF</th>
     	 <th width="30%">Nome do Funcionário</th>
     	 <th width="20%">Cargo</th>
     	 <th width="15%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr>
        <td><%=lista.get(i).getCPF()%></td>
        <td><%=lista.get(i).getNome()%></td>
        <td><%=DAOFactory.createCargoDAO().consultar(Integer.toString(lista.get(i).getIdCargo())).getNomeCargo()%></td>
        <td>
        	<a href="../FuncionarioController?acao=edit&id=<%=lista.get(i).getCPF()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getCPF()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>