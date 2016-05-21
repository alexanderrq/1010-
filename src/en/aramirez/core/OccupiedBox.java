package en.aramirez.core;

/**
 * Created by aramirez on 5/20/16.
 */
public class OccupiedBox extends Box {

    public OccupiedBox(int id) {
        this.id = id;
        this.color = 1;
        this.full = true;
    }

    @Override
    public void print() {
        System.out.print("[*]");
    }

    public boolean place() {
        return false;
    }


}
