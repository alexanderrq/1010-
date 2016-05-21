package en.aramirez.core;

/*
 * Created by aramirez on 5/20/16.
 */
public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        //b.print();
        b.placeBlock(Block.SINGLE, 3, 3);
        b.placeBlock(Block.HORIZONTAL2, 3, 3);
        b.placeBlock(Block.HORIZONTAL2, 6, 6);
        b.placeBlock(Block.VERTICAL2, 3, 3);
        b.placeBlock(Block.VERTICAL2, 1, 1);
        b.placeBlock(Block.HORIZONTAL3, 3, 3);
        b.placeBlock(Block.HORIZONTAL3, 4, 2);
        b.placeBlock(Block.VERTICAL3, 3, 3);
        b.placeBlock(Block.VERTICAL3, 7, 5);
        b.placeBlock(Block.RIGHT_UP3, 2, 7);
        b.placeBlock(Block.LEFT_UP3, 0, 6);
        b.placeBlock(Block.RIGHT_DOWN3, 3, 4);
        b.placeBlock(Block.LEFT_DOWN3, 3, 1);
        b.placeBlock(Block.SQUARE4, 0, 2);
        b.placeBlock(Block.VERTICAL4, 2, 6);
        b.placeBlock(Block.HORIZONTAL4, 9, 6);
        b.placeBlock(Block.HORIZONTAL5, 9, 0);
        b.placeBlock(Block.VERTICAL5, 3, 8);
        //b.placeBlock(Block.SQUARE9, 6, 3);
        b.placeBlock(Block.RIGHT_DOWN5, 0, 9);
        b.placeBlock(Block.RIGHT_UP5, 2, 4);
        b.placeBlock(Block.LEFT_UP5, 8, 0);
        b.placeBlock(Block.LEFT_DOWN5, 5, 2);
        b.print();
    }
}
