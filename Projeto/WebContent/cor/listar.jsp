<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.CorVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<CorVO> lista = DAOFactory.createCorDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Cores :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(idCor){
	if(window.confirm("Deseja realmente remover essa cor?")){
		document.formListar.action="../CorController?acao=remove&id="+idCor;
		document.formListar.submit();
	}
}
function inserir(){
	document.formListar.action="../CorController?acao=inserir";
	document.formListar.submit();
}
</script>
</head>





<body>
<form action="" name="formListar" method="post">
    <div align="right" style="margin-right: 90px;margin-top: 30px;margin-bottom: 50px">
      	<button onclick="inserir()" class="btn waves-effect waves-light">CADASTRAR COR
	   		 	<i class="material-icons right">control_point</i>
	    </button>
	</div>
    
    <table class="striped" style="width: 90%; margin-left: 5%;">
     <thead>
     	<tr>
     	 <th width="40%">Nome da cor</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr>
       <td><%=lista.get(i).getNomeCor()%></td>
       <td>
	       	<a href="../CorController?acao=edit&id=<%=lista.get(i).getIdCor()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getIdCor()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        </td>
    </tr>
    <%}%>
    </table>
</form>
</body>





</html>