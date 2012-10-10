/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dada
 */
public class Selector extends JFileChooser {
    File fisier=null;
    int ValoareSelectata;

    public Selector() {
        addChoosableFileFilter(new FileNameExtensionFilter("Fisiere Lista de Pasi(.LPF)", "LPF","lpf"));
        setAcceptAllFileFilterUsed(false);
    }
    public int getValoareSelectata() {
        return ValoareSelectata;
    }
    void Importa(){
        this.ValoareSelectata=this.showDialog(null, "Importa");
        if(ValoareSelectata==this.APPROVE_OPTION){
            fisier=this.getSelectedFile();
        }
    }
    void Exporta(){
        boolean OK=false;
        while(!OK){
        this.ValoareSelectata=this.showDialog(null, "Exporta");
        if(ValoareSelectata==this.APPROVE_OPTION){
            fisier=this.getSelectedFile();
            if(!fisier.getName().endsWith(".LPF")){
                    if(!fisier.getName().endsWith(".lpf")){
                    fisier=new File(fisier+".LPF");
                }
                }
            if(fisier.exists()){
                        int rezultat=JOptionPane.showConfirmDialog(null, "Fisierul "+fisier.getName()+" exista deja.\n Doriti sa il inlocuiti?", "Fisier deja existent", JOptionPane.YES_NO_CANCEL_OPTION);
                        if(rezultat==0){
                            OK=true;
                        }
                        if(rezultat==2){
                            OK=true;
                            fisier=null;
                        }
                    }
            else{
                OK=true;
            }
        }
        else{
            OK=true;
        }
    }
    }

    public File getFisier() {
        return fisier;
    }


}
