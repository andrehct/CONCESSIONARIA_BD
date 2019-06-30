<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.AutomovelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<AutomovelVO> lista = DAOFactory.createAutomovelDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Automóveis :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(chassi){
	if(window.confirm("Deseja realmente remover esse modelo?")){
		document.formListar.action="../AutomovelController?acao=remove&id="+chassi;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Automóvel</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="25%">Chassi</th>
     	 <th width="25%">Modelo</th>
     	 <th width="15%">Cor</th>
     	 <th width="10%">Tipo</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
        <td><%=lista.get(i).getChassi()%></td>
        <td><%=DAOFactory.createModeloDAO().consultar(Integer.toString(lista.get(i).getIdModelo()), Integer.toString(lista.get(i).getIdMarca()), Integer.toString(lista.get(i).getAno())).getNomeModelo()%></td>
        <td><%=DAOFactory.createCorDAO().consultar(Integer.toString(lista.get(i).getIdCor())).getNomeCor()%></td>
        <td><%=DAOFactory.createTipoAutomovelDAO().consultar(Integer.toString(lista.get(i).getIdTpAuto())).getNome()%></td>
        <td>
        	<a href="../AutomovelController?acao=edit&id=<%=lista.get(i).getChassi()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getChassi()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>