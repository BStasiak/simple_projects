package przykłady.Bantumi;

import java.util.Scanner;

/**
 * Class <code>Play</code> use Player and Table classes.
 * Has methods to play in game called Mankala widely known as Bantumi.
 *
 * @author Bartłomiej Stasiak
 * @version 1.0.0.0  04/08/2019
 */

public class Play {
    public static void main(String[] args) {

        Table table = new Table();
        String[] myStringTable = table.newStringTable();
        Integer[] myIntegerTable = table.newIntegerTable();

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Zasady gry w Mankala:\n\n" +
                "Gra jest dla dwóch osób. \n" +
                "W pierwszej linii znajduje się sześć pól należących do gracza nr 1. W trzeciej linii znajduje się sześć pól należących do gracza nr 2. \n" +
                "Każde pole ma dwie cyfry. Pierwsza cyfra odpowiada numerowi pola, druga odpowiada aktualnej ilości fasolek na danym polu. Na każdym polu znajdują się cztery fasolki. \n" +
                "W środkowej linii znajdują się domy graczy – mankale. Lewy należy do pierwszego gracza gracza, a prawy do gracza drugiego. \n\n" +
                "Gracz wybiera numer swojego pola i przenosi swoje fasolki w kierunku przeciwnym do ruchu wskazówek zegarka, zostawiając po jednej fasolce na każdym z kolejnych pól. \n" +
                "Fasolki w mankali gracza są jego punktami i nie można ich stamtąd usunąć. Gracz pomija przy rozkładaniu mankale przeciwnika. \n" +
                "Jeśli ostatnia fasolka zostaje dołożona do mankali gracza, wykonuje kolejny ruch. \n" +
                "Jeśli ostatnia fasolka zostaje dołożona na puste pole gracza, dokłada on tę fasolkę oraz fasolki z przeciwległego pola przeciwnika do swojej mankali. \n" +
                "Po wykonaniu ruchu, swój ruch wykonuje przeciwnik. \n\n" +
                "Gra kończy się, gdy na polach jednego z graczy zabraknie fasolek. Fasolki na wszystkich polach przeciwnika dodaje się wtedy do jego mankali i wygrywa ten z większa ich ilością. \n" +
                "Lub jeśli jeden z graczy ma w swojej mankali minimum 25 fasolek.\n\n" +
                "Grę rozpoczyna pierwszy gracz. O tym, kto jest pierwszym graczem decyduje losowanie.\n");

        int firstMove = Player.whoFirst(player1, player2);

        table.changeName(myStringTable, player1);
        table.changeName(myStringTable, player2);

        doTurn(table, myStringTable, myIntegerTable, player1, player2, firstMove);
    }

    static void doTurn(Table table, String[] myStringTable, Integer[] myIntegerTable, Player player1, Player player2, int firstMove) {

        Scanner scanner = new Scanner(System.in);
        int field;
        int arraysIndex;
        int emptyField;

        table.changePlaceOfBeansonStringTable(myStringTable, myIntegerTable, player1, player2);

        table.changeBanner(myStringTable, firstMove);

        table.showTable(myStringTable);

        do {
            field = table.chooseField(scanner);
            field = table.checkIfFieldIsCorrected(scanner, field, firstMove);
            arraysIndex = table.convertToArraysIndex(field);
            emptyField = table.checkIfFieldIsNotEmpty(myIntegerTable, arraysIndex);
        } while (emptyField == 1);

        int temp = table.changePlaceOfBeansonIntegerTable(myIntegerTable, arraysIndex, firstMove);

        int lastField = table.markLastField(temp, arraysIndex);

        table.isLastFieldAtOwnEmptyField(myIntegerTable, lastField, firstMove, player1, player2);

        table.givePoints(myIntegerTable, firstMove, player1, player2);

        table.checkIfWin(myIntegerTable, myStringTable, firstMove, player1, player2);

        table.isLastFieldAtPlayersHome(table, myStringTable, myIntegerTable, player1, player2, firstMove, lastField);

        firstMove = Player.changeFirstMove(firstMove);

        Play.doTurn(table, myStringTable, myIntegerTable, player1, player2, firstMove);
    }
}