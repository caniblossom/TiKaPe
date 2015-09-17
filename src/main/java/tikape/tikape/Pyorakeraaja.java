/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.tikape;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jani Salo
 */
public class Pyorakeraaja implements Collector<Pyora> {
    @Override
    public Pyora collect(ResultSet rs) throws SQLException {
        String rekisterinro = rs.getString("rekisterinumero");
        String merkki = rs.getString("merkki");
        return new Pyora(rekisterinro, merkki);
    }
}
