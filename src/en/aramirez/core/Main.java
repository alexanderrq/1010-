package en.aramirez.core;

import java.util.Scanner;

/*
 * Created by aramirez on 5/20/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Manager manager = new Manager();
        int op = 0, row, column;

        while (op != 9) {
            System.out.println();
            System.out.println();
            manager.print();
            System.out.print("Indique la pieza que desea colocar (0-2): ");
            op = input.nextInt();
            System.out.println();
            System.out.print("Indique la fila donde desea colocar la pieza (0-9):");
            row = input.nextInt();
            System.out.println();
            System.out.print("Indique donde desea colocar la pieza (0-9): ");
            column = input.nextInt();
            System.out.println();

            manager.sendBlock(op, row, column);


        }
    }
}
