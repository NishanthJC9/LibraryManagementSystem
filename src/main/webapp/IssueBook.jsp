<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Issue Book</h1>
	<form action="issueBook">
		
		<label for="issueName">BookName</label>
		<input type="text" class="issueName" id="issueName" name="bookName"><br><br>
		<label for="issueAuthor">Author</label>
		<input type="text" class="issueAuthor" id="issueAuthor" name="author"><br><br>
		<input type="submit" value="Issue Book">
	</form>
</body>
</html>