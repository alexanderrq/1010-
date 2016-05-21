package en.aramirez.core;

/*
 * Created by aramirez on 5/21/16.
 */
public class Manager {
    private Board board;
    private Player player;

    public Manager() {
        board = new Board();
        player = new Player();
    }

    private void addBlocks() {
        for (int i = 0; i < 3; i++){
            player.blocks.add(i, Block.getRandom());
        }
    }

    private void deleteBlocks(int index) {
        player.blocks.remove(index);
    }

    private void checkColumn() {
        boolean cont = true;
        for (int column = 0; column < 10; column++) {
            for (int row = 0; row < 10; row++) {
                if (!(board.isFull(row, column))) {
                    cont = false;
                    break;
                }
            }
            if (cont)
                board.deleteColumn(column);
            cont = true;
        }
    }

    private void checkRow() {
        boolean cont = true;
        for (int row = 0; row < 10; row++){
            for (int column = 0; column < 10; column++){
                if (!(board.isFull(row, column))) {
                    cont = false;
                    break;
                }
            }
            if (cont)
                board.deleteRow(row);
            cont = true;
        }
    }

    public void sendBlock(int index, int row, int column) {
        if (board.placeBlock(player.blocks.get(index), row, column)) {
            player.blocks.remove(index);
            if (player.blocks.isEmpty())
                addBlocks();
            checkColumn();
            checkRow();
        }
        else System.out.println("No se pudo colocar la pieza");
    }

    public void print() {
        board.print();
        System.out.println(player.blocks);
    }
}
