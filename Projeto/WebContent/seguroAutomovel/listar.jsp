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
function inserir(){
	document.formListar.action="../SeguroAutomovelController?acao=inserir";
	document.formListar.submit();
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
   <div align="right" style="margin-right: 90px;margin-top: 30px;margin-bottom: 50px">
      	<button onclick="inserir()" class="btn waves-effect waves-light">CADASTRAR SEGURO PARA UM AUTOMÓVEL
	   		 	<i class="material-icons right">control_point</i>
	    </button>
	</div>
    <table class="striped" style="width: 90%; margin-left: 5%;">
     <thead>
     	<tr>
     	 <th width="15%">CHASSI</th>
     	 <th width="15%">SEGURO</th>
     	 <th width="15%">SEGURADORA</th>
     	 <th width="15%">FUNCIONÁRIO</th>
     	 <th width="15%">DATA</th>
     	 <th width="15%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr>
		<td><%=lista.get(i).getChassi()%></td>
        <td><%=DAOFactory.createSeguroDAO().consultar(Integer.toString(lista.get(i).getIdSeguro())).getNome()%></td>
        <td><%=DAOFactory.createSeguradoraDAO().consultar(Integer.toString(DAOFactory.createSeguroDAO().consultar(Integer.toString(lista.get(i).getIdSeguro())).getIdSeguradora())).getNomeSeguradora()%></td>
        <td><%=lista.get(i).getFuncCPF()%></td>
        <td><%=lista.get(i).getDataContrato().substring(0,10)%></td>
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