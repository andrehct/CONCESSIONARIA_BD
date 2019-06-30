<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.SeguroVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<SeguroVO> lista = DAOFactory.createSeguroDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Seguros :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(idSeg){
	if(window.confirm("Deseja realmente remover esse seguro?")){
		document.formListar.action="../SeguroController?acao=remove&id="+idSeg;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Seguro</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="20%">Nome</th>
     	 <th width="20%">Seguradora</th>
     	 <th width="20%">Preço</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
        <td><%=lista.get(i).getNome()%></td>
        <td><%=DAOFactory.createSeguradoraDAO().consultar(Integer.toString(lista.get(i).getIdSeguradora())).getNomeSeguradora()%></td>
        <td><%=lista.get(i).getPreco()%></td>
        <td>
        	<a href="../SeguroController?acao=edit&id=<%=lista.get(i).getIdSeguro()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getIdSeguro()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>