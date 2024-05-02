<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<jsp:include page="Library.jsp"/>

    <h2>User List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Book-ID</th>
                <th>Book-Name</th>
                <th>Author</th>
                <th>Availability</th>
                <th>No-of-Books<th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bookList" items="${bookList}">
                <tr>
                    <td>${bookList.bookId}</td>
                    <td>${bookList.bookName}</td>
                    <td>${bookList.author}</td>
                    <td>${bookList.available}</td>
                    <td>${bookList.noOfBooks}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>