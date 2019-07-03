<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncionarioSalarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<FuncionarioSalarioVO> lista = DAOFactory.createFuncionarioSalarioDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Cargos :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(cpf, dta){
	if(window.confirm("Deseja realmente remover esse sal�rio do funcion�rio?")){
		document.formListar.action="../FuncionarioSalarioController?acao=remove&id1="+cpf+"&id2="+dta;
		document.formListar.submit();
	}
}
function inserir(){
	document.formListar.action="../FuncionarioSalarioController?acao=inserir";
	document.formListar.submit();
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <div align="right" style="margin-right: 90px;margin-top: 30px;margin-bottom: 50px">
      	<button onclick="inserir()" class="btn waves-effect waves-light">CADASTRAR SAL�RIO
	   		 	<i class="material-icons right">control_point</i>
	    </button>
	</div>
    <table class="striped" style="width: 90%; margin-left: 5%;">
     <thead>
     	<tr>
     	 <th width="30%">Funcion�rio</th>
     	 <th width="15%">Sal�rio</th>
     	 <th width="15%">Data Inicial</th>
     	 <th width="15%" align="right">A��o</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr>
        <td><%=DAOFactory.createFuncionarioDAO().consultar(lista.get(i).getFuncCPF()).getNome()%></td>
        <td><%=lista.get(i).getSalario()%></td>
        <td><%=lista.get(i).getDataIni().substring(0,10)%></td>
        <td>
        	<a href="../FuncionarioSalarioController?acao=edit&id1=<%=lista.get(i).getFuncCPF()%>&id2=<%=lista.get(i).getDataIni()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getFuncCPF()%>','<%=lista.get(i).getDataIni()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>