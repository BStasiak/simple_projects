package przykłady.OiX;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class <code>Board</code> has methods to play in game O and X.
 *
 * @author Bartłomiej Stasiak
 * @version 1.0.0.0 11/07/2019
 */

public class Board {

    public static void main(String[] args) {

        String[] board = new String[17];

        board[0] = "\t7";
        board[1] = "\t|";
        board[2] = "\t8";
        board[3] = "\t|";
        board[4] = "\t9";
        board[5] = "  ---------------------";
        board[6] = "\t4";
        board[7] = "\t|";
        board[8] = "\t5";
        board[9] = "\t|";
        board[10] = "\t6";
        board[11] = "  ---------------------";
        board[12] = "\t1";
        board[13] = "\t|";
        board[14] = "\t2";
        board[15] = "\t|";
        board[16] = "\t3";

        HashSet<Integer> madeSigns = new HashSet<Integer>();

        typeOfGame(board, madeSigns);

    }

    static void typeOfGame(String[] board, HashSet<Integer> madeSigns) {
        Scanner scanner = new Scanner(System.in);
        int typeOfGame = 12;
        System.out.println("Witaj w grze w O i X.");

        do {
            System.out.println("Wybierz rodzaj gry:");
            System.out.println("1. z innym graczem.");
            System.out.println("2. z komputerem.");
            try {
                typeOfGame = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("No dalej, 1 lub 2.");
            }
        } while (typeOfGame != 1 && typeOfGame != 2);

        if (typeOfGame == 1) {
            withHumanDraw(board, madeSigns);
        } else {
            withComputerDraw(board, madeSigns);
        }
    }

    static void withComputerDraw(String[] board, HashSet<Integer> madeSigns) {
        int coin;

        Random random = new Random();
        coin = random.nextInt(2);
        if (coin == 0) {
            System.out.println("Ty zaczynasz.");
            withComputerHumanTurn(board, madeSigns, coin);
        } else {
            System.out.println("Zaczyna Komputer.");
            withComputerComputerTurn(coin, board, madeSigns);
        }
    }

    static void withComputerHumanTurn(String[] board, HashSet<Integer> madeSigns, int marker) {

        int field = 56;
        int occupiedFieldMarker;
        Scanner scanner = new Scanner(System.in);

        do {
            showBoard(board);
            System.out.println();
            System.out.println("Podaj numer pola:");

            try {
                field = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Komputer jest bardzo wyrozumiały i może przymknąć na to oko...");
            }

            System.out.println();
            field = checkfield(field, scanner, board);
            occupiedFieldMarker = madeSigns(field, madeSigns);
        } while (occupiedFieldMarker == 1);
        withComputerChangeField(field, marker, board, madeSigns);
    }

    static void withComputerChangeField(int field, int marker, String[] board, HashSet<Integer> madeSigns) {

        if (field == 7 && marker == 0) {
            board[0] = "\tO";
        }
        if (field == 7 && marker == 1) {
            board[0] = "\tX";
        }
        if (field == 8 && marker == 0) {
            board[2] = "\tO";
        }
        if (field == 8 && marker == 1) {
            board[2] = "\tX";
        }
        if (field == 9 && marker == 0) {
            board[4] = "\tO";
        }
        if (field == 9 && marker == 1) {
            board[4] = "\tX";
        }
        if (field == 4 && marker == 0) {
            board[6] = "\tO";
        }
        if (field == 4 && marker == 1) {
            board[6] = "\tX";
        }
        if (field == 5 && marker == 0) {
            board[8] = "\tO";
        }
        if (field == 5 && marker == 1) {
            board[8] = "\tX";
        }
        if (field == 6 && marker == 0) {
            board[10] = "\tO";
        }
        if (field == 6 && marker == 1) {
            board[10] = "\tX";
        }
        if (field == 1 && marker == 0) {
            board[12] = "\tO";
        }
        if (field == 1 && marker == 1) {
            board[12] = "\tX";
        }
        if (field == 2 && marker == 0) {
            board[14] = "\tO";
        }
        if (field == 2 && marker == 1) {
            board[14] = "\tX";
        }
        if (field == 3 && marker == 0) {
            board[16] = "\tO";
        }
        if (field == 3 && marker == 1) {
            board[16] = "\tX";
        }

        checkWin(board, marker, madeSigns);

        if (marker == 0) {
            marker = 1;

        } else {
            marker = 0;
        }

        if (marker == 0) {
            withComputerHumanTurn(board, madeSigns, marker);
        } else {
            withComputerComputerTurn(marker, board, madeSigns);
        }
    }

