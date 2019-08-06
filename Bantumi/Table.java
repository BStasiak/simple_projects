package przykłady.Bantumi;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class <code>Table</code> has methods to serve Table Object,
 * which is necessary to use Play class.
 */

public class Table {

    String[] newStringTable() {

        String[] stringBoard = new String[15];

        stringBoard[0] = "\t\t1 - 4\t\t|";
        stringBoard[1] = "\t\t2 - 4\t\t|";
        stringBoard[2] = "\t\t3 - 4\t\t|";
        stringBoard[3] = "\t\t4 - 4\t\t|";
        stringBoard[4] = "\t\t5 - 4\t\t|";
        stringBoard[5] = "|\t\t6 - 4\t\t|";
        stringBoard[6] = "Player 1\t\t";
        stringBoard[7] = "|\t\t7 - 4\t\t|";
        stringBoard[8] = "\t\t8 - 4\t\t|";
        stringBoard[9] = "\t\t9 - 4\t\t|";
        stringBoard[10] = "\t\t10 - 4\t\t|";
        stringBoard[11] = "\t\t11 - 4\t\t|";
        stringBoard[12] = "\t\t12 - 4\t\t|";
        stringBoard[13] = "\t\tPlayer 2";
        stringBoard[14] = "\t\t\t\t\t\t\t\t< < Player's turn < <\t\t\t\t\t\t\t\t";

        return stringBoard;
    }

    Integer[] newIntegerTable() {

        Integer[] IntegerBoard = new Integer[15];

        IntegerBoard[0] = 4;
        IntegerBoard[1] = 4;
        IntegerBoard[2] = 4;
        IntegerBoard[3] = 4;
        IntegerBoard[4] = 4;
        IntegerBoard[5] = 4;
        IntegerBoard[6] = 0;
        IntegerBoard[7] = 4;
        IntegerBoard[8] = 4;
        IntegerBoard[9] = 4;
        IntegerBoard[10] = 4;
        IntegerBoard[11] = 4;
        IntegerBoard[12] = 4;
        IntegerBoard[13] = 0;
        IntegerBoard[14] = 0;

        return IntegerBoard;

    }

    static void showTable(String[] board) {

        System.out.println();
        for (int i = 5; i >= 0; i--) {

            System.out.print(board[i]);
        }
        System.out.println();
        System.out.println();
        System.out.println(board[6] + board[14] + board[13]);
        System.out.println();

        for (int i = 7; i <= 12; i++) {
            System.out.print(board[i]);
        }

        System.out.println();
        System.out.println();
    }

    void changeName(String[] myStringTable, Player player) {

        if (player.firstMove == 0) {
            myStringTable[6] = player.name + " - 0";
        } else {
            myStringTable[13] = player.name + " - 0";
        }
    }

    void changeBanner(String[] myStringTable, int firstMove) {

        if (firstMove == 0) {
            myStringTable[14] = " \t\t\t\t\t\t\t\t< < Player's turn < <\t\t\t\t\t\t\t\t";
        } else {
            myStringTable[14] = " \t\t\t\t\t\t\t\t> > Player's turn > >\t\t\t\t\t\t\t\t";
        }
    }


    int chooseField(Scanner scanner) {
        int field = 56;
        boolean flag;

        do {
            flag = true;
            System.out.println("Choose number of field:");
            try {
                field = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Don't be so smart... ");
                scanner.nextLine();
                flag = false;
            }
        } while (!flag);

        return field;
    }

    int checkIfFieldIsCorrected(Scanner scanner, int field, int firstMove) {

        if (firstMove == 0) {
            while ((field != 1) &&
                    (field != 2) &&
                    (field != 3) &&
                    (field != 4) &&
                    (field != 5) &&
                    (field != 6)) {
                System.out.println("Choose one of your fields.");
                try {
                    field = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Don't be so smart... ");
                    scanner.nextLine();
                }
            }
        }

        if (firstMove == 1) {
            while ((field != 7) &&
                    (field != 8) &&
                    (field != 9) &&
                    (field != 10) &&
                    (field != 11) &&
                    (field != 12)) {
                System.out.println("Choose one of your fields.");
                try {
                    field = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Don't be so smart... ");
                    scanner.nextLine();
                }
            }
        }

        return field;
    }

