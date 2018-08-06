<%--
  Created by IntelliJ IDEA.
  User: stha
  Date: 4/9/18
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action ="/book?action=addNew" method="post">
    Book Name:<input type="text" name="name"><br>
    Author:<input type="text" name="author"><br>
    ISBN:<input type="text" name="isbn"><br>
    Category:<input type="text" name="category"><br>
    Price:<input type="text" name="price"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
