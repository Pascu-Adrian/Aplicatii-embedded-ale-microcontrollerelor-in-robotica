/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package licenta;

/**
 *
 * @author Dada
 */
public class Coordonata {
    int x;
    int y;
    int z;

    public Coordonata() {
    }

    public Coordonata(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
    public String ToString(){
        return (this.x+" "+this.y+" "+this.z);
    }

    boolean EsteEgal(Coordonata c){
        if(this.getX()==c.getX()&&this.getY()==c.getY()&&this.getZ()==c.getZ()){
            return true;
        }
        else{
            return false;
        }
    }


}
