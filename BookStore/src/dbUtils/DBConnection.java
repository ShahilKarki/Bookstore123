package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection con = null;
    private  String DB_URL ="jdbc:mysql://localhost:3306/bookstore";
    private  String DB_USER ="root";
    private  String DB_PASSWORD ="";

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();

            if(dbConnection.getConnection()!=null){
                System.out.println("Connection Established");
            }
            else{
                System.out.println("Opps!!! Some Error Occurred!!! \n");
            }

    }
}
