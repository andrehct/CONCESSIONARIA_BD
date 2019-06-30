<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.SeguradoraVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<SeguradoraVO> lista = DAOFactory.createSeguradoraDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Seguradoras :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(idSeg){
	if(window.confirm("Deseja realmente remover essa seguradora?")){
		document.formListar.action="../SeguradoraController?acao=remove&id="+idSeg;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Seguradora</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="20%">Nome</th>
     	 <th width="20%">Endereço</th>
     	 <th width="20%">Telefone</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
        <td><%=lista.get(i).getNomeSeguradora()%></td>
        <td><%=lista.get(i).getEndereco()%></td>
        <td><%=lista.get(i).getTelefone()%></td>
        <td>
        	<a href="../SeguradoraController?acao=edit&id=<%=lista.get(i).getIdSeg()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getIdSeg()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>