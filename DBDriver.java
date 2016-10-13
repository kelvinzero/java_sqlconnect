import sqlconnect.DBconnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Josh Cotes on 10/11/2016.
 */
public class DBDriver {

    private static String _QUERY = "SELECT playerID FROM batting WHERE TeamID = 'CL1'";
    private static String _HOST = "localhost";
    private static int _PORT = 3306;
    private static String _DATABASE = "stats";
    private static String _UNAME = "root";
    private static String _UPASSWORD = "030881-jc";

    public static void main(String[] args){

        DBconnection dbcon = new DBconnection(_HOST, _PORT, _DATABASE, _UNAME, _UPASSWORD);
        boolean works = dbcon.startConnection();
        System.out.println("Works? : " + works);
        ResultSet rez = dbcon.queryDatabase(_QUERY);

        try {
            while (rez.next()) {
                System.out.println(rez.getString("playerID"));
            }
        }catch (SQLException sqlx$){
            sqlx$.printStackTrace();
        }
    }
}
