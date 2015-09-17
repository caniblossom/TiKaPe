/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.tikape;

/**
 * @author Jani Salo
 */
public class Varaus {
    private String rekisterinro;
    private String varaaja;
    private String varausAlkaa;
    private String varausLoppuu;

    public Varaus(String rekisterinro, String varaaja, String varausAlkaa, String varausLoppuu) {
        this.rekisterinro = rekisterinro;
        this.varaaja = varaaja;
        this.varausAlkaa = varausAlkaa;
        this.varausLoppuu = varausLoppuu;
    }
    
    public String getRekisterintro() {
        return rekisterinro;
    }

    public void setRekisterintro(String rekisterintro) {
        this.rekisterinro = rekisterintro;
    }

    public String getVaraaja() {
        return varaaja;
    }

    public void setVaraaja(String varaaja) {
        this.varaaja = varaaja;
    }

    public String getVarausAlkaa() {
        return varausAlkaa;
    }

    public void setVarausAlkaa(String varausAlkaa) {
        this.varausAlkaa = varausAlkaa;
    }

    public String getVarausLoppuu() {
        return varausLoppuu;
    }

    public void setVarausLoppuu(String varausLoppuu) {
        this.varausLoppuu = varausLoppuu;
    }
}
