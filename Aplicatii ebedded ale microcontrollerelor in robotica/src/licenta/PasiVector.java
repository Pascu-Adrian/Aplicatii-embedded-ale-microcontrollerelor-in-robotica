/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Dada
 */
public class PasiVector extends Vector<Coordonata> {
Coordonata coordonataajutatoare;
Selector selector;
PasiVectorRezerva pvr=new PasiVectorRezerva();
    public PasiVector() {
    }

    void MutaSus(int index){
        coordonataajutatoare=elementAt(index);
        set(index, elementAt(index-1));
        set(index-1, coordonataajutatoare);
    }

    void MutaJos(int index){
        coordonataajutatoare=elementAt(index);
        set(index, elementAt(index+1));
        set(index+1, coordonataajutatoare);
    }
    void BackUP() throws IOException{
        if(!this.isEmpty()){
            for(int i=0;i<this.size();i++){
                pvr.add(this.elementAt(i));
            }
            pvr.export();
        }
    }
}
