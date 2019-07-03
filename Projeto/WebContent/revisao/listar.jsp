<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.RevisaoVO"%>
<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<RevisaoVO> lista = DAOFactory.createRevisaoDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Lista de Revisões :::</title>
<%@ include file="../menu.jsp" %>
<script type="text/javascript">
function remover(cpf,chassi,dta){
	if(window.confirm("Deseja realmente remover essa revisão?")){
		document.formListar.action="../RevisaoController?acao=remove&id1="+cpf+"&id2="+chassi+"&id3="+dta;
		document.formListar.submit();
	}
}
function inserir(){
	document.formListar.action="../RevisaoController?acao=inserir";
	document.formListar.submit();
}
</script>
</head>
<body>
<form action="" name="formListar" method="post">
    <div align="right" style="margin-right: 90px;margin-top: 30px;margin-bottom: 50px">
      	<button onclick="inserir()" class="btn waves-effect waves-light">CADASTRAR REVISÃO
	   		 	<i class="material-icons right">control_point</i>
	    </button>
	</div>
    <table class="striped" style="width: 90%; margin-left: 5%;">
     <thead>
     	<tr>
     	 <th width="25%">Funcionário</th>
     	 <th width="15%">Chassi</th>
     	 <th width="15%">Data</th>
     	 <th width="15%">Aceite</th>
     	 <th width="10%" align="right">Ação</th>
     	</tr>
     </thead> 
    <%for(int i = 0; i < lista.size(); i++){%>
	<tr>
        <td><%=DAOFactory.createFuncionarioDAO().consultar(lista.get(i).getFuncCPF()).getNome()%></td>
        <td><%=lista.get(i).getChassi()%></td>
        <td><%=lista.get(i).getDataRev().substring(0,10)%></td>
        <td><%=lista.get(i).getAceite()%></td>
        <td>
        	<a href="../RevisaoController?acao=edit&id1=<%=lista.get(i).getFuncCPF()%>&id2=<%=lista.get(i).getChassi()%>&id3=<%=lista.get(i).getDataRev()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">create</i></a>
        	<a href="#" onclick="remover('<%=lista.get(i).getFuncCPF()%>','<%=lista.get(i).getChassi()%>','<%=lista.get(i).getDataRev()%>')" class="waves-effect waves-light btn-small"><i class="material-icons left">remove_circle_outline</i></a>
        	
        </td>
        	
      </tr>
    <%}%>
    </table>
</form>
</body>
</html>