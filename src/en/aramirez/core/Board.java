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
            if (i % 10 == 9)
                System.out.println();
            else
                boxes[i].print();
        }
    }
}
