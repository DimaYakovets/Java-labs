import java.sql.*;

public class DataBaseConnector {
    private Connection _connection;

    public DataBaseConnector() {
        try {
            Class.forName("org.h2.Driver").newInstance();
            _connection = DriverManager.getConnection("jdbc:h2:mem:test","sa", "");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void executeSQL(String query) {
        try {
            Statement st = _connection.createStatement();
            //st.execute(query);
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet executeSQLWithResult(String query) {
        try {
            Statement st = _connection.createStatement();
            return st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
