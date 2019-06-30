<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.SeguroAutomovelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<SeguroAutomovelVO> lista = DAOFactory.createSeguroAutomovelDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Seguros dos Automóveis :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(idSeg, chassi, data){
	if(window.confirm("Deseja realmente remover esse automóvel segurado?")){
		document.formListar.action="../SeguroAutomovelController?acao=remove&id1="+idSeg+"&id2="+chassi+"&id3="+data;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Seguro Automóvel</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="20%">CHASSI</th>
     	 <th width="20%">SEGURO</th>
     	 <th width="20%">SEGURADORA</th>
     	 <th width="20%">FUNCIONÁRIO</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
		<td><%=lista.get(i).getChassi()%></td>
        <td><%=DAOFactory.createSeguroDAO().consultar(Integer.toString(lista.get(i).getIdSeguro())).getNome()%></td>
        <td><%=DAOFactory.createSeguradoraDAO().consultar(Integer.toString(DAOFactory.createSeguroDAO().consultar(Integer.toString(lista.get(i).getIdSeguro())).getIdSeguradora())).getNomeSeguradora()%></td>
        <td><%=lista.get(i).getFuncCPF()%></td>
        <td>
        	<a href="../SeguroAutomovelController?acao=edit&id1=<%=lista.get(i).getIdSeguro()%>&id2=<%=lista.get(i).getChassi()%>&id3=<%=lista.get(i).getDataContrato()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getIdSeguro()%>','<%=lista.get(i).getChassi()%>','<%=lista.get(i).getDataContrato()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>