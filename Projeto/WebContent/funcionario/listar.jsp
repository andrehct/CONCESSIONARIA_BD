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
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Funcionário</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="15%">CPF</th>
     	 <th width="30%">Nome do Funcionário</th>
     	 <th width="20%">Cargo</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
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