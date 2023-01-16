<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%@ include file = "menu.jsp" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list all</title>
</head>
<body>

<h2>List All Contacts</h2>
<table>
<tr> 
	<th> First Name</th>
	<th>Last Name </th>
	<th>Email </th>
	<th>Mobile </th>
	<th>Billing </th>
	
</tr>
 <c:forEach var = "contact" items= "${contacts}">
 <tr> 
	<td><a href = "contactInfo?id=${contact.id}"> ${contact.firstName}</a></td>
	<td>${contact.lastName}</td>
	<td>${contact.email} </td>
	<td>${contact.mobile} </td>
	<td><a href = "showGenerateBillPage?id=${contact.id}">create bill</a></td>
</tr>
      
      </c:forEach>




</table>
</body>
</html>