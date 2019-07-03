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
	if(window.confirm("Deseja realmente remover esse automovel?")){
		document.formListar.action="../AutomovelController?acao=remove&id="+chassi;
		document.formListar.submit();
	}
}
function inserir(){
	document.formListar.action="../AutomovelController?acao=inserir";
	document.formListar.submit();
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <div align="right" style="margin-right: 90px;margin-top: 30px;margin-bottom: 50px">
      	<button onclick="inserir()" class="btn waves-effect waves-light">CADASTRAR AUTOMÓVEL
	   		 	<i class="material-icons right">control_point</i>
	    </button>
	</div>
    <table class="striped" style="width: 90%; margin-left: 5%;">
     <thead>
     	<tr>
     	 <th width="20%">Chassi</th>
     	 <th width="20%">Modelo</th>
     	 <th width="15%">Cor</th>
     	 <th width="15%">Tipo</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr>
        <td><%=lista.get(i).getChassi()%></td>
        <td><%=DAOFactory.createModeloDAO().consultar(Integer.toString(lista.get(i).getIdModelo())).getNomeModelo()%></td>
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