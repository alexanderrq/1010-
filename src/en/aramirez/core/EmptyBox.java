package en.aramirez.core;

/**
 * Created by aramirez on 5/20/16.
 */
public class EmptyBox extends Box {

    public EmptyBox(int id) {
        this.id = id;
        this.color = 0;
        this.full = false;
    }

    @Override
    public void print(){
        System.out.print("[ ]");
    }

    @Override
    public boolean place() {
        return true;
    }
}
