<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List of Names</h1>
    <ul>
        <c:forEach var="name" items="${nameList}">
            <li>${name}</li>
        </c:forEach>
    </ul>
    
    <h1>Hello, World!</h1>
    <p>The current date and time is: 
        <%
            // Get the current date and time
            java.util.Date date = new java.util.Date();
            // Display the date and time
            out.println(date.toString());
        %>
    </p>

</body>
</html>