package licenta;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.util.Vector;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.swing.*;

public class SimulatorGrafic extends JFrame implements ActionListener {
	JScrollPane PasiPanou=new JScrollPane();
	JButton buton;
	Vector<Coordonata> listacoordonate=new Vector<Coordonata>();
	int CorpIndexCurent;
	int BratIndexCurent;
	int AntebratIndexCurent;
		DefaultListModel lm=new DefaultListModel();
	JList ListaPasi=new JList(lm);

  SimpleUniverse u;
  boolean isApplication;
  Canvas3D canvas;
  //Transformarile obiectelor
  TransformGroup Corp;
  TransformGroup Brat;
  TransformGroup Antebrat;
  TransformGroup Deget1;
  TransformGroup Deget2;
  TransformGroup Palma;
  int BratROT = 0;
  AxisAngle4f BratAA = new AxisAngle4f(0.0f, 0.0f, -1.0f, 0.0f);
  int AntebratROT = 0;
  AxisAngle4f AntebratAA = new AxisAngle4f(0.0f, 0.0f, -1.0f, 0.0f);
  AxisAngle4f CorpAA = new AxisAngle4f(0.0f, -1.0f, 0.0f, 0.0f);
  //Variabile temporare ce vor fi folosite
  Transform3D tmpTrans = new Transform3D();
  Vector3f tmpVector = new Vector3f();
  AxisAngle4f tmpAxisAngle = new AxisAngle4f();
  //obiectele aferente scenei
  Cylinder tmpCyl;
  Sphere tmpSphere;
  TransformGroup tmpTG;
  // culori
  Color3f Rosu = new Color3f(1.0f, 0.0f, 0.0f);
  Color3f Negru = new Color3f(0.0f, 0.0f, 0.0f);
  Color3f Alb = new Color3f(1.0f, 1.0f, 1.0f);
  void createHuman(){
    Corp = new TransformGroup();
	Corp.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Corp.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    // setarea centrului corpului
    tmpVector.set(0.0f, -2.0f, 0.0f);
    tmpTrans.set(tmpVector);
    Corp.setTransform(tmpTrans);
    // Negru emmissive, Rosu diffuse si Alb specular
    Material material = new Material(Rosu, Negru, Rosu, Alb, 100);
    Appearance appearance = new Appearance();
    appearance.setMaterial(material);
    // introducerea cilindrului in corp
    tmpTG = new TransformGroup();
    // deplasarea formei
    tmpVector.set(0.0f, 1.4f, 0.0f);
    tmpTrans.set(tmpVector);
    tmpTG.setTransform(tmpTrans);
    tmpCyl = new Cylinder(0.2f, 3.0f, appearance);
    tmpTG.addChild(tmpCyl);
    // adaugarea la crop
    Corp.addChild(tmpTG);
    // transformarile bratului
    Brat = new TransformGroup();
    Brat.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Brat.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    // translatie din incheietura
    tmpVector.set(0.0f, 2.9f, .0f);
    tmpTrans.set(tmpVector);
    Brat.setTransform(tmpTrans);
    // palasarea sferei de legatura la umar
    tmpSphere = new Sphere(0.22f, appearance);
    Brat.addChild(tmpSphere);
    //deplasarea si plasarea cilindrului pe umar
    tmpTG = new TransformGroup();
    // deplasarea
    tmpVector.set(0.0f, -0.5f, 0.0f);
    tmpTrans.set(tmpVector);
    tmpTG.setTransform(tmpTrans);
    tmpCyl = new Cylinder(0.2f, 1.0f, appearance);
    tmpTG.addChild(tmpCyl);
    //plasarea in brat
    Brat.addChild(tmpTG);
    // plasarea in corp
    Corp.addChild(Brat);
    // crearea antebratului
    Antebrat = new TransformGroup();
    Antebrat.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Antebrat.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tmpVector.set(0.0f, -1.054f, 0.0f);//poz cot
    tmpTrans.set(tmpVector);
    Antebrat.setTransform(tmpTrans);
    // creare cot
    tmpSphere = new Sphere(0.22f, appearance);
    Antebrat.addChild(tmpSphere);
    // deplasarea si plasarea cilindrului pe umar
    tmpTG = new TransformGroup();
    // deplasarea
    tmpVector.set(0.0f, -0.5f, 0.0f);
    tmpTrans.set(tmpVector);
    tmpTG.setTransform(tmpTrans);
    tmpCyl = new Cylinder(0.2f, 1.0f, appearance);
    tmpTG.addChild(tmpCyl);
    // plasarea
    Antebrat.addChild(tmpTG);

//alea noi
	Palma = new TransformGroup();
	Palma.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Palma.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tmpVector.set(0.0f, -0.95f, 0.0f);
    tmpTrans.set(tmpVector);
    Palma.setTransform(tmpTrans);
    tmpSphere = new Sphere(0.22f, appearance);
    Palma.addChild(tmpSphere);


	Deget1 = new TransformGroup();
	Deget1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Deget1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tmpVector.set(-0.1f, -0.2f, 0.0f);
    tmpTrans.set(tmpVector);
    Deget1.setTransform(tmpTrans);
    tmpCyl = new Cylinder(0.04f, 0.4f, appearance);
    Deget1.addChild(tmpCyl);
    Palma.addChild(Deget1);
    
    Deget2 = new TransformGroup();
	Deget2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Deget2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tmpVector.set(0.1f, -0.2f, 0.0f);
    tmpTrans.set(tmpVector);
     Deget2.setTransform(tmpTrans);
    tmpCyl = new Cylinder(0.04f, 0.4f, appearance);
    Deget2.addChild(tmpCyl);
    Palma.addChild(Deget2);
    



    // adaugarea la grup
    Antebrat.addChild(Palma);
    Brat.addChild(Antebrat);
	
    setBratROT(BratROT);
    setAntebratROT(AntebratROT);
    
    
    
  }

  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();
    Object source = e.getSource();
    if(e.getSource()==ListaPasi){
    }
    if(e.getSource()==buton){
    	parcurgevector();
    }
  }
  public void setBratROT(int rotation) {
  	if(rotation<BratIndexCurent){
  		for(int i=BratIndexCurent+90;i>=rotation+90;i--){
    BratAA.angle = (float) Math.toRadians(i);
    Brat.getTransform(tmpTrans);
    tmpTrans.setRotation(BratAA);
    Brat.setTransform(tmpTrans);
   try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {          
        }	
    }
  	}
  	if(rotation>BratIndexCurent){
  	
    BratROT = rotation+90;
    for(int i=BratIndexCurent+90;i<=rotation+90;i++){
    BratAA.angle = (float) Math.toRadians(i);
    Brat.getTransform(tmpTrans);
    tmpTrans.setRotation(BratAA);
    Brat.setTransform(tmpTrans);
   try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {          
        }	
    }
  	}
    BratIndexCurent=rotation;    
  }

  public void setAntebratROT(int rotation) {
  	
  	if(rotation<AntebratIndexCurent){
  		for(int i=AntebratIndexCurent-90;i>=rotation-90;i--){
    AntebratAA.angle = (float) Math.toRadians(i);
    Antebrat.getTransform(tmpTrans);
    tmpTrans.setRotation(AntebratAA);
    Antebrat.setTransform(tmpTrans);
   try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {          
        }	
    }
  	}
  	
  	
  	if(rotation>AntebratIndexCurent){
  	
    AntebratROT = rotation-90;
    for(int i=AntebratIndexCurent-90;i<=rotation-90;i++){
    AntebratAA.angle = (float) Math.toRadians(i);
    Antebrat.getTransform(tmpTrans);
    tmpTrans.setRotation(AntebratAA);
    Antebrat.setTransform(tmpTrans);
   try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {          
        }	
    }
  	}
    AntebratIndexCurent=rotation;    
  }

