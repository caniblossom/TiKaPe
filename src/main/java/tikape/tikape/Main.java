/*
 * Foo bar.
 */
package tikape.tikape;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author Jani Salo
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Database db = new Database("org.sqlite.JDBC", "jdbc:sqlite:vuokraamo.db");
        
        // db.setDebugMode(true);
        // db.update("INSERT INTO Pyora (rekisterinumero, merkki) VALUES ('AKU-313', 'Belchfire Runabout')");
        
        Varauskeraaja varauskeraaja = new Varauskeraaja();
        List<Varaus> varausLista = db.queryAndCollect("SELECT pyora, etunimi AS varaaja, varaus_alkaa, varaus_loppuu FROM Varaus JOIN Varaaja ON varaaja = asiakasnumero", varauskeraaja);

        for (Varaus varaus : varausLista) {
            Timestamp alkaa = new Timestamp(Long.valueOf(varaus.getVarausAlkaa()));
            Timestamp loppuu = new Timestamp(Long.valueOf(varaus.getVarausLoppuu()));

            System.out.println(
                varaus.getRekisterintro() + "\t" + 
                varaus.getVaraaja() + "\t" + 
                alkaa + "\t" + 
                loppuu
            );
        }
    }
}
