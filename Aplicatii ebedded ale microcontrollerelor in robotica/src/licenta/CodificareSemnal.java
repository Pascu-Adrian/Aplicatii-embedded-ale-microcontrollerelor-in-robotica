/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

/**
 *
 * @author Dada
 */
public class CodificareSemnal {
	
	public static Integer[] getSemnal(Coordonata c)
	{
				Integer[] codif=new Integer[3];
				codif[0]=c.getX()/3;
				codif[1]=c.getY()/3+60;
				codif[2]=c.getZ()/3+120;
				return codif;
	}

}
