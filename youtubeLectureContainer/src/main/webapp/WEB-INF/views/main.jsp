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
<link href="/ylc/resources/css/main.css"" rel="stylesheet" type="text/css">

</head>
<body> 
<h1 align="center">	YOUTUBE LECTURE CONTAINER </h1><br/>
<h1 align="center">	https://joypinkgom.tistory.com/27?category=874360</h1><br/>
<h1 align="center">	https://gdtbgl93.tistory.com/73</h1><br/>
<!--
	관리 탭 : https://console.cloud.google.com/apis/credentials?project=youtubelecturecontainer
	라이브러리 도큐먼트 : https://developers.google.com/api-client-library/java/google-api-java-client/oauth2
	Google OAuto 관련 : https://gdtbgl93.tistory.com/73
-->
<table>
	<tr>
		<td>
			LIST
		</td>
		<td>
			STREAM
		</td>
	</tr>
	<tr>
		<td>
		TESTAPI
		</td>
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
	<tr>
		<td>
			MY LIST 
		</td>
		<td>
			<img src="/ylc/resources/css/java.png">
		</td>
	</tr>
</table>
</body>
</html>	