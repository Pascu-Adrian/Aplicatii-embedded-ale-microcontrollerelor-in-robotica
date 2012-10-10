package licenta;

import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;


public class ManaRobot extends JPanel{
    Image image;
	   JTextField textfield;
    SimpleUniverse u;
    boolean isApplication;
    Canvas3D canvas;
    // These names correspond to the H-Anim names
    TransformGroup Corp;
    TransformGroup Brat;
    TransformGroup Antebrat;
    // these set up the transformations
    int BratROT = 0;
    AxisAngle4f BratAA = new AxisAngle4f(0.0f, 0.0f, -1.0f, 0.0f);
    int AntebratROT = 0;
    AxisAngle4f AntebratAA = new AxisAngle4f(0.0f, 0.0f, -1.0f, 0.0f);
    AxisAngle4f CorpAA = new AxisAngle4f(0.0f, -1.0f, 0.0f, 0.0f);
    // Temporaries that are reused
    Transform3D tmpTrans = new Transform3D();
    Vector3f tmpVector = new Vector3f();
    AxisAngle4f tmpAxisAngle = new AxisAngle4f();
    // These will be created, attached the scene graph and then the variable
    // will be reused to initialize other sections of the scene graph.
    Cylinder tmpCyl;
    Sphere tmpSphere;
    TransformGroup tmpTG;
    // colors for use in the cones
    Color3f Rosu = new Color3f(1.0f, 0.0f, 0.0f);
    Color3f Negru = new Color3f(0.0f, 0.0f, 0.0f);
    Color3f Alb = new Color3f(1.0f, 1.0f, 1.0f);
    // Returns the TransformGroup we will be editing to change the tranform
    // on the cone
    void createHuman(){
    Corp = new TransformGroup();
    Corp.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Corp.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    // center the body
    tmpVector.set(0.0f, -2.0f, 0.0f);
    tmpTrans.set(tmpVector);
    Corp.setTransform(tmpTrans);
    // Negru emmissive, Rosu diffuse and Alb specular coloring
    Material material = new Material(Rosu, Negru, Rosu, Alb, 100);
    Appearance appearance = new Appearance();
    appearance.setMaterial(material);
    // offset and place the cylinder for the body
    tmpTG = new TransformGroup();
    // offset the shape
    tmpVector.set(0.0f, 1.4f, 0.0f);
    tmpTrans.set(tmpVector);
    tmpTG.setTransform(tmpTrans);
    tmpCyl = new Cylinder(0.2f, 3.0f, appearance);
    tmpTG.addChild(tmpCyl);
    // add the shape to the body
    Corp.addChild(tmpTG);
    // create the r_shoulder TransformGroup
    Brat = new TransformGroup();
    Brat.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Brat.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    // translate from the waist
    tmpVector.set(0.0f, 2.9f, .0f);
    tmpTrans.set(tmpVector);
    Brat.setTransform(tmpTrans);
    // place the sphere for the r_shoulder
    tmpSphere = new Sphere(0.22f, appearance);
    Brat.addChild(tmpSphere);
    // offset and place the cylinder for the r_shoulder
    tmpTG = new TransformGroup();
    // offset the shape
    tmpVector.set(0.0f, -0.5f, 0.0f);
    tmpTrans.set(tmpVector);
    tmpTG.setTransform(tmpTrans);
    tmpCyl = new Cylinder(0.2f, 1.0f, appearance);
    tmpTG.addChild(tmpCyl);
    // add the shape to the r_shoulder
    Brat.addChild(tmpTG);
    // add the shoulder to the body group
    Corp.addChild(Brat);
    // create the r_elbow TransformGroup
    Antebrat = new TransformGroup();
    Antebrat.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    Antebrat.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tmpVector.set(0.0f, -1.054f, 0.0f);//poz cot
    tmpTrans.set(tmpVector);
    Antebrat.setTransform(tmpTrans);
    // place the sphere for the r_elbow
    tmpSphere = new Sphere(0.22f, appearance);
    Antebrat.addChild(tmpSphere);
    // offset and place the cylinder for the r_shoulder
    tmpTG = new TransformGroup();
    // offset the shape
    tmpVector.set(0.0f, -0.5f, 0.0f);
    tmpTrans.set(tmpVector);
    tmpTG.setTransform(tmpTrans);
    tmpCyl = new Cylinder(0.2f, 1.0f, appearance);
    tmpTG.addChild(tmpCyl);
    // add the shape to the r_shoulder
    Antebrat.addChild(tmpTG);
    // add the elbow to the shoulder group
    Brat.addChild(Antebrat);
    setBratROT(BratROT);
    setAntebratROT(AntebratROT);
    }

