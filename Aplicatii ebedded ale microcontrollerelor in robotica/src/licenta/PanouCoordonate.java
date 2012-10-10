/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Dada
 */
public class PanouCoordonate extends JPanel {

JLabel XLabel=new JLabel("X: ");
JLabel YLabel=new JLabel("Y: ");
JLabel ZLabel=new JLabel("Z: ");
JSpinner XSpinner=new JSpinner(new SpinnerNumberModel(0, 0, 180, 1));
JSpinner YSpinner=new JSpinner(new SpinnerNumberModel(0, 0, 180, 1));
JSpinner ZSpinner=new JSpinner(new SpinnerNumberModel(0, 0, 180, 1));
JButton SetButton=new JButton("Set");
JButton AdaugaPasButton=new JButton("Adauga pas");
DefaultListModel lm=new DefaultListModel();
JList PasiLista=new JList(lm);
ScrollPane PasiPanou=new ScrollPane();
JButton ResetButton=new JButton("Reset");
JButton MemoreazaButton=new JButton("Memoreaza");
JButton SimulareButton=new JButton("Simuleaza");
JButton StergePasButton=new JButton("Sterge pas");
JButton MutaPasSusButton=new JButton("Muta pas sus");
JButton MutaPasJosButton=new JButton("Muta pas jos");
JButton To0Button=new JButton("To 0");
JButton ExportaButton=new JButton("Exporta");
JButton ImportaButton=new JButton("Importa");
JButton ParcurgeButton=new JButton("Parcurge");
JButton PauzaButton=new JButton("Pauza");
JButton StopButton=new JButton("Stop");
JCheckBox LiveCheckBox=new JCheckBox("LIVE");
PasiVector Pasivector=new PasiVector();
JPanel PanouSpinner= new JPanel();
Selector selector=new Selector();
ImportaPasi imp;
ExportaPasi exp;
static short datum;
          static short Addr=0x378;
	     pPort lpt;

Coordonata c=new Coordonata(0, 0, 0);


