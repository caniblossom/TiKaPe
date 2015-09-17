/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.tikape;

/**
 * @author Jani Salo
 */
public class Pyora {
    private String rekisterinro;
    private String merkki;
    
    public Pyora(String rekisterinro, String merkki) {
        this.rekisterinro = rekisterinro;
        this.merkki = merkki;
    }
    
    public String getRekisterinro() {
        return rekisterinro;
    }
    
    public void setRekisterinro(String rekisterinro) {
        this.rekisterinro = rekisterinro;
    }

    public String getMerkki() {
        return merkki;
    }
    
    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }
}
