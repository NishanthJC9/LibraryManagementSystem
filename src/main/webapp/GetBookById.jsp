<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Library.jsp"/>

	<h1>Get Book By Id</h1>
	<form action="getbyid">
	<label for="bookId">Enter Id for book</label>
	<input type="number" name="bookId" class="bookId" id="bookId"><br><br>
	
	<input type="submit" value="GetBook">
	</form>
</body>
</html>