    int convertToArraysIndex(int field) {

        int arraysIndex;

        if (field == 1) {
            arraysIndex = 0;
            return arraysIndex;
        }
        if (field == 2) {
            arraysIndex = 1;
            return arraysIndex;
        }
        if (field == 3) {
            arraysIndex = 2;
            return arraysIndex;
        }
        if (field == 4) {
            arraysIndex = 3;
            return arraysIndex;
        }
        if (field == 5) {
            arraysIndex = 4;
            return arraysIndex;
        }
        if (field == 6) {
            arraysIndex = 5;
            return arraysIndex;
        }
        if (field == 7) {
            arraysIndex = 7;
            return arraysIndex;
        }
        if (field == 8) {
            arraysIndex = 8;
            return arraysIndex;
        }
        if (field == 9) {
            arraysIndex = 9;
            return arraysIndex;
        }
        if (field == 10) {
            arraysIndex = 10;
            return arraysIndex;
        }
        if (field == 11) {
            arraysIndex = 11;
            return arraysIndex;
        }
        if (field == 12) {
            arraysIndex = 12;
            return arraysIndex;
        }

        return 15; // nie ma znaczenia bo wcześniej jest metoda checkIfFieldIsCorrected, która sprawdza czy wybrane pole jest jednym z powyższych.
    }

    int checkIfFieldIsNotEmpty(Integer[] myIntegerTable, int arraysIndex) {

        int emptyField;

        if (myIntegerTable[arraysIndex] == 0) {
            System.out.println("This field is empty, choose again.");
            emptyField = 1;
        } else {
            emptyField = 0;
        }
        return emptyField;
    }

    int changePlaceOfBeansonIntegerTable(Integer[] myIntegerTable, int arrayIndex, int firstMove) {

        int temp = myIntegerTable[arrayIndex];
        myIntegerTable[arrayIndex] = 0;              // zerowanie miejsca z którego są pobierane fasolki

        for (int i = 1; i <= temp; i++) {

            if ((firstMove == 0) && (i + arrayIndex > 59)) {
                if (((arrayIndex + i - 60) != 13) && ((arrayIndex + i - 60) != 14)) {
                    myIntegerTable[(arrayIndex + i) - 60] = myIntegerTable[(arrayIndex + i) - 60] + 1;
                } else {
                    temp = temp + 1;
                }

            } else if ((firstMove == 0) && (i + arrayIndex > 44)) {
                if (((arrayIndex + i - 45) != 13) && ((arrayIndex + i - 45) != 14)) {
                    myIntegerTable[(arrayIndex + i) - 45] = myIntegerTable[(arrayIndex + i) - 45] + 1;
                } else {
                    temp = temp + 1;
                }

            } else if ((firstMove == 0) && (i + arrayIndex > 29)) {
                if ((arrayIndex + i - 30 != 13) && (arrayIndex + i - 30 != 14)) {
                    myIntegerTable[(arrayIndex + i) - 30] = myIntegerTable[(arrayIndex + i) - 30] + 1;
                } else {
                    temp = temp + 1;
                }

            } else if ((firstMove == 0) && (i + arrayIndex > 14)) {
                if ((arrayIndex + i - 15 != 13) && (arrayIndex + i - 15 != 14)) {
                    myIntegerTable[(arrayIndex + i) - 15] = myIntegerTable[(arrayIndex + i) - 15] + 1;
                } else {
                    temp = temp + 1;
                }

            } else if (firstMove == 0) {
                if ((arrayIndex + i != 13) && (arrayIndex + i != 14)) {
                    myIntegerTable[arrayIndex + i] = myIntegerTable[arrayIndex + i] + 1;
                } else {
                    temp = temp + 1;
                }
            }

            if ((firstMove == 1) && (i + arrayIndex > 59)) {
                if (((arrayIndex + i - 60) != 6) && ((arrayIndex + i - 60) != 14)) {
                    myIntegerTable[(arrayIndex + i) - 60] = myIntegerTable[(arrayIndex + i) - 60] + 1;
                } else {
                    temp = temp + 1;
                }

            } else if ((firstMove == 1) && (i + arrayIndex > 44)) {
                if (((arrayIndex + i - 45) != 6) && ((arrayIndex + i - 45) != 14)) {
                    myIntegerTable[(arrayIndex + i) - 45] = myIntegerTable[(arrayIndex + i) - 45] + 1;
                } else {
                    temp = temp + 1;
                }

            } else if ((firstMove == 1) && (i + arrayIndex > 29)) {
                if ((arrayIndex + i - 30 != 6) && (arrayIndex + i - 30 != 14)) {
                    myIntegerTable[(arrayIndex + i) - 30] = myIntegerTable[(arrayIndex + i) - 30] + 1;
                } else {
                    temp = temp + 1;
                }

            } else if ((firstMove == 1) && (i + arrayIndex > 14)) {
                if ((arrayIndex + i - 15 != 6) && (arrayIndex + i - 15 != 14)) {
                    myIntegerTable[(arrayIndex + i) - 15] = myIntegerTable[(arrayIndex + i) - 15] + 1;
                } else {
                    temp = temp + 1;
                }

            } else if (firstMove == 1) {
                if ((arrayIndex + i != 6) && (arrayIndex + i != 14)) {
                    myIntegerTable[arrayIndex + i] = myIntegerTable[arrayIndex + i] + 1;
                } else {
                    temp = temp + 1;
                }
            }
        }
        return temp;
    }

