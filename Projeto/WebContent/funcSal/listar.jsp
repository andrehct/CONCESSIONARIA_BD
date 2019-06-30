<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncionarioSalarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<FuncionarioSalarioVO> lista = DAOFactory.createFuncionarioSalarioDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Cargos :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(cpf, dta){
	if(window.confirm("Deseja realmente remover esse salário do funcionário?")){
		document.formListar.action="../FuncionarioSalarioController?acao=remove&id1="+cpf+"&id2="+dta;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Salário</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="30%">Funcionário</th>
     	 <th width="30%">Salário</th>
     	 <th width="15%">Data Inicial</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
        <td><%=lista.get(i).getFuncCPF()%></td>
        <td><%=lista.get(i).getSalario()%></td>
        <td><%=lista.get(i).getDataIni()%></td>
        <td>
        	<a href="../FuncionarioSalarioController?acao=edit&id1=<%=lista.get(i).getFuncCPF()%>&id2=<%=lista.get(i).getDataIni()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getFuncCPF()%>','<%=lista.get(i).getDataIni()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>