/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.io.IOException;

/**
 *
 * @author Dada
 */
public class GestiuneComenzi {
ImportaComenzi impcmd=new ImportaComenzi();
ComenziVector comenzivector=new ComenziVector();
    public GestiuneComenzi() {
    }
void IncarcaComenzi() throws IOException{
        comenzivector=impcmd.ImportaComenzi();
    }
Comanda comanda(int index){
    return comenzivector.elementAt(index);
}
int cautacomanda(String identificator){
    int index = 0;
    for(int i=0;i<comenzivector.size();i++){
        if(comenzivector.elementAt(i).IdentificatorComanda.equals(identificator)){
            index=i;
            break;
        }
    }
    return index;
}

}