    int markLastField(int temp, int arraysIndex) {

        int lastField = temp;
        lastField = lastField + arraysIndex;
        while (lastField >= 15) {
            lastField = lastField - 15;
        }
        return lastField;
    }

    void isLastFieldAtPlayersHome(Table table, String[] myStringTable, Integer[] myIntegerTable, Player player1, Player player2, int firstMove, int lastField) {

        String firstPlayer;
        String secondPlayer;
        if (player1.firstMove == 0) {
            firstPlayer = player1.name;
            secondPlayer = player2.name;
        } else {
            firstPlayer = player2.name;
            secondPlayer = player1.name;
        }


        if ((firstMove == 0) && (lastField == 6)) {
            System.out.println(firstPlayer + " has next round.");
            Play.doTurn(table, myStringTable, myIntegerTable, player1, player2, firstMove);

        }

        if ((firstMove == 1) && (lastField == 13)) {
            System.out.println(secondPlayer + " has next round.");
            Play.doTurn(table, myStringTable, myIntegerTable, player1, player2, firstMove);
        }

    }

    void isLastFieldAtOwnEmptyField(Integer[] myIntegerTable, int lastField, int firstMove, Player player1, Player player2) {

        if (firstMove == 0) {
            if ((myIntegerTable[lastField] == 1) && (lastField == 0)) {
                myIntegerTable[6] = myIntegerTable[6] + myIntegerTable[0] + myIntegerTable[12];
                myIntegerTable[0] = 0;
                myIntegerTable[12] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 1)) {
                myIntegerTable[6] = myIntegerTable[6] + myIntegerTable[1] + myIntegerTable[11];
                myIntegerTable[1] = 0;
                myIntegerTable[11] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 2)) {
                myIntegerTable[6] = myIntegerTable[6] + myIntegerTable[2] + myIntegerTable[10];
                myIntegerTable[2] = 0;
                myIntegerTable[10] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 3)) {
                myIntegerTable[6] = myIntegerTable[6] + myIntegerTable[3] + myIntegerTable[9];
                myIntegerTable[3] = 0;
                myIntegerTable[9] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 4)) {
                myIntegerTable[6] = myIntegerTable[6] + myIntegerTable[4] + myIntegerTable[8];
                myIntegerTable[4] = 0;
                myIntegerTable[8] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 5)) {
                myIntegerTable[6] = myIntegerTable[6] + myIntegerTable[5] + myIntegerTable[7];
                myIntegerTable[5] = 0;
                myIntegerTable[7] = 0;
            }
            player1.points = myIntegerTable[6];
        }

        if (firstMove == 1) {
            if ((myIntegerTable[lastField] == 1) && (lastField == 7)) {
                myIntegerTable[13] = myIntegerTable[13] + myIntegerTable[7] + myIntegerTable[5];
                myIntegerTable[7] = 0;
                myIntegerTable[5] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 8)) {
                myIntegerTable[13] = myIntegerTable[13] + myIntegerTable[8] + myIntegerTable[4];
                myIntegerTable[8] = 0;
                myIntegerTable[4] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 9)) {
                myIntegerTable[13] = myIntegerTable[13] + myIntegerTable[9] + myIntegerTable[3];
                myIntegerTable[9] = 0;
                myIntegerTable[3] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 10)) {
                myIntegerTable[13] = myIntegerTable[13] + myIntegerTable[10] + myIntegerTable[2];
                myIntegerTable[10] = 0;
                myIntegerTable[2] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 11)) {
                myIntegerTable[13] = myIntegerTable[13] + myIntegerTable[11] + myIntegerTable[1];
                myIntegerTable[11] = 0;
                myIntegerTable[1] = 0;
            } else if ((myIntegerTable[lastField] == 1) && (lastField == 12)) {
                myIntegerTable[13] = myIntegerTable[13] + myIntegerTable[12] + myIntegerTable[0];
                myIntegerTable[12] = 0;
                myIntegerTable[0] = 0;
            }
            player2.points = myIntegerTable[13];
        }
    }

    void checkIfWin(Integer[] myIntegerTable, String[] myStringTable, int firstMove, Player player1, Player player2) {

        if ((firstMove == 0) && (myIntegerTable[0] == 0) && (myIntegerTable[1] == 0) && (myIntegerTable[2] == 0) &&
                (myIntegerTable[3] == 0) && (myIntegerTable[4] == 0) && (myIntegerTable[5] == 0)) {
            myIntegerTable[13] = myIntegerTable[13] + myIntegerTable[7] + myIntegerTable[8] +
                    myIntegerTable[9] + myIntegerTable[10] + myIntegerTable[11] + myIntegerTable[12];
            givePoints(myIntegerTable, firstMove, player1, player2);

            if (player1.points > player2.points) {
                Table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);
                player1.win(myStringTable, player1);
            } else if (player2.points > player1.points) {
                Table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);
                player2.win(myStringTable, player2);
            } else {
                Table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);
                player1.draw(myStringTable);
            }
        }

        if ((firstMove == 1) && (myIntegerTable[7] == 0) && (myIntegerTable[8] == 0) && (myIntegerTable[9] == 0) &&
                (myIntegerTable[10] == 0) && (myIntegerTable[11] == 0) && (myIntegerTable[12] == 0)) {
            myIntegerTable[6] = myIntegerTable[6] + myIntegerTable[0] + myIntegerTable[1] +
                    myIntegerTable[2] + myIntegerTable[3] + myIntegerTable[4] + myIntegerTable[5];
            givePoints(myIntegerTable, firstMove, player1, player2);

            if (player1.points > player2.points) {
                Table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);
                player1.win(myStringTable, player1);
            } else if (player2.points > player1.points) {
                Table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);
                player2.win(myStringTable, player2);
            } else {
                Table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);
                player1.draw(myStringTable);
            }
        }

        if (player1.points > 25) {
            Table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);
            player1.win(myStringTable, player1);
        }
        if (player2.points > 25) {
            Table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);
            player2.win(myStringTable, player2);
        }
    }

    static void changePlaceOfBeansonStringTable(String[] myStringTable, Integer[] myIntegerTable, Player player1, Player
            player2) {
        String firstPlayer;
        String secondPlayer;
        if (player1.firstMove == 0) {
            firstPlayer = player1.name;
            secondPlayer = player2.name;
        } else {
            firstPlayer = player2.name;
            secondPlayer = player1.name;
        }

        for (int i = 0; i < myIntegerTable.length; i++) {

            if (i == 5) {
                myStringTable[i] = "|\t\t" + (i + 1) + " - " + myIntegerTable[i] + "\t\t|";
            }
            if (i < 5 && i >= 0) {
                myStringTable[i] = "\t\t" + (i + 1) + " - " + myIntegerTable[i] + "\t\t|";
            }
            if (i == 6) {
                myStringTable[i] = firstPlayer + " - " + myIntegerTable[i] + "\t\t";
            }
            if (i == 7) {
                myStringTable[i] = "|\t\t" + (i) + " - " + myIntegerTable[i] + "\t\t|";
            }
            if (i > 7 && i < 13) {
                myStringTable[i] = "\t\t" + (i) + " - " + myIntegerTable[i] + "\t\t|";
            }
            if (i == 13) {
                myStringTable[i] = "\t\t" + secondPlayer + " - " + myIntegerTable[i];
            }
            if (i == 14) {
                myStringTable[i] = "\t\t\t\t\t\t\t\tW I N N E R ! ! ! \t\t\t\t\t\t\t\t";
            }
        }
    }

    void givePoints(Integer[] myIntegerTable, int firstMove, Player player1, Player player2) {

        if (firstMove == 0) {
            player1.points = myIntegerTable[6];
        } else {
            player2.points = myIntegerTable[13];
        }
    }
}