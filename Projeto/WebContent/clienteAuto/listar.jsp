<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.ClienteAutomovelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<ClienteAutomovelVO> lista = DAOFactory.createClienteAutomovelDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Cargos :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(cpf, chassi, dta){
	if(window.confirm("Deseja realmente remover esse Automóvel do Cliente?")){
		document.formListar.action="../ClienteAutomovelController?acao=remove&id1="+cpf+"&id2="+chassi+"&id3=" +dta;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Automóvel para Cliente</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="30%">Cliente</th>
     	 <th width="30%">Chassi</th>
     	 <th width="15%">Data Inicial</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
        <td><%=lista.get(i).getClienteCPF()%></td>
        <td><%=lista.get(i).getChassi()%></td>
        <td><%=lista.get(i).getDataInicio()%></td>
        <td>
        	<a href="../ClienteAutomovelController?acao=edit&id1=<%=lista.get(i).getClienteCPF()%>&id2=<%=lista.get(i).getChassi()%>&id3=<%=lista.get(i).getDataInicio()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getClienteCPF()%>','<%=lista.get(i).getChassi()%>', '<%=lista.get(i).getDataInicio()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>