package przykłady.Bantumi;

import java.util.Random;
import java.util.Scanner;

/**
 * Class <code>Player</code> has methods to serve Players Objects,
 * which are necessary to use Play class.
 */

public class Player {

    String name;
    int points = 0;
    static int counter = 0;
    int id;
    int firstMove;

    public Player() {
        counter++;
        id = counter;
        helloPlayer();
    }

    void helloPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello Player " + id + ". " + "What is your name? ");
        name = scanner.nextLine();
    }

    void showName() {
        System.out.print(this.name);
    }

    static int whoFirst(Player player1, Player player2) {
        int firstMove;
        Random random = new Random();
        firstMove = random.nextInt(2);

        if (firstMove == 0) {
            player1.showName();
            System.out.println(" has first move.");
            firstMove = 0;
            player1.firstMove = 0;
            player2.firstMove = 1;
            return firstMove;

        } else {
            player2.showName();
            System.out.println(" has first move.");
            firstMove = 0;
            player1.firstMove = 1;
            player2.firstMove = 0;
            return firstMove;

        }
    }

    void win(String[] myStringTable, Player player) {

        Table.showTable(myStringTable);
        System.out.println("Congratulations " + player.name + "! You won!");
        System.exit(0);

    }

    void draw(String[] myStringTable) {

        Table.showTable(myStringTable);
        System.out.println("Nice! That was tough game. But there is draw.");
        System.exit(0);

    }

    static int changeFirstMove(int firstMove) {

        if (firstMove == 0) {
            firstMove = 1;
        } else {
            firstMove = 0;
        }
        return firstMove;

    }
}