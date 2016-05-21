package en.aramirez.core;

/*
 * Created by aramirez on 5/20/16.
 */
public abstract class Box {

    protected int id;
    protected int color;

    public int getId() {
        return id;
    }

    public abstract void print();
}
