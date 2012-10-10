/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dada
 */
public class ImportaPasi {
File fisier;
    public ImportaPasi() {
    }
    public ImportaPasi(File fisier) throws IOException{
        this.fisier=fisier;
    }
    PasiVector ImportaPasi() throws IOException{
        PasiVector vec=new PasiVector();
        int x,y,z;
        DataInputStream dis=null;
        String Rand=null;
        try {
            FileInputStream fis = new FileInputStream(fisier);
            BufferedInputStream bis=new BufferedInputStream(fis);
            dis=new DataInputStream(bis);

            while((Rand=dis.readLine()) != null){
                StringTokenizer st=new StringTokenizer(Rand);
                x=Integer.parseInt(st.nextToken());
                y=Integer.parseInt(st.nextToken());
                z=Integer.parseInt(st.nextToken());
                vec.add(new Coordonata(x, y, z));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportaPasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vec;
    }
    }
