package com.store;
import java.sql.*;

public class DataBaseConnector {
    private Connection _connection;

    public DataBaseConnector() {
        try {
        	Class.forName("org.sqlite.JDBC");  
            _connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NImpha\\Desktop\\store.db");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }
   
    public void executeSQL(String query) {
        try {
            Statement st = _connection.createStatement();
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
    public PreparedStatement createPreparedStatement(String sql) throws SQLException {
        return _connection.prepareStatement(sql);
    }
}
