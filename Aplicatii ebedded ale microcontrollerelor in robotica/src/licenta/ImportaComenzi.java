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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dada
 */
public class ImportaComenzi {
File fisier=new File("comenzi.txt");

    public ImportaComenzi() {
    }

    ComenziVector ImportaComenzi() throws IOException{
        ComenziVector cmv=new ComenziVector();
        int NumarVariabile;
        String DenumireValori;
        String NumeComanda;
    String AjutorComanda;
    String IdentificatorComanda;
    Vector<String> ListaMetode;
        DataInputStream dis=null;
        String Rand=null;
        try {
            FileInputStream fis = new FileInputStream(fisier);
            BufferedInputStream bis=new BufferedInputStream(fis);
            dis=new DataInputStream(bis);
            while((Rand=dis.readLine()) != null){
                ListaMetode=new Vector<String>();
                StringTokenizer st=new StringTokenizer(Rand, ":");
                NumarVariabile=Integer.parseInt(st.nextToken());
                DenumireValori=st.nextToken();
                NumeComanda=st.nextToken();
                AjutorComanda=st.nextToken();
                IdentificatorComanda=st.nextToken();
                while(st.hasMoreTokens()){
                    ListaMetode.add(st.nextToken());
                }
                cmv.add(new Comanda(NumarVariabile,DenumireValori,NumeComanda, AjutorComanda, IdentificatorComanda, ListaMetode));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportaPasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cmv;
    }
    }
