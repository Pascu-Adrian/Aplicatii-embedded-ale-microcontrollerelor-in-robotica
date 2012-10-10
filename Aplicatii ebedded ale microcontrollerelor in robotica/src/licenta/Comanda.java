/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.util.Vector;

/**
 *
 * @author Dada
 */
public class Comanda {
    int NumarVariabile;
    String DenumireValori;
    String NumeComanda;
    String AjutorComanda;
    String IdentificatorComanda;
    Vector<String> ListaMetode;

    public Comanda() {
    }

    public Comanda(int NumarVariabile,String DenumireValori,String NumeComanda, String AjutorComanda, String IdentificatorComanda, Vector<String> ListaMetode) {
        this.NumarVariabile = NumarVariabile;
        this.DenumireValori = DenumireValori;
        this.NumeComanda = NumeComanda;
        this.AjutorComanda = AjutorComanda;
        this.IdentificatorComanda = IdentificatorComanda;
        this.ListaMetode = ListaMetode;
    }

    public void setDenumireValori(String DenumireValori) {
        this.DenumireValori = DenumireValori;
    }

    public String getDenumireValori() {
        return DenumireValori;
    }

    public void setNumarVariabile(int NumarVariabile) {
        this.NumarVariabile = NumarVariabile;
    }

    public int getNumarVariabile() {
        return NumarVariabile;
    }



    public String getAjutorComanda() {
        return AjutorComanda;
    }

    public String getIdentificatorComanda() {
        return IdentificatorComanda;
    }

    public Vector<String> getListaMetode() {
        return ListaMetode;
    }



    public String getNumeComanda() {
        return NumeComanda;
    }

    public void setAjutorComanda(String AjutorComanda) {
        this.AjutorComanda = AjutorComanda;
    }

    public void setIdentificatorComanda(String IdentificatorComanda) {
        this.IdentificatorComanda = IdentificatorComanda;
    }

    public void setListaMetode(Vector<String> ListaMetode) {
        this.ListaMetode = ListaMetode;
    }

    public void setNumeComanda(String NumeComanda) {
        this.NumeComanda = NumeComanda;
    }

    public String ToString() {
        return "Comanda: "+this.getIdentificatorComanda()+" Nume: "+this.getNumeComanda()+" Informatii: "+this.getAjutorComanda()+" Necesita: "+this.getNumarVariabile()+" variabile pentru a functiona";
    }


}
