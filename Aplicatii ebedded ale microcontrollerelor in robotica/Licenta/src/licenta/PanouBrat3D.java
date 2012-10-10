
package licenta;






import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dada
 */
public class PanouBrat3D extends JPanel{

    public PanouBrat3D() {
    setLayout(null);
        setVisible(true);
        setName("Panou Brat3D");
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createRaisedBevelBorder());
        Icon icon = new ImageIcon("brat.jpg");
    JLabel label1 = new JLabel(icon, JLabel.LEFT);
    add(label1);
    label1.setBounds(10, 10, 500, 500);
    label1.setVisible(true);
    }





}
