package en.aramirez.core;

/*
 * Created by aramirez on 5/20/16.
 */
public abstract class Box {

    protected int id;
    protected int color;
    protected boolean full;

    public boolean isFull() {
        return full;
    }

    public int getId() {
        return id;
    }

    public abstract void print();

    public abstract boolean place();
}