public void corprotate(int rotation) {
	if(rotation>CorpIndexCurent){
    float angle = (float) Math.toRadians(rotation);
    
    for(int i=CorpIndexCurent;i<=rotation;i++){
    CorpAA.angle = (float) Math.toRadians(i);
    Corp.getTransform(tmpTrans);
    tmpTrans.setRotation(CorpAA);
    Corp.setTransform(tmpTrans);
     try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {   
        }  
    }
	}
	if(rotation<CorpIndexCurent){
    float angle = (float) Math.toRadians(rotation);
    
    for(int i=CorpIndexCurent;i>=rotation;i--){
    CorpAA.angle = (float) Math.toRadians(i);
    Corp.getTransform(tmpTrans);
    tmpTrans.setRotation(CorpAA);
    Corp.setTransform(tmpTrans);
     try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {   
        }  
    }
	}
	CorpIndexCurent=rotation;
  }
  public void InchideDegete(){
  	float fn=0.1f;
  	for(int i=0;i<9;i++){
  	Deget1.getTransform(tmpTrans);
  	tmpVector.set(-fn, -0.2f, 0.0f);
    tmpTrans.set(tmpVector);
     Deget1.setTransform(tmpTrans);

     Deget2.getTransform(tmpTrans);
     tmpVector.set(fn, -0.2f, 0.0f);
    tmpTrans.set(tmpVector);
     Deget2.setTransform(tmpTrans);
     fn=fn-0.01f;
     try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {   
        } 
  	}
  }
  public void DeschideDegete(){
  	float fn=0.01f;
  	for(int i=0;i<9;i++){
  	Deget1.getTransform(tmpTrans);
  	tmpVector.set(-fn, -0.2f, 0.0f);
    tmpTrans.set(tmpVector);
     Deget1.setTransform(tmpTrans);

     Deget2.getTransform(tmpTrans);
     tmpVector.set(fn, -0.2f, 0.0f);
    tmpTrans.set(tmpVector);
     Deget2.setTransform(tmpTrans);
     fn=fn+0.01f;
     try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {   
        } 
  	}
  }

  BranchGroup createSceneGraph() {
    // crearea sceneGrapului
    BranchGroup objRoot = new BranchGroup();

    //Micsorarea scenei de 3.5x
    TransformGroup objScale = new TransformGroup();
    Transform3D scaleTrans = new Transform3D();
    scaleTrans.set(1 / 3.5f); 
    objScale.setTransform(scaleTrans);
    objRoot.addChild(objScale);

    //Crearea Grupurilor de Transformari si initializarea cu matricea
    //identitate si posibilitatea scrierii acesteia
    TransformGroup objTrans = new TransformGroup();
    objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    objScale.addChild(objTrans);

    // adaugarea primitivelor in scena
    createHuman(); 
    objTrans.addChild(Corp);
    BoundingSphere bounds = new BoundingSphere(new Point3d(), 100.0);
    Background bg = new Background(Alb);
    bg.setApplicationBounds(bounds);
    objTrans.addChild(bg);

    // lumina ambientala
    Color3f ambientColor = new Color3f(0.1f, 0.1f, 0.1f);
    AmbientLight ambientLightNode = new AmbientLight(ambientColor);
    ambientLightNode.setInfluencingBounds(bounds);
    objRoot.addChild(ambientLightNode);

    //directia luminii
    Color3f light1Color = new Color3f(1.0f, 1.0f, 1.0f);
    Vector3f light1Direction = new Vector3f(0.0f, -0.2f, -1.0f);

    DirectionalLight light1 = new DirectionalLight(light1Color,
        light1Direction);
    light1.setInfluencingBounds(bounds);
    objRoot.addChild(light1);
    
    

    return objRoot;
  }

  public SimulatorGrafic() {
  	//this.isApplication(false);
  	this(false,null);
  }

  public SimulatorGrafic(boolean isApplication,Vector<Coordonata> listacoordonate) {
    this.isApplication = isApplication;
    this.listacoordonate=listacoordonate;
    init();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(10,10,600,500);
  	setVisible(true);

    
  }

