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
function inserir(){
	document.formListar.action="../SeguroController?acao=inserir";
	document.formListar.submit();
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <div align="right" style="margin-right: 90px;margin-top: 30px;margin-bottom: 50px">
      	<button onclick="inserir()" class="btn waves-effect waves-light">CADASTRAR SEGURO
	   		 	<i class="material-icons right">control_point</i>
	    </button>
	</div>
    <table class="striped" style="width: 90%; margin-left: 5%;">
     <thead>
     	<tr>
     	 <th width="20%">Nome</th>
     	 <th width="20%">Seguradora</th>
     	 <th width="20%">Preço</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr>
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