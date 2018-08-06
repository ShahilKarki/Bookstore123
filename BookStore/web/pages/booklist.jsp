<%@ page import="domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: stha
  Date: 4/2/18
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookList</title>
</head>
<body>
<%
    Book book = (Book) request.getAttribute("booklist");
%>

<%= book.getAuthor()%>
<%= book.getId()%>
<%= book.getName()%>
<%= book.getCategory()%>

</body>
</html>