public void parcurgevector(){
	for(int i=0;i<listacoordonate.size();i++){
		ListaPasi.setSelectedIndex(i);
    	setBratROT(listacoordonate.elementAt(i).getX());
    	setAntebratROT(listacoordonate.elementAt(i).getY());
    	corprotate(listacoordonate.elementAt(i).getY());
    }
  
}
public void setPozitieInitiala(){
	setBratROT(0);
	setAntebratROT(0);
	corprotate(0);
}
    
  public  void init() {
    
    setLayout(new BorderLayout());
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    canvas = new Canvas3D(config);
    add("Center", canvas);
    u = new SimpleUniverse(canvas);
    // crearea unei scene simple si adaugarea acesteia in interfata
    setPozitieInitiala();
    BranchGroup scene = createSceneGraph();
    //deplasarea obiectelor in spate pentru vizionare
  	
    u.getViewingPlatform().setNominalViewingTransform();
   
    u.addBranchGraph(scene);
    
    add("East", guiPanel());
          IncarcaPasiLista();
    
  
  }
  
  JPanel guiPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3,1));
    ListaPasi=new JList();
    buton=new JButton("Start");
    panel.add(buton);
    buton.setVisible(true);
    buton.addActionListener(this);
//    ListaPasi.addActionListener(this);
PasiPanou.add(ListaPasi);  
PasiPanou.setViewportView(ListaPasi);
        panel.add(PasiPanou);
        PasiPanou.setVisible(true);
        ListaPasi.setVisible(true);
        ListaPasi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    panel.add(new JLabel("lista coordonate")); 
    return panel;
  }
    
    void IncarcaPasiLista(){
        lm.removeAllElements();
       // lm=new ListSelectionModel();
        for(int i=0;i<listacoordonate.size();i++){
        //	System.out.println("Pas ("+(i+1)+"): "+listacoordonate.elementAt(i).ToString());
        	//aici se incarca listModelu
        lm.addElement("Pas ("+(i+1)+"): "+listacoordonate.elementAt(i).ToString());
        
        }
    
        ListaPasi.setModel(lm);
    }
    
 /* public static void main(String[] args) {
  	Vector<Coordonata> d=new Vector<Coordonata>();
  	d.add(new Coordonata(40,70,15));
  	d.add(new Coordonata(75,30,100));
  	d.add(new Coordonata(0,0,0));
  	SimulatorGrafic sim=new SimulatorGrafic(true,d);*/
  	
    
    
  }
