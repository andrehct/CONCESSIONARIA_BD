<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncVendaAutoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<FuncVendaAutoVO> lista = DAOFactory.createFuncVendaAutoDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Revisões :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(cpf,chassi,dta){
	if(window.confirm("Deseja realmente remover essa venda de automóvel?")){
		document.formListar.action="../FuncVendaAutoController?acao=remove&id1="+cpf+"&id2="+chassi+"&id3="+dta;
		document.formListar.submit();
	}
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <br/> 
      <div align="right"><a href="inserir.jsp" class="waves-effect waves-light btn-small"><i class="material-icons left">control_point</i>Cadastrar Revisão</a></div>
    <br/>
    <table class="collection">
     <thead>
     	<tr>
     	 <th width="25%">Funcionário</th>
     	 <th width="15%">Chassi</th>
     	 <th width="15%">Data</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr <%if(i % 2 == 0){ %> class="collection-item active"<%}else{%><%}%>>
        <td><%=lista.get(i).getFuncCPF()%></td>
        <td><%=lista.get(i).getChassi()%></td>
        <td><%=lista.get(i).getDataVenda().substring(0,10)%></td>
        <td>
        	<a href="../FuncVendaAutoController?acao=edit&id1=<%=lista.get(i).getFuncCPF()%>&id2=<%=lista.get(i).getChassi()%>&id3=<%=lista.get(i).getDataVenda()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getFuncCPF()%>','<%=lista.get(i).getChassi()%>','<%=lista.get(i).getDataVenda()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>