package sqlconnect;

import java.sql.*;

/**
 * Creates a connection to an SQL database and returns a ResultSet on query.
 *
 * @author Josh Cotes
 */


public class DBconnection {

    private String _url;
    private String _userName;
    private String _password;
    private Connection _dbcon;

    public DBconnection(String url, int port, String database, String userName, String password){
        _url = "jdbc:mysql://" + url + ":" + port + "/" + database;
        _userName = userName;
        _password = password;
    }

    /**
     * Starts the connection with the SQL server.
     * @return - True on successful connection
     */
    public boolean startConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            _dbcon = DriverManager.getConnection(_url, _userName, _password);
            return true;
        }
        catch (SQLException sqlx$){
            sqlx$.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException csx$){
            csx$.printStackTrace();
            return false;
        }
    }

    /**
     * Executes a query to the SQL databse and returns the results as a ResultSet
     * @param query - The SQL query
     * @return - The query result
     */
    public ResultSet queryDatabase(String query) {
        try {
            Statement statement = _dbcon.createStatement();
            return statement.executeQuery(query);

        } catch (SQLException sqlx$) {
            sqlx$.printStackTrace();
            return null;
        }
    }
}
