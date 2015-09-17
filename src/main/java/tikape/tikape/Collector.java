/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.tikape;

import java.sql.*;

/**
 * @author Jani Salo
 * @param <T> Type of items to collect.
 */
public interface Collector<T> {
    T collect(ResultSet rs) throws SQLException;
}
