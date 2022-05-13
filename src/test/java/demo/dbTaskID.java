package demo;
import java.sql.*;

public class dbTaskID {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String dbUrl = "https://zoom-adminer.stg.rivigo.com/?pgsql=zoom-pgsql-replica-stg";
        //Database Username
        String username = "general";

        //Database Password
        String password = "general";

        //Query to Execute
        String query = "select *  from task_metadata;";

        //Load mysql jdbc driver
        Class.forName("org.postgresql.Driver");
        System.out.println("Loaded ok.");
        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        System.out.println("DB Connected Successfuly");
        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){

            String myAge = rs.getString(2);
            System. out.println(myAge);
        }
        // closing DB Connection
        con.close();
    }

}
