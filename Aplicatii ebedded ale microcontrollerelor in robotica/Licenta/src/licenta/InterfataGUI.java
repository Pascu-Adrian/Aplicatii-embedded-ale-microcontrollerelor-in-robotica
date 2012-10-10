/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dada
 */
public class InterfataGUI extends JFrame {
    ComenziVector comenzivector;
    ImportaComenzi impcmd=new ImportaComenzi();
   PanouCoordonate panouCoordonate=new PanouCoordonate(); 
   JPanel PanouLucru=new JPanel();
Comanda cmd=new Comanda();
JTextArea ComenziTextArea=new JTextArea();
JTextField ComandaTextField=new JTextField();
ScrollPane PanouListaComenzi=new ScrollPane();
PanouBrat3D panouBrat3D=new PanouBrat3D();


    JTextField indexT=new JTextField();
    JTextField zt=new JTextField();
    JTextField xt=new JTextField();
    JTextField yt=new JTextField();
    Coordonata coordonata=null;
JInternalFrame dialog=new JInternalFrame("Va rog introduceti datele dorite", false, false, false, false);
JLabel x=new JLabel("X:");
    JLabel y=new JLabel("Y:");
    JLabel z=new JLabel("Z:");

    JButton OK=new JButton("OK");
    JButton CANCEL=new JButton("CANCEL");
    JLabel indexlable=new JLabel("Index:");



    public InterfataGUI() throws IOException{
   IncarcaComenzi();
   dialog.setSize(360, 140);
   add(dialog);
   indexT.setBounds(190, 20, 30, 30);
    dialog.add(x);
    dialog.add(y);
    dialog.add(z);
    dialog.add(xt);
    dialog.add(yt);
    dialog.add(zt);
    dialog.add(OK);
    dialog.add(CANCEL);
    dialog.add(indexlable);
    dialog.add(indexT);
    indexlable.setBounds(130, 20, 60, 30);
    CANCEL.setBounds(210, 90, 90, 30);
    CANCEL.setVisible(true);
    OK.setBounds(60, 90, 90, 30);
    OK.setVisible(true);
    z.setBounds(250, 20, 60, 30);
    xt.setBounds(80, 20, 30, 30);
    yt.setBounds(190, 20, 30, 30);
    zt.setBounds(310, 20, 30, 30);
    y.setBounds(130, 20, 60, 30);
    x.setBounds(20, 20, 60, 30);


//setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
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



        PanouListaComenzi.add(ComenziTextArea);
        add(PanouListaComenzi);
        add(ComandaTextField);
        
        ComenziTextArea.setVisible(true);
        //ComenziTextArea.setBounds(0, 0,300 ,300);
        PanouListaComenzi.setBounds(0, 370, 1500, 260);
        ComandaTextField.setBounds(0, 650, 1500, 40);
        ComandaTextField.setVisible(true);
PanouListaComenzi.setVisible(true);

        ComandaTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ComenziTextArea.setText(ComenziTextArea.getText()+"\n"+ComandaTextField.getText());
               int index= cautacomanda(ComandaTextField.getText());
               cmd=comanda(index);
                
               if(ComandaTextField.getText().equals("SET")){
                   
               }
               if(ComandaTextField.getText().equals("ADP")){
                   
               }
               if(ComandaTextField.getText().equals("STP")){
                   
               }
               if(ComandaTextField.getText().equals("MPS")){
                   
               }
               if(ComandaTextField.getText().equals("MPJ")){
                   
               }
               if(ComandaTextField.getText().equals("MEM")){
                   
               }
               if(ComandaTextField.getText().equals("SIM")){
                   
               }
               if(ComandaTextField.getText().equals("EXP")){
                    try {
                        panouCoordonate.Exporta();
                    } catch (IOException ex) {
                        Logger.getLogger(InterfataGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

               }
               if(ComandaTextField.getText().equals("IMP")){
                    try {
                        panouCoordonate.Importa();
                    } catch (IOException ex) {
                        Logger.getLogger(InterfataGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
               if(ComandaTextField.getText().equals("RST")){
                   panouCoordonate.Reset();
               }
               if(ComandaTextField.getText().equals("CLR")){
                   ComenziTextArea.setText(null);
               }
               if(ComandaTextField.getText().equals("PCG")){
                   
               }
               if(ComandaTextField.getText().equals("PZA")){
                   
               }
               if(ComandaTextField.getText().equals("STO")){
                   
               }
               if(ComandaTextField.getText().equals("EXT")){
                   dispose();
               }
               if(ComandaTextField.getText().equals("CMD")){
                   for(int i=0;i<comenzivector.size();i++){
                       ComenziTextArea.setText(ComenziTextArea.getText()+"\n"+comenzivector.elementAt(i).ToString());

    }
               }


                ComandaTextField.setText(null);
            }
        });



    }
    void IncarcaComenzi() throws IOException{
        comenzivector=impcmd.ImportaComenzi();
        System.out.println(comenzivector.lastElement().ToString());
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
