/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Dada
 */
public class PasiVectorRezerva extends Vector<Coordonata> {
ExportaPasi exportaPasi;
File fisier=new File("BACKUP.LPF");
    public PasiVectorRezerva() {
    }
    void export() throws IOException{
        exportaPasi = new ExportaPasi(fisier, this);
    }

}
