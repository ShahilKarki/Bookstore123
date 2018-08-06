package controller;

import dbUtils.DBConnection;
import domain.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookController")
public class BookController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String action = request.getParameter("action");
//        System.out.println("action = " + action);
//            if(action == "addNew"){
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String category = request.getParameter("category");
                String isbn = request.getParameter("isbn");
                String price= request.getParameter("price");
                String purchased_date= "2018-04-12";

                //preparing connection
                String table_name = "book";
                Connection con = new DBConnection().getConnection();
                String query = "INSERT INTO "+table_name+" (name , author, category, isbn, price, purchased_date) VALUES ('"+name+"','"+author+"','"+category+"','"+isbn+"','"+price+"','"+purchased_date+"')";
                System.out.println("query = " + query);
                try {
                    Statement statement = con.createStatement();
                    if(statement.executeUpdate(query)!=0){
                        System.out.println(" Data Inserted succesfully");
                    }else{
                        System.out.println(" Oops !! Some error occurred!!! ");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
//                }

                response.sendRedirect("/book");

            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println("action = " + action);
        if(action == "add"){
            response.sendRedirect("/pages/addBook.jsp");
        }


        String table_name = "book"; //table name
        Connection con = new DBConnection().getConnection();
        String query = "SELECT * FROM "+ table_name; //query

        List<Book> bookList = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query); //execute query
            System.out.println("rs = " + rs);
            while (rs.next()){
                Book book = new Book(); //new book object

                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setIsbn(rs.getString("isbn"));
                book.setPrice(rs.getString("price"));
            bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //query execution end

        request.setAttribute("booklist", bookList);
        RequestDispatcher rd = request.getRequestDispatcher("/pages/book.jsp");
        rd.forward(request,response);







    }
}
