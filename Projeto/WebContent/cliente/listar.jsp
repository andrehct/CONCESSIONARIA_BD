<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.ClienteVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<ClienteVO> lista = DAOFactory.createClienteDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Clientes :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(cpf){
	if(window.confirm("Deseja realmente remover esse cliente?")){
		document.formListar.action="../ClienteController?acao=remove&id="+cpf;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Cliente</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="10%">CPF</th>
     	 <th width="40%">Nome do Cliente</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
        <td><%=lista.get(i).getCpf()%></td>
        <td><%=lista.get(i).getNome()%></td>
        <td>
        	<a href="../ClienteController?acao=edit&id=<%=lista.get(i).getCpf()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getCpf()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>