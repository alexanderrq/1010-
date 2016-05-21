package en.aramirez.core;

/*
 * Created by aramirez on 5/13/16.
 */
public class Board {

    private Box[] boxes;
    private boolean[][] adjacencies;

    public Board() {
        boxes = new Box[100];
        adjacencies = new boolean[100][100];
        for (int i = 0; i < 100; i++){
            boxes[i] = new EmptyBox(i);
        }
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                if (((i % 10 == 0) && (j == i - 1)) || ((j % 10 == 0) && (i == j - 1)))
                    adjacencies[i][j] = false;
                else if (((i % 10 == 9) && (j == i + 1)) || ((j % 10 == 9) && (i == j + 1)))
                    adjacencies[i][j] = false;
                else if (((j == i - 1) || (j == i + 1) || (j == i + 10) || (j == i - 10))
                        || ((i == j - 1) || (i == j + 1) || (i == j + 10) || (i == j - 10)))
                    adjacencies[i][j] = true;
                else adjacencies[i][j] = false;
            }
        }
    }

    public void print() {
        for (int i = 0; i < 100; i++){
            if (i % 10 == 9){
                boxes[i].print();
                System.out.println();
            }
            else
                boxes[i].print();
        }
    }

    public boolean placeBlock(Block block, int row, int column) {
        int idAux = getId(row, column);
        if ((block == Block.SINGLE) && (boxes[idAux].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            return true;
        }
        else if ((block == Block.HORIZONTAL2) && (adjacencies[idAux][idAux + 1]) && (boxes[idAux].place())
                && (boxes[idAux + 1].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            return true;
        }
        else if ((block == Block.VERTICAL2) && (adjacencies[idAux][idAux + 10]) && (boxes[idAux].place())
                && (boxes[idAux + 10].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            return true;
        }
        else if ((block == Block.VERTICAL3) && (adjacencies[idAux][idAux + 10]) && (adjacencies[idAux + 10][idAux + 20])
                && (boxes[idAux].place()) && (boxes[idAux + 10].place()) && (boxes[idAux + 20].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            boxes[idAux + 20] = new OccupiedBox(idAux + 20);
            return true;
        }
        else if ((block == Block.HORIZONTAL3) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux + 1][idAux + 2])
                && (boxes[idAux].place()) && (boxes[idAux + 1].place()) && boxes[idAux + 2].place()) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux + 2] = new OccupiedBox(idAux + 2);
            return true;
        }
        else if ((block == Block.RIGHT_UP3) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux + 1][idAux - 9])
                && (boxes[idAux].place()) && (boxes[idAux + 1].place()) && (boxes[idAux - 9].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux - 9] = new OccupiedBox((idAux + 1 ) - 10);
            return true;
        }
        else if ((block == Block.LEFT_UP3) && (adjacencies[idAux][idAux + 10]) && (adjacencies[idAux + 10][idAux + 11])
                && (boxes[idAux].place()) && (boxes[idAux + 10].place()) && (boxes[idAux + 11].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            boxes[idAux + 11] = new OccupiedBox(idAux + 11);
            return true;
        }
        else if ((block == Block.RIGHT_DOWN3) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux + 1][idAux + 11])
                && (boxes[idAux].place()) && (boxes[idAux + 1].place()) && (boxes[idAux + 11].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux + 11] = new OccupiedBox(idAux + 11);
            return true;
        }
        else if ((block == Block.LEFT_DOWN3) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux][idAux + 10])
                && (boxes[idAux].place()) && (boxes[idAux + 10].place()) && (boxes[idAux + 1].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            return true;
        }
        else if ((block == Block.SQUARE4) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux][idAux + 10])
                && (adjacencies[idAux + 1][idAux + 11]) && (boxes[idAux].place()) && (boxes[idAux + 1].place())
                && (boxes[idAux + 10].place()) && (boxes[idAux + 11].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            boxes[idAux + 11] = new OccupiedBox(idAux + 11);
            return true;
        }
        else if ((block == Block.VERTICAL4) && (adjacencies[idAux][idAux + 10]) && (adjacencies[idAux + 10][idAux + 20])
                && (adjacencies[idAux + 20][idAux + 30]) && (boxes[idAux].place()) && (boxes[idAux + 10].place())
                && (boxes[idAux + 20].place()) && (boxes[idAux + 30].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            boxes[idAux + 20] = new OccupiedBox(idAux + 20);
            boxes[idAux + 30] = new OccupiedBox(idAux + 30);
            return true;
        }
        else if ((block == Block.HORIZONTAL4) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux + 1][idAux + 2])
                && (adjacencies[idAux + 2][idAux + 3]) && (boxes[idAux].place()) && (boxes[idAux + 1].place())
                && (boxes[idAux + 2].place()) && (boxes[idAux + 3].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux + 2] = new OccupiedBox(idAux + 2);
            boxes[idAux + 3] = new OccupiedBox(idAux + 3);
            return true;
        }
        else if ((block == Block.VERTICAL5) && (adjacencies[idAux][idAux + 10]) && (adjacencies[idAux + 10][idAux + 20])
                && (adjacencies[idAux + 20][idAux + 30]) && (adjacencies[idAux + 30][idAux + 40]) && (boxes[idAux].place())
                && (boxes[idAux + 10].place()) && (boxes[idAux + 20].place()) && (boxes[idAux + 30].place())
                && (boxes[idAux + 40].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            boxes[idAux + 20] = new OccupiedBox(idAux + 20);
            boxes[idAux + 30] = new OccupiedBox(idAux + 30);
            boxes[idAux + 40] = new OccupiedBox(idAux + 40);
            return true;
        }
        else if ((block == Block.HORIZONTAL5) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux + 1][idAux + 2])
                && (adjacencies[idAux + 2][idAux + 3]) && (adjacencies[idAux + 3][idAux + 4]) && (boxes[idAux].place())
                && (boxes[idAux + 1].place()) && (boxes[idAux + 2].place()) && (boxes[idAux + 3].place())
                && (boxes[idAux + 4].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux + 2] = new OccupiedBox(idAux + 2);
            boxes[idAux + 3] = new OccupiedBox(idAux + 3);
            boxes[idAux + 4] = new OccupiedBox(idAux + 4);
            return true;
        }
        else if ((block == Block.RIGHT_UP5) && (adjacencies[idAux][idAux - 1]) && (adjacencies[idAux - 1][idAux - 2])
                && (adjacencies[idAux][idAux - 10]) && (adjacencies[idAux - 10][idAux - 20]) && (boxes[idAux].place())
                && (boxes[idAux - 1].place()) && (boxes[idAux - 2].place()) && (boxes[idAux - 10].place())
                && (boxes[idAux - 20].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux - 1] = new OccupiedBox(idAux - 1);
            boxes[idAux - 2] = new OccupiedBox(idAux - 2);
            boxes[idAux - 10] = new OccupiedBox(idAux - 10);
            boxes[idAux - 20] = new OccupiedBox(idAux - 20);
            return true;
        }
        else if ((block == Block.LEFT_UP5) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux + 1][idAux + 2])
                && (adjacencies[idAux][idAux - 10]) && (adjacencies[idAux - 10][idAux - 20]) && (boxes[idAux].place())
                && (boxes[idAux + 1].place()) && (boxes[idAux + 2].place()) && (boxes[idAux - 10].place())
                && (boxes[idAux - 20].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux + 2] = new OccupiedBox(idAux + 2);
            boxes[idAux - 10] = new OccupiedBox(idAux - 10);
            boxes[idAux - 20] = new OccupiedBox(idAux - 20);
            return true;
        }
        else if ((block == Block.RIGHT_DOWN5) && (adjacencies[idAux][idAux - 1]) && (adjacencies[idAux - 1][idAux - 2])
                && (adjacencies[idAux][idAux + 10]) && (adjacencies[idAux + 10][idAux + 20]) && (boxes[idAux].place())
                && (boxes[idAux - 1].place()) && (boxes[idAux - 2].place()) && (boxes[idAux + 10].place())
                && (boxes[idAux + 20].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux - 1] = new OccupiedBox(idAux - 1);
            boxes[idAux - 2] = new OccupiedBox(idAux - 2);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            boxes[idAux + 20] = new OccupiedBox(idAux + 20);
            return true;
        }
        else if ((block == Block.LEFT_DOWN5) && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux + 1][idAux + 2])
                && (adjacencies[idAux][idAux + 10]) && (adjacencies[idAux + 10][idAux + 20]) && (boxes[idAux].place())
                && (boxes[idAux + 1].place()) && (boxes[idAux + 2].place()) && (boxes[idAux + 10].place())
                && (boxes[idAux + 20].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux + 2] = new OccupiedBox(idAux + 2);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            boxes[idAux + 20] = new OccupiedBox(idAux + 20);
            return true;
        }
        else if ((block == block.SQUARE9) && (adjacencies[idAux][idAux - 10]) && (adjacencies[idAux][idAux + 10])
                && (adjacencies[idAux][idAux + 1]) && (adjacencies[idAux][idAux - 1]) && (adjacencies[idAux - 1][idAux - 11])
                && (adjacencies[idAux + 1][idAux - 9]) && (adjacencies[idAux + 1][idAux + 11])
                && (adjacencies[idAux - 1][idAux + 9]) && (boxes[idAux].place()) && (boxes[idAux - 1].place())
                && (boxes[idAux + 1].place()) && (boxes[idAux - 10].place()) && (boxes[idAux + 10].place())
                && (boxes[idAux - 11].place()) && (boxes[idAux - 9].place()) && (boxes[idAux + 9].place())
                && (boxes[idAux + 11].place())) {
            boxes[idAux] = new OccupiedBox(idAux);
            boxes[idAux - 1] = new OccupiedBox(idAux - 1);
            boxes[idAux + 1] = new OccupiedBox(idAux + 1);
            boxes[idAux - 10] = new OccupiedBox(idAux - 10);
            boxes[idAux + 10] = new OccupiedBox(idAux + 10);
            boxes[idAux - 11] = new OccupiedBox(idAux - 11);
            boxes[idAux - 9] = new OccupiedBox(idAux - 9);
            boxes[idAux + 9] = new OccupiedBox(idAux + 9);
            boxes[idAux + 11] = new OccupiedBox(idAux + 11);
            return true;
        }
        else return false;
    }

    private int getId(int row, int column){
        return (10 * row + column);
    }
}
