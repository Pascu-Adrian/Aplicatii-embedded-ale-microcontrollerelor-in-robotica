/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Dada
 */
public class InterfataGUI extends JFrame {
    int[] variabile = null;
    Vector<String> ComenziUtilizate=new Vector<String>();
    int indexcomanda=-1;
    ComenziVector comenzivector;
    ImportaComenzi impcmd=new ImportaComenzi();
   PanouCoordonate panouCoordonate=new PanouCoordonate(); 
   JPanel PanouLucru=new JPanel();
Comanda cmd=new Comanda();


JTextArea ComenziTextArea=new JTextArea();
JTextField ComandaTextField=new JTextField();
JScrollPane PanouListaComenzi=new JScrollPane();
PanouBrat3D panouBrat3D=new PanouBrat3D();


    public InterfataGUI() throws IOException{
        IncarcaComenzi();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1500, 800);
        
        setLayout(null);
        add(PanouLucru);
        PanouLucru.setVisible(true);
        PanouLucru.add(panouBrat3D);
        panouBrat3D.setVisible(true);
        PanouLucru.add(panouCoordonate);
        PanouLucru.setLayout(null);
        panouBrat3D.setBounds(0, 0, 1000, 370);
        panouCoordonate.setBounds(1000, 0, 500, 370);
        PanouLucru.setBounds(0, 0, 1500, 370);

        PanouListaComenzi.getViewport().add(ComenziTextArea);
        add(PanouListaComenzi);
        add(ComandaTextField);
        
        ComenziTextArea.setVisible(true);
        ComenziTextArea.setEditable(false);
       
        PanouListaComenzi.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        PanouListaComenzi.setWheelScrollingEnabled(true);
        PanouListaComenzi.setBounds(0, 370, 1355, 260);
        ComandaTextField.setBounds(0, 650, 1355, 40);
        ComandaTextField.setVisible(true);
        PanouListaComenzi.setVisible(true);


        ComandaTextField.addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    if(!ComenziUtilizate.isEmpty()&&indexcomanda<ComenziUtilizate.size()){
                    indexcomanda++;
                    }
                    if(indexcomanda>-1&&indexcomanda<ComenziUtilizate.size()){
                        ComandaTextField.setText(ComenziUtilizate.elementAt(indexcomanda));

                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    if(!ComenziUtilizate.isEmpty()&&indexcomanda>0){
                    indexcomanda--;
                    }
                    if(indexcomanda>-1&&indexcomanda<ComenziUtilizate.size()){
                        ComandaTextField.setText(ComenziUtilizate.elementAt(indexcomanda));
                    }
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        ComandaTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ComenziUtilizate.add(ComandaTextField.getText());
                ComenziTextArea.append(ComandaTextField.getText()+"\n");
                String[] strcmd=ComandaTextField.getText().split("\\s");
                int index= cautacomanda(strcmd[0]);
                if(index!=-1){
               cmd=comanda(index);
               if(cmd.getNumarVariabile()!=strcmd.length-1){
                   JOptionPane.showMessageDialog(null, "Introduceti numarul corect de variabile!"+"\nNumarul de variabile pentru comanda: "+cmd.getIdentificatorComanda()+" este "+cmd.getNumarVariabile()+"\n"+cmd.getDenumireValori(), "Eroare numar variabile", JOptionPane.ERROR_MESSAGE);
               }
               else{
                variabile=new int[strcmd.length-1];
                for(int i=1;i<strcmd.length;i++){
                    if(!strcmd[i].isEmpty()){
                    variabile[i-1]=Integer.parseInt(strcmd[i]);
                    }
                }
              ExecutaComanda(cmd);
               }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Comanda "+strcmd[0]+" nu exista in lista de comenzi.\n Scrieti CMD pentru lista de comenzi existenta.", "Eroare comanda inexistenta", JOptionPane.ERROR_MESSAGE);
                }
               ComenziTextArea.setCaretPosition(ComenziTextArea.getDocument().getLength());
            }
        });



    }
    void IncarcaComenzi() throws IOException{
        comenzivector=impcmd.ImportaComenzi();
    }
Comanda comanda(int index){
    
    return comenzivector.elementAt(index);
}
int cautacomanda(String identificator){
    String[] rez=identificator.split("\\s");
    int index = -1;
    for(int i=0;i<comenzivector.size();i++){
        if(comenzivector.elementAt(i).IdentificatorComanda.startsWith(rez[0])){
            index=i;
            break;
        }
    }
    return index;
}


void ExecutaComanda(Comanda com){
    int indexvariabile=0;
    Vector<String> listametode=com.getListaMetode();
ComandaTextField.setText(null);

    for(int i=0;i<listametode.size();i++){
    if(listametode.elementAt(i).startsWith("SET")){
        int xc=variabile[indexvariabile];
        indexvariabile++;
        int yc=variabile[indexvariabile];
        indexvariabile++;
        int zc=variabile[indexvariabile];
        indexvariabile++;

        Coordonata coor=new Coordonata(xc, yc, zc);
      panouCoordonate.Set(coor);
    }
    if(listametode.elementAt(i).equals("TO0")){
        panouCoordonate.To0();
    }
    if(listametode.elementAt(i).equals("RST")){
        panouCoordonate.Reset();
    }
    if(listametode.elementAt(i).startsWith("ADP")){

        int xc=variabile[indexvariabile];
        indexvariabile++;
        int yc=variabile[indexvariabile];
        indexvariabile++;
        int zc=variabile[indexvariabile];
        indexvariabile++;

        Coordonata coor=new Coordonata(xc, yc, zc);

        panouCoordonate.AdaugaPas(coor);
    }
    if(listametode.elementAt(i).startsWith("STP")){
        int index=variabile[indexvariabile];
        indexvariabile++;

        panouCoordonate.StergePas(index);
    }
    if(listametode.elementAt(i).startsWith("MPS")){
        int index=variabile[indexvariabile];
        indexvariabile++;
         panouCoordonate.MutaSus(index-1);
    }
    if(listametode.elementAt(i).startsWith("MPJ")){
        int index=variabile[indexvariabile];
        indexvariabile++;
         panouCoordonate.MutaJos(index-1);
    }
    if(listametode.elementAt(i).equals("EXP")){
                try {
                    panouCoordonate.Exporta();
                } catch (IOException ex) {
                    Logger.getLogger(InterfataGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    if(listametode.elementAt(i).equals("IMP")){
                try {
                    panouCoordonate.Importa();
                } catch (IOException ex) {
                    Logger.getLogger(InterfataGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    if(listametode.elementAt(i).equals("SIM")){
        panouCoordonate.Simulare(panouCoordonate.Pasivector);
    }
    if(listametode.elementAt(i).equals("MEM")){
        panouCoordonate.Memoreaza(panouCoordonate.Pasivector);
    }
    if(listametode.elementAt(i).equals("PCG")){
        panouCoordonate.Parcurge(panouCoordonate.Pasivector);
    }
    if(listametode.elementAt(i).equals("STO")){
        panouCoordonate.Stop();
    }
    if(listametode.elementAt(i).equals("PZA")){
        panouCoordonate.Pauza();
    }
    if(listametode.elementAt(i).equals("CMD")){
        for(int k=0;k<comenzivector.size();k++){
            ComenziTextArea.append(comenzivector.elementAt(k).ToString()+"\n");
        }
    }
    if(listametode.elementAt(i).equals("EXT")){
        this.dispose();
    }
    }
variabile=null;
cmd=null;
}



}
