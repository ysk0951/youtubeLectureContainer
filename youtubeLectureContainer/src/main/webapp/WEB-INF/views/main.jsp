<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="/resources/css/main.css"" rel="stylesheet" type="text/css">
</head>
<body> 
<h3 align="center">	YOUTUBE LECTURE CONTAINER </h1><br/>
<table>
	<tr> 
		<td>
		 <a href="${google_url}">
			 <button id="btnJoinGoogle" class="btn btn-primary btn-round" style="width: 100%; height: 30%">
              	<i class="fa fa-google" aria-hidden="true">
              		Google Login
              	</i>
             </button> 
          </a> 
		</td>
	</tr>
</table>
</body>
</html>	