    static void withComputerComputerTurn(int marker, String[] board, HashSet<Integer> madeSigns) {

        int computerField;
        int occupiedFieldMarker;

        Random random = new Random();

        do {

            if (board[0].equals(board[2]) && board[4].equals("\t9")) {
                computerField = 9;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[0].equals(board[4]) && board[2].equals("\t8")) {
                computerField = 8;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[2].equals(board[4]) && board[0].equals("\t7")) {
                computerField = 7;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[6].equals(board[8]) && board[10].equals("\t6")) {
                computerField = 6;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[6].equals(board[10]) && board[8].equals("\t5")) {
                computerField = 5;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[8].equals(board[10]) && board[6].equals("\t4")) {
                computerField = 4;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[12].equals(board[14]) && board[16].equals("\t3")) {
                computerField = 3;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[12].equals(board[16]) && board[14].equals("\t2")) {
                computerField = 2;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[14].equals(board[16]) && board[12].equals("\t1")) {
                computerField = 1;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[0].equals(board[6]) && board[12].equals("\t1")) {
                computerField = 1;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[0].equals(board[12]) && board[6].equals("\t4")) {
                computerField = 4;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[6].equals(board[12]) && board[0].equals("\t7")) {
                computerField = 7;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[2].equals(board[8]) && board[14].equals("\t2")) {
                computerField = 2;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[2].equals(board[14]) && board[8].equals("\t5")) {
                computerField = 5;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[8].equals(board[14]) && board[2].equals("\t8")) {
                computerField = 8;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[4].equals(board[10]) && board[16].equals("\t3")) {
                computerField = 3;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[4].equals(board[16]) && board[10].equals("\t6")) {
                computerField = 6;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[10].equals(board[16]) && board[4].equals("\t9")) {
                computerField = 9;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[0].equals(board[8]) && board[16].equals("\t3")) {
                computerField = 3;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[0].equals(board[16]) && board[8].equals("\t5")) {
                computerField = 5;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[8].equals(board[16]) && board[0].equals("\t7")) {
                computerField = 7;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[4].equals(board[8]) && board[12].equals("\t1")) {
                computerField = 1;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[4].equals(board[12]) && board[8].equals("\t5")) {
                computerField = 5;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else if (board[8].equals(board[12]) && board[4].equals("\t9")) {
                computerField = 9;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            } else {
                computerField = random.nextInt(9) + 1;
                occupiedFieldMarker = madeSigns(computerField, madeSigns);
            }
        } while (occupiedFieldMarker == 1);
        withComputerChangeField(computerField, marker, board, madeSigns);
    }

    static void showBoard(String[] board) {

        for (int i = 0; i <= 16; i++) {
            if (i == 4 || i == 5 || i == 10 || i == 11) {
                System.out.println(board[i]);
            } else {
                System.out.print(board[i]);
            }
        }
        System.out.println();
    }

    static void withHumanDraw(String[] board, HashSet<Integer> madeSigns) {

        Random coin = new Random();
        Scanner scanner = new Scanner(System.in);
        int marker;

        System.out.println("Ustalcie kto ma O, a kto X, wciśnijcie dowolny klawisz na klawiaturze i Enter.");
        try {
            int temp = scanner.nextInt();
        } catch (InputMismatchException e) {
        }
        int sideOfCoin = coin.nextInt(2);
        if (sideOfCoin == 0) {
            System.out.println("O zaczyna!");
            System.out.println();
            marker = 0;
            makeSign(marker, board, madeSigns);
        } else {
            System.out.println("X zaczyna!");
            System.out.println();
            marker = 1;
            makeSign(marker, board, madeSigns);
        }
    }

    static void makeSign(int marker, String[] board, HashSet<Integer> madeSigns) {
        int field = 56;
        int occupiedFieldMarker;
        Scanner scanner = new Scanner(System.in);

        do {
            if (marker == 0 ) {
                System.out.println("Ruch O");}
            else {
                System.out.println("Ruch X");}
            showBoard(board);
            System.out.println();
            System.out.println("Podaj numer pola:");
            try {
                field = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("W tej grze nie występują litery.");
            }
            System.out.println();
            field = checkfield(field, scanner, board);
            occupiedFieldMarker = madeSigns(field, madeSigns);
        } while (occupiedFieldMarker == 1);
        changeField(field, marker, board, madeSigns);
    }

    static int checkfield(int field, Scanner scanner, String[] board) {
        while ((field != 1) &&
                (field != 2) &&
                (field != 3) &&
                (field != 4) &&
                (field != 5) &&
                (field != 6) &&
                (field != 7) &&
                (field != 8) &&
                (field != 9)
        ) {
            System.out.println("Wybierz cyfrę od 1 do 9. Spróbuj jeszcze raz.");
            showBoard(board);
            System.out.println();
            System.out.println("Podaj numer pola:");
            try {
                field = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
        return field;
    }

    static int madeSigns(int field, HashSet<Integer> madeSigns) {
        int occupiedFieldMarker;
        int tempSet = madeSigns.size();
        madeSigns.add(field);
        if (tempSet < madeSigns.size()) {
            occupiedFieldMarker = 0;
        } else {
            occupiedFieldMarker = 1;
            System.out.println("Wybrane pole jest już zajęte. Spróbuj jeszcze raz.");
        }
        return occupiedFieldMarker;
    }

    static void changeField(int field, int marker, String[] board, HashSet<Integer> madeSigns) {

        if (field == 7 && marker == 0) {
            board[0] = "\tO";
        }
        if (field == 7 && marker == 1) {
            board[0] = "\tX";
        }
        if (field == 8 && marker == 0) {
            board[2] = "\tO";
        }
        if (field == 8 && marker == 1) {
            board[2] = "\tX";
        }
        if (field == 9 && marker == 0) {
            board[4] = "\tO";
        }
        if (field == 9 && marker == 1) {
            board[4] = "\tX";
        }
        if (field == 4 && marker == 0) {
            board[6] = "\tO";
        }
        if (field == 4 && marker == 1) {
            board[6] = "\tX";
        }
        if (field == 5 && marker == 0) {
            board[8] = "\tO";
        }
        if (field == 5 && marker == 1) {
            board[8] = "\tX";
        }
        if (field == 6 && marker == 0) {
            board[10] = "\tO";
        }
        if (field == 6 && marker == 1) {
            board[10] = "\tX";
        }
        if (field == 1 && marker == 0) {
            board[12] = "\tO";
        }
        if (field == 1 && marker == 1) {
            board[12] = "\tX";
        }
        if (field == 2 && marker == 0) {
            board[14] = "\tO";
        }
        if (field == 2 && marker == 1) {
            board[14] = "\tX";
        }
        if (field == 3 && marker == 0) {
            board[16] = "\tO";
        }
        if (field == 3 && marker == 1) {
            board[16] = "\tX";
        }

        checkWin(board, marker, madeSigns);

        if (marker == 0) {
            marker = 1;

        } else {
            marker = 0;
        }
        makeSign(marker, board, madeSigns);
    }

    static void checkWin(String[] board, int marker, HashSet<Integer> madeSigns) {

        if (((board[0].equals(board[2])) && (board[2].equals(board[4]))) ||
                ((board[6].equals(board[8])) && (board[8].equals(board[10]))) ||
                ((board[12].equals(board[14])) && (board[14].equals(board[16]))) ||
                ((board[0].equals(board[6])) && (board[6].equals(board[12]))) ||
                ((board[2].equals(board[8])) && (board[8].equals(board[14]))) ||
                ((board[4].equals(board[10])) && (board[10].equals(board[16]))) ||
                ((board[0].equals(board[8])) && (board[8].equals(board[16]))) ||
                ((board[4].equals(board[8])) && (board[8].equals(board[12])))) {

            if (marker == 0) {
                showBoard(board);
                System.out.println();
                System.out.println("Wygrywa O");
                System.exit(0);
            } else {
                showBoard(board);
                System.out.println();
                System.out.println("Wygrywa X!");
                System.exit(0);
            }
        }
        if (madeSigns.size() == 9) {
            showBoard(board);
            System.out.println();
            System.out.println("Remis!");
            System.exit(0);
        }
    }
}