    public PanouCoordonate() {
     //   lpt=new pPort();
        setLayout(null);
        setVisible(true);
        setName("Panou coordonate");
        setBackground(Color.BLUE);
        setBorder(BorderFactory.createRaisedBevelBorder());
        PasiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

        PanouSpinner.add(XLabel);
        PanouSpinner.add(XSpinner);
        
        PanouSpinner.add(YLabel);
        PanouSpinner.add(YSpinner);
        
        PanouSpinner.add(ZLabel);
        PanouSpinner.add(ZSpinner);
        add(PanouSpinner);
        PanouSpinner.setVisible(true);
        PanouSpinner.setBounds(10, 10, 230, 30);


        add(LiveCheckBox);
        LiveCheckBox.setBounds(260, 10, 60, 30);
        
        add(SetButton);
        SetButton.setBounds(30, 50, 60, 30);
        add(To0Button);
        To0Button.setBounds(110, 50, 60, 30);
        
        add(AdaugaPasButton);
        AdaugaPasButton.setBounds(30, 90, 120, 30);
        add(StergePasButton);
        StergePasButton.setBounds(30, 130, 120, 30);
        add(MutaPasJosButton);
        MutaPasJosButton.setBounds(30, 170, 120, 30);
        add(MutaPasSusButton);
        MutaPasSusButton.setBounds(30, 210, 120, 30);
        
        add(ExportaButton);
        ExportaButton.setBounds(30, 250, 120, 30);
        add(ImportaButton);
        ImportaButton.setBounds(170, 250, 100, 30);


        PasiPanou.add(PasiLista);
        add(PasiPanou);
        PasiPanou.setBounds(170, 90, 100, 150);

        add(SimulareButton);
        SimulareButton.setBounds(30, 290, 120, 30);
        add(MemoreazaButton);
        MemoreazaButton.setBounds(170, 290, 100, 30);
        
        add(ResetButton);
        ResetButton.setBounds(190, 50, 80, 30);
        add(ParcurgeButton);
        ParcurgeButton.setBounds(30, 330, 100, 30);
        add(PauzaButton);
        PauzaButton.setBounds(135, 330, 100, 30);
        add(StopButton);
        StopButton.setBounds(240, 330, 100, 30);
                
        XLabel.setVisible(true);
        YLabel.setVisible(true);
        ZLabel.setVisible(true);
        XSpinner.setVisible(true);
        YSpinner.setVisible(true);
        ZSpinner.setVisible(true);
        SetButton.setVisible(true);
        AdaugaPasButton.setVisible(true);
        PasiLista.setVisible(true);
        PasiPanou.setVisible(true);
        ResetButton.setVisible(true);
        MemoreazaButton.setVisible(true);
        SimulareButton.setVisible(true);
        StergePasButton.setVisible(true);
        MutaPasJosButton.setVisible(true);
        MutaPasSusButton.setVisible(true);
        LiveCheckBox.setVisible(true);
        To0Button.setVisible(true);
        ExportaButton.setVisible(true);
        ImportaButton.setVisible(true);
        ParcurgeButton.setVisible(true);
        PauzaButton.setVisible(true);
        StopButton.setVisible(true);

        
        XSpinner.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                        c.setX(Integer.parseInt(XSpinner.getValue().toString()));
               if(LiveCheckBox.isSelected()){
                   //do live
                   
               }
            }
        });

        YSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                   c.setY(Integer.parseInt(YSpinner.getValue().toString()));
               if(LiveCheckBox.isSelected()){
                   //do live
               }
            }
        });

        ZSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                   c.setZ(Integer.parseInt(ZSpinner.getValue().toString()));
               if(LiveCheckBox.isSelected()){
                   //do live
               }
            }
        });

        SetButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Set(c);
            }
        });
        
        To0Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               To0();
            }
        });
             
        AdaugaPasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdaugaPas(new Coordonata(c.getX(),c.getY(),c.getZ()));
            }
        });
     
        StergePasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(PasiLista.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Va rog selectati un element din lista", "Eroare stergere element", JOptionPane.ERROR_MESSAGE);
                }
                else{
                StergePas(PasiLista.getSelectedIndex());
                }
            }
        });

         MutaPasJosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(PasiLista.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Va rog selectati un element din lista", "Eroare mutare element", JOptionPane.ERROR_MESSAGE);
                }
                else{
                MutaJos(PasiLista.getSelectedIndex());
                }
            }
        });
        MutaPasSusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(PasiLista.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Va rog selectati un element din lista", "Eroare mutare element", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    MutaSus(PasiLista.getSelectedIndex());
                }
            }
        });

        ImportaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Importa();
                } catch (IOException ex) {
                    Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ExportaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Exporta();
                } catch (IOException ex) {
                    Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        SimulareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Simulare(Pasivector);
            }
        });

        MemoreazaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Memoreaza(Pasivector);
            }
        });


        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reset();
            }
        });

        ParcurgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Parcurge(Pasivector);
            }
        });

        PauzaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pauza();
            }
        });

        StopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Stop();
            }
        });

    }
    void IncarcaPasiLista(){
        lm.removeAllElements();
        for(int i=0;i<Pasivector.size();i++){
        lm.addElement("Pas ("+(i+1)+"): "+Pasivector.elementAt(i).ToString());
        }
    }
    void To0(){
        XSpinner.setValue(0);
        YSpinner.setValue(0);
        ZSpinner.setValue(0);
        c=new Coordonata(0, 0, 0);
    }

    void Reset(){
        To0();
        GolesteLista();
        GolesteVector();
        IncarcaPasiLista();
    }
    void GolesteLista(){
        PasiLista.removeAll();
    }
    void GolesteVector(){
        try {
            Pasivector.BackUP();
        } catch (IOException ex) {
            Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Pasivector.clear();
    }

    void StergePas(int index){
        try {
            Pasivector.BackUP();
        } catch (IOException ex) {
            Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(index>-1&&index<Pasivector.size()){
                Pasivector.removeElementAt(index);
                IncarcaPasiLista();
                if(index==0){
                PasiLista.setSelectedIndex(index);
                }
                else{
                    PasiLista.setSelectedIndex(index-1);
                }
        }
        else{
            JOptionPane.showMessageDialog(null, "Pasul cu indexul "+index+" nu exista.\nIntroduceti un index valid.", "Eroare valoare index", JOptionPane.ERROR_MESSAGE);
        }
    }

    void AdaugaPas(Coordonata coordonata){
        if(Pasivector.isEmpty()){
            try {
            Pasivector.BackUP();
        } catch (IOException ex) {
            Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
        }
                    Pasivector.add(coordonata);
                    IncarcaPasiLista();
                }
                else{
                    if(Pasivector.lastElement().EsteEgal(coordonata)){
                        JOptionPane.showMessageDialog(null, "Este inutila adaugarea succesiva a aceasi coordonata", "Eroare adaugare coordonata la lista", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        try {
            Pasivector.BackUP();
        } catch (IOException ex) {
            Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
        }
                        Pasivector.add(coordonata);
                        IncarcaPasiLista();
                    }
                }
    }
    void MutaJos(int index){
        if(index==Pasivector.size()-1){
           JOptionPane.showMessageDialog(null, "Pasul selectat este ultimul in lista.", "Eroare mutare pas", JOptionPane.ERROR_MESSAGE);
        }
        else{
        if(index>-1&&index<Pasivector.size()-1){
            try{
            Pasivector.BackUP();
        } catch (IOException ex) {
            Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
        }
                    Pasivector.MutaJos(index);
                    IncarcaPasiLista();
                    PasiLista.setSelectedIndex(index+1);
        }
        else{
            JOptionPane.showMessageDialog(null, "Pasul cu indexul "+index+" nu exista.\nIntroduceti un index valid.", "Eroare valoare index", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    void MutaSus(int index){
        if(index==0){
           JOptionPane.showMessageDialog(null, "Pasul selectat este primul in lista.", "Eroare mutare pas", JOptionPane.ERROR_MESSAGE);
        }
        else{
        if(index>0&&index<Pasivector.size()){
            try{
            Pasivector.BackUP();
        } catch (IOException ex) {
            Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
        }
                    Pasivector.MutaSus(index);
                    IncarcaPasiLista();
                    PasiLista.setSelectedIndex(index-1);
        }
        else{
            JOptionPane.showMessageDialog(null, "Pasul cu indexul "+index+" nu exista.\nIntroduceti un index valid.", "Eroare valoare index", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    void Importa() throws IOException{
        selector.Importa();
        if(selector.getFisier()!=null){
        imp=new ImportaPasi(selector.getFisier());
        try {
            Pasivector.BackUP();
        } catch (IOException ex) {
            Logger.getLogger(PanouCoordonate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Pasivector=imp.ImportaPasi();
        IncarcaPasiLista();
        }
    }
    void Exporta() throws IOException{
        if(!Pasivector.isEmpty()){
        selector.Exporta();
        exp=new ExportaPasi(selector.getFisier(), Pasivector);
        }
        else{
             JOptionPane.showMessageDialog(null, "Lista de pasi este goala", "Eroare importa", JOptionPane.ERROR_MESSAGE);

        }
    }
    void Set(Coordonata coord){
        Integer[] string=new Integer[3];
        CodificareSemnal cs=new CodificareSemnal();
        string=cs.getSemnal(coord);
        System.out.println(string[0]);
        datum=string[0].shortValue();
        do_write();


    }
    void Simulare(Vector<Coordonata> vectoriPasi){
    	SimulatorGrafic sim=new SimulatorGrafic(true,vectoriPasi);
    	
        //new MainFrame(new SimulatorGrafic(true,vectoriPasi), 950, 600);
    }
    void Memoreaza(Vector<Coordonata> vectoriPasi){
        //to lpt
    }
    void Parcurge(Vector<Coordonata> vectoriPasi){
        //to lpt
    }
    void Pauza(){
       //pauza parcurge
    }
    void Stop(){
        //stop parcurge
    }


     void do_read()
    {
          // Read from the port
          datum = (short) lpt.input(Addr);

          // Notify the console
          System.out.println("Read Port: " + Integer.toHexString(Addr) +
                              " = " +  Integer.toHexString(datum));
     }

      void do_write()
     {
          // Notify the console
          System.out.println("Write to Port: " + Integer.toHexString(Addr) +
                              " with data = " +  Integer.toHexString(datum));
          //Write to the port
          lpt.output(Addr,datum);
     }


      void do_read_range()
     {
          // Try to read 0x378..0x37F, LPT1:
          for (Addr=0x378; (Addr<0x380); Addr++) {

               //Read from the port
               datum = (short) lpt.input(Addr);

               // Notify the console
               System.out.println("Port: " + Integer.toHexString(Addr) +
                                   " = " +  Integer.toHexString(datum));
          }
     }
}
