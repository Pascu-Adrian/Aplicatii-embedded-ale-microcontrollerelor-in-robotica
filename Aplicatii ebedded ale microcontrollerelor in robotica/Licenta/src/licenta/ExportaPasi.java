/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Dada
 */
public class ExportaPasi {
BufferedWriter bw;
    public ExportaPasi() {
    }
    public ExportaPasi(File fisier, Vector<Coordonata> vectorcoordonate) throws IOException{
        if(fisier!=null){
        bw=new BufferedWriter(new FileWriter(fisier));
        for(int i=0;i<vectorcoordonate.size();i++){
            bw.write(vectorcoordonate.elementAt(i).ToString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        }
    }

}
