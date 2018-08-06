<%@ page import="domain.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: stha
  Date: 4/2/18
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--include header--%>
<jsp:include page="/header.jsp"/>

<%--page content--%>
<div class="container">
    <div class="col-lg-6">
        <h2 class="sub-header">Users List</h2>
    </div>
    <div class="col-lg-6">
        <a href="<%=request.getContextPath()%>/pages/addBook.jsp" class="btn btn-success pull-right">Add New User</a>
    </div>
    <div class="table-responsive">
        <table class="table table-responsive table-bordered table-striped tab1 ">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Author</th>
                <th>ISBN</th>
                <th>Category</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Book> booklist = (List<Book>) request.getAttribute("booklist");
                if (booklist != null) {
                    int i = 1;
                    for (Book book : booklist) {
            %>
            <tr>

                <td><%=i++%>
                    <span><input type="hidden" value="<%= book.getId()%>"/></span>
                </td>
                <td><%=book.getName()%>
                </td>
                <td><%=book.getAuthor()%>
                </td>
                <td><%=book.getIsbn()%>
                </td>
                <td><%=book.getCategory()%>
                </td>
                <td><%=book.getPrice()%>
                </td>
                <td>
                    <a href="users?action=update&id=<%=book.getId()%>" class="btn btn-primary">Update</a>
                    <a href="users?action=delete&id=<%=book.getId()%>" class="btn btn-danger"
                       onclick="return confirm('Are you sure to delete : <%=book.getName()%>');">Delete</a>
                </td>

            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>

</div>
<%--page content end--%>
<%--include footer--%>
<jsp:include page="/footer.jsp"/>

