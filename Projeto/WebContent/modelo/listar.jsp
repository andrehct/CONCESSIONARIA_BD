<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.ModeloVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<ModeloVO> lista = DAOFactory.createModeloDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Modelos :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(idModelo,idMarca, ano){
	if(window.confirm("Deseja realmente remover esse modelo?")){
		document.formListar.action="../ModeloController?acao=remove&id1="+idModelo+"&id2="+idMarca+"&id3="+ano;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Modelo</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="25%">Modelo</th>
     	 <th width="25%">Marca</th>
     	 <th width="10%">Ano</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
        <td><%=lista.get(i).getNomeModelo()%></td>
        <td><%=DAOFactory.createMarcaDAO().consultar(Integer.toString(lista.get(i).getIdMarca())).getNomeMarca()%></td>
        <td><%=lista.get(i).getAno()%></td>
        <td>
        	<a href="../ModeloController?acao=edit&id1=<%=lista.get(i).getIdModelo()%>&id2=<%=lista.get(i).getIdMarca()%>&id3=<%=lista.get(i).getAno()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getIdModelo()%>','<%=lista.get(i).getIdMarca()%>','<%=lista.get(i).getAno()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>