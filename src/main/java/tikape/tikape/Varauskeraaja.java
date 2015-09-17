/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.tikape;

import java.sql.*;

/**
 *
 * @author Jani Salo
 */
public class Varauskeraaja implements Collector<Varaus> {
    @Override
    public Varaus collect(ResultSet rs) throws SQLException {
        String rekisterinro = rs.getString("pyora");
        String varaaja = rs.getString("varaaja");
        String varausAlkaa = rs.getString("varaus_alkaa");
        String varausLoppuu = rs.getString("varaus_loppuu");
        return new Varaus(rekisterinro, varaaja, varausAlkaa, varausLoppuu);
    }
}
