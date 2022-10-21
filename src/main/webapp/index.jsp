<%@page import="modelo.javabeans.Tipo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="modelo.javabeans.Evento"%>
<%@page import="modelo.dao.EventoDaoImpl"%>
<%@page import="modelo.dao.IntEventoDao"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Un titulillo para ver que funciona</title>
</head>
<body>
	<table border = "2">
		<tr>
			<td><strong><button style="center;"><a href ="">Tipos</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Eventos</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Usuarios</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Eventos/tipo</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Login</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Registro</a></button></strong></td>
			<td><strong><button style="center;"><a href ="">Salir</a></button></strong></td>
		</tr>
	</table>
	<%List<Evento> lista = (List<Evento>)request.getAttribute("eventos"); %>
		<h1><%= request.getAttribute("mensaje") %></h1>
		<button style="center;"><a href ="altaEvento.jsp">Nuevo evento</a></button>
		<button style="center;"><a href ="eventos?opcion=activo">Activos</a></button>
		<button style="center;"><a href ="eventos?opcion=todos">Todos</a></button>
		<!-- <button ><a href ="eventos?opcion=reset">Resetear sesión</a></button> -->
		<br>
		<br>
	<table border = "2" style = " float: left;">
	<th>Id</th> <th> Nombre </th> <th> Precio </th><th> Estado </th>  <th>Editar</th> <th>Eliminar</th> <th>Cancelar</th>
		<% for(Evento ele: lista){ %>
		
	<tr>
	<td><%= ele.getIdEvento() %></td>
	<td><%= ele.getNombre() %></td>
	<td><%= ele.getPrecioDec()%></td>
	<td><%= ele.getEstado()%></td>
	<td><a href ="eventos?opcion=editar&id=<%=ele.getIdEvento()%>">Editar </a></td>
	<td><a href ="eventos?opcion=eliminar&id=<%=ele.getIdEvento()%>">Eliminar</a></td>
	<td><a href ="eventos?opcion=cancelar&id=<%=ele.getIdEvento()%>">Cancelar</a></td>
	</tr>
	<%} %>
	</table>
	
	<%Evento ev = new Evento();
	ev.setIdTipo(new Tipo());
	if(request.getAttribute("editEvento")!=null){
		ev = (Evento) request.getAttribute("editEvento");}
	 %>
	<ol style=" float: left">
 	<li><p>Nombre del evento: <%= ev.getNombre() %></p></li>
	<li><p>Descripción: <%= ev.getDescripcion() %> </p></li>
	<li><p>Duración: <%=ev.getDuracion()%> </p></li>
	<li><p>Dirección: <%=ev.getDireccion() %></p></li>
	<li><p>Aforo máximo: <%=ev.getAforoMax()%> </p></li>
	<li><p>Asistentes mínimos: <%=ev.getAsistMin()%> </p></li>
	<li><p>Precio: <%=ev.getPrecioDec() %></p></li>
	<li><p>Tipo: <%= ev.getIdTipo().getNombre() %></p></li>
</ol>

</body>
</html>