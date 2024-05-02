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
<h1>Add Book</h1>
	<form action="create">
	<label for="bookId">Book-ID</label>
	<input type="number" name="bookId" class="bookId" id="bookId"><br><br>
	
	<label for="bookName">Book-Name</label>
	<input type="text" name="bookName" class="bookName" id="bookName"><br><br>
	
	<label for="author">Author</label>
	<input type="text" name="author" class="author" id="author"><br><br>
	
	<input type="submit" value="Add Book">
	</form>
</body>
</html>