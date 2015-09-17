/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.tikape;

import java.sql.*;
import java.util.*;

/**
 * @author Jani Salo
 */
public class Database {
    private boolean debug;
    private Connection connection;
    
    public Database(String driver, String address) throws Exception {
        Class.forName(driver);
        this.connection = DriverManager.getConnection(address);
    }
    
    public void setDebugMode(boolean b) {
        debug = b;
    }
    
    public <T> List<T> queryAndCollect(String query, Collector<T> col, Object... params) throws SQLException {
        if (debug) {
            System.out.println("---");
            System.out.println("Executing: " + query);
            System.out.println("---");
        }
        
        PreparedStatement stmt = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
        
        ResultSet rs = stmt.executeQuery();
        List<T> rows = new ArrayList<>();

        while (rs.next()) {
            if (debug) {
                System.out.println("---");
                System.out.println(query);
                debug(rs);
                System.out.println("---");
            }
            
            rows.add(col.collect(rs));
        }
       
        rs.close();
        stmt.close();
        return rows;
    }
    
    private void debug(ResultSet rs) throws SQLException {
        int columns = rs.getMetaData().getColumnCount();
        for (int i = 0; i < columns; i++) {
            System.out.print(rs.getObject(i + 1) + ":" + rs.getMetaData().getColumnName(i + 1) + " ");
        }
        
        System.out.println("");
    }
    
    public int update(String updateQuery, Object... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(updateQuery);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
        
        int changes = stmt.executeUpdate();
        
        if (debug) {
            System.out.println("---");
            System.out.println(updateQuery);
            System.out.println("Changed rows: " + changes);
            System.out.println("---");
        }
        
        stmt.close();
        return changes;
    }
}
