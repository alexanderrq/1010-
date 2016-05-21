package en.aramirez.core;

import java.util.LinkedList;

/*
 * Created by aramirez on 5/20/16.
 */
public class Player {

    public LinkedList<Block> blocks;

    public Player(){
        blocks = new LinkedList<Block>();
        for (int i = 0; i < 3; i++){
            blocks.add(Block.getRandom());
        }
    }
}