    public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();
    Object source = e.getSource();
    setBratROT(Integer.parseInt(textfield.getText()));
    setAntebratROT(Integer.parseInt(textfield.getText()));
    corprotate(Integer.parseInt(textfield.getText()));
    setBratROT(0);
    setAntebratROT(0);
    corprotate(0);
    textfield.setText(null);
    }
    public void setBratROT(int rotation) {
    BratROT = rotation+90;
    for(int i=90;i<=rotation+90;i++){
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

    public void setAntebratROT(int rotation) {
    float angle = (float) Math.toRadians(rotation);
    AntebratROT = rotation;
    for(int i=-90;i<=rotation-90;i++){
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

    public void corprotate(int rotation) {
    float angle = (float) Math.toRadians(rotation);

    for(int i=0;i<=rotation;i++){
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

    BranchGroup createSceneGraph() {
    // Create the root of the branch graph
    BranchGroup objRoot = new BranchGroup();

    // Create a TransformGroup to scale the scene down by 3.5x
    // TODO: move view platform instead of scene using orbit behavior
    TransformGroup objScale = new TransformGroup();
    Transform3D scaleTrans = new Transform3D();
    scaleTrans.set(1 / 3.5f); // scale down by 3.5x
    objScale.setTransform(scaleTrans);
    objRoot.addChild(objScale);

    // Create a TransformGroup and initialize it to the
    // identity. Enable the TRANSFORM_WRITE
    TransformGroup objTrans = new TransformGroup();
    objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    objScale.addChild(objTrans);

    // Add the primitives to the scene
    createHuman(); // the human
    objTrans.addChild(Corp);
    BoundingSphere bounds = new BoundingSphere(new Point3d(), 100.0);
    Background bg = new Background(Alb);
    bg.setApplicationBounds(bounds);
    objTrans.addChild(bg);

    // Set up the ambient light
    Color3f ambientColor = new Color3f(0.1f, 0.1f, 0.1f);
    AmbientLight ambientLightNode = new AmbientLight(ambientColor);
    ambientLightNode.setInfluencingBounds(bounds);
    objRoot.addChild(ambientLightNode);

    // Set up the directional lights
    Color3f light1Color = new Color3f(1.0f, 1.0f, 1.0f);
    Vector3f light1Direction = new Vector3f(0.0f, -0.2f, -1.0f);

    DirectionalLight light1 = new DirectionalLight(light1Color,
    light1Direction);
    light1.setInfluencingBounds(bounds);
    objRoot.addChild(light1);

    return objRoot;
    }

  public ManaRobot() {



  }

      

   // this(false);
  }

   /* public ManaRobot(boolean isApplication) {
    this.isApplication = isApplication;
    }

    @Override
    public void init() {
    // set up a NumFormat object to print out float with only 3 fraction
    // digits
    setLayout(new BorderLayout());
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    canvas = new Canvas3D(config);
    add("Center", canvas);
    u = new SimpleUniverse(canvas);
    // Create a simple scene and attach it to the virtual universe
    BranchGroup scene = createSceneGraph();
    // This will move the ViewPlatform back a bit so the
    // objects in the scene can be viewed.
    u.getViewingPlatform().setNominalViewingTransform();
    u.addBranchGraph(scene);
    add("East", guiPanel());

    }
    // create a panel with a tabbed pane holding each of the edit panels
    JPanel guiPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(0, 1));
    textfield=new JTextField();
    textfield.addActionListener(this);
    panel.add(textfield);
    textfield.setVisible(true);
    panel.add(new JLabel("Introdu coordonata"));
    return panel;
    }
    @Override
    public void destroy() {
    u.removeAllLocales();
    }
    public static void main(String[] args) {
    new MainFrame(new ManaRobot(true), 950, 600);
    }*/

