import java.util.Random;
import java.util.Scanner;

public class methods {


    static char[][] map;

    {
        // replaceTable(array);
    }

    public static void Rules() {
        String gameRules = "Szabályok: ";
        String gameRules0 = "Egy tetszőleges elemet mozgathatunk vízszintesen és függőlegesen, csak a vele közvetlenül szomszédos elemmel.";
        String gameRules1 = "Ha legalább három egyforma elem kerül egymás mellé/alá, akkor azok eltűnnek. Pontozás: az egyforma elemek száma szorozva 5-tel.";
        String gameRules2 = "Ha a játékos eléri az előzőleg beállított célpontszámot, akkor nyert.";
        String gameRules3 = "Téves karakterhasználat esetén, GAME OVER, és újból kell futtatni a játékot.";
        System.out.println(gameRules);
        System.out.println(gameRules0);
        System.out.println(gameRules1);
        System.out.println(gameRules2);
        System.out.println(gameRules3);
    }

    /**
     * A gyümölcsök tömbje
     *
     * @return Visszadja a gyümölcsöket tartalmazó tömböt
     */

    public static char[] fruits() {

        char[] fruits = new char[6];
        fruits[0] = '♠';
        fruits[1] = '♥';
        fruits[2] = '♦';
        fruits[3] = '♣';
        fruits[4] = '♤';
        fruits[5] = '♧';
        return fruits;
    }

    /**
     * RandomMap
     *
     * @param fruits A gyümölcsök tömbje
     * @return Randomizált 2D karaktertömb
     */

    public static char[][] randomMap(char[] fruits) {
        Random random = new Random();
        char[][] randomMap = new char[8][8];
        for (int i = 1; i < randomMap.length; i++) {
            for (int j = 1; j < randomMap[i].length; j++) {
                randomMap[i][j] = fruits[random.nextInt(fruits.length)];
            }
        }

        mapFrame(randomMap);

        return randomMap;
    }

    public static void mapFrame(char[][] randomMap) {
        for (int i = 0; i < randomMap.length; i++) {
            for (int j = 0; j < randomMap[i].length; j++) {
                if (i == 0) {
                    char nullNull = '#';
                    randomMap[i][j] = (j != 0 ? (char) ('A' + j - 1) : nullNull);
                } else {
                    for (int a = 1; a < 8; a++) {
                        randomMap[a][0] = Character.forDigit(a, 8);
                        randomMap[0][a] = Character.forDigit(a, 8);
                    }
                }
            }
        }
    }

    /**
     * Ez készíti el a játékteret, amiben nem lehet egymás mellett 3 azonos karakter
     * <p>
     * Tehát itt már a createmappal vizsgálódik a program
     *
     * @param
     */

    public static void startingMap() {
        if (map == null) {
            int createMap = 999;
            //char[][] startingMap = null;
            while (createMap > 0) {
                map = randomMap(methods.fruits());
                createMap = checkTable(3);
            }

            for (int i = 0; i < map.length; i++) {
                System.out.println();
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int inputRow1() {
        Scanner sc = new Scanner(System.in);
        Color.PrintLn("Hanyadik sorban lévő cukorkát szeretnéd áthelyezni?", Color.BLUE);
        int row1 = -1;
        if (sc.hasNextInt()) {
            row1 = sc.nextInt();
            if (row1 < 1 || row1 > 7) {
                Color.PrintLn("Helytelen szám, a sorok sorszáma 1-7-ig terjedhet, futtasd újból a játékot!", Color.RED);
                System.exit(0);
            }
        } else {
            Color.PrintLn("Helytelen bemenet, a sor sorszámának egész számnak kell lennie. Futtasd újból a játékot!", Color.RED);
            System.exit(0);
        }
        return row1;
    }

    public static int inputCol1() {
        Scanner sc = new Scanner(System.in);
        Color.PrintLn("Hanyadik oszlopban lévő cukorkát szeretnéd áthelyezni?", Color.BLUE);
        int col1 = -1;
        if (sc.hasNextInt()) {
            col1 = sc.nextInt();
            if (col1 < 1 || col1 > 7) {
                Color.PrintLn("Helytelen szám, az oszlopok sorszáma 1-7-ig terjedhet, futtasd újból a játékot!", Color.RED);
                System.exit(0);
            }
        } else {
            Color.PrintLn("Helytelen bemenet, az oszlop sorszámának egész számnak kell lennie. Futtasd újból a játékot!", Color.RED);
            System.exit(0);
        }
        return col1;
    }

    public static int inputRow2() {
        Scanner sc = new Scanner(System.in);
        Color.PrintLn("Hanyadik sorban lévő cukorkával szeretnéd megcserélni az általad választott cukorkát?", Color.BLUE);
        int row2 = -1;
        if (sc.hasNextInt()) {
            row2 = sc.nextInt();
            if (row2 < 1 || row2 > 7) {
                Color.PrintLn("Helytelen szám, a sorok sorszáma 1-7-ig terjedhet, futtasd újból a játékot!", Color.RED);
                System.exit(0);
            }
        } else {
            Color.PrintLn("Helytelen bemenet, a sor sorszámának egész számnak kell lennie. Futtasd újból a játékot!", Color.RED);
            System.exit(0);
        }
        return row2;
    }

    public static int inputCol2() {
        Scanner sc = new Scanner(System.in);
        Color.PrintLn("Hanyadik oszlopban lévő cukorkával szeretnéd megcserélni az általad választott cukorkát?", Color.BLUE);
        int col2 = -1;
        if (sc.hasNextInt()) {
            col2 = sc.nextInt();
            if (col2 < 1 || col2 > 7) {
                Color.PrintLn("Helytelen szám, az oszlopok sorszáma 1-7-ig terjedhet, futtasd újból a játékot!", Color.RED);
                System.exit(0);
            }
        } else {
            Color.PrintLn("Helytelen bemenet, az oszlop sorszámának egész számnak kell lennie. Futtasd újból a játékot!", Color.RED);
            System.exit(0);
        }
        return col2;
    }

    /**
     * mapAfterSnap- a karaktercsere utáni térképet adja vissza
     *
     * @param
     */

    public static void mapAfterSnap() {

        int row1 = methods.inputRow1();
        int col1 = methods.inputCol1();
        int row2 = methods.inputRow2();
        int col2 = methods.inputCol2();

        char temp = map[row1][col1];
        char temp2 = map[row2][col2];

        boolean switchPossible = false;

        if (row1 == row2 && Math.abs(col1 - col2) == 1) {
            if (col2 <= 5 && temp == map[row2][col2 + 1] && temp == map[row2][col2 + 2] ||
                    col2 >= 2 && temp == map[row2][col2 - 1] && temp == map[row2][col2 - 2] ||
                    col2 > 1 && col2 < 7 && temp == map[row2][col2 - 1] && temp == map[row2][col2 + 1]) {
                temp = map[row1][col1];
                map[row1][col1] = map[row2][col2];
                map[row2][col2] = temp;
                switchPossible = true;
            } else if (row2 <= 5 && temp == map[row2 + 1][col2] && temp == map[row2 + 2][col2] ||
                    row2 >= 2 && temp == map[row2 - 1][col2] && temp == map[row2 - 2][col2] ||
                    col2 > 1 && col2 < 7 && temp == map[row2 - 1][col2] && temp == map[row2 + 1][col2]) {
                temp = map[row1][col1];
                map[row1][col1] = map[row2][col2];
                map[row2][col2] = temp;
                switchPossible = true;
            } else if (col1 <= 5 && temp2 == map[row1][col1 + 1] && temp2 == map[row1][col1 + 2] ||
                    col1 >= 2 && temp2 == map[row1][col1 - 1] && temp2 == map[row1][col1 - 2] ||
                    col1 > 1 && col1 < 7 && temp2 == map[row1][col1 - 1] && temp2 == map[row1][col1 + 1]) {
                temp = map[row1][col1];
                map[row1][col1] = map[row2][col2];
                map[row2][col2] = temp;
                switchPossible = true;
            } else if (row1 <= 5 && temp2 == map[row1 + 1][col1] && temp2 == map[row1 + 2][col1] ||
                    row1 >= 2 && temp2 == map[row1 - 1][col1] && temp2 == map[row1 - 2][col1] ||
                    col1 > 1 && col1 < 7 && temp2 == map[row1 - 1][col1] && temp2 == map[row1 + 1][col1]) {
                temp = map[row1][col1];
                map[row1][col1] = map[row2][col2];
                map[row2][col2] = temp;
                switchPossible = true;

            }
        }

        if (col1 == col2 && Math.abs(row1 - row2) == 1) {
            if (row2 <= 5 && temp == map[row2 + 1][col2] && temp == map[row2 + 2][col2] ||
                    row2 >= 2 && temp == map[row2 - 1][col2] && temp == map[row2 - 2][col2] ||
                    col2 > 1 && col2 < 7 && temp == map[row2 - 1][col2] && temp == map[row2 + 1][col2]) {
                temp = map[row1][col1];
                map[row1][col1] = map[row2][col2];
                map[row2][col2] = temp;
                switchPossible = true;
            } else if (col2 <= 5 && temp == map[row2][col2 + 1] && temp == map[row2][col2 + 2] ||
                    col2 >= 2 && temp == map[row2][col2 - 1] && temp == map[row2][col2 - 2] ||
                    col2 > 1 && col2 < 7 && temp == map[row2][col2 - 1] && temp == map[row2][col2 + 1]) {
                temp = map[row1][col1];
                map[row1][col1] = map[row2][col2];
                map[row2][col2] = temp;
                switchPossible = true;
            } else if (row1 <= 5 && temp2 == map[row1 + 1][col1] && temp2 == map[row1 + 2][col1] ||
                    row1 >= 2 && temp2 == map[row1 - 1][col1] && temp2 == map[row1 - 2][col1] ||
                    col1 >= 1 && col1 <= 7 && temp2 == map[row1 - 1][col1] && temp2 == map[row1 + 1][col1]) {
                temp = map[row1][col1];
                map[row1][col1] = map[row2][col2];
                map[row2][col2] = temp;
                switchPossible = true;
            } else if (col1 <= 5 && temp2 == map[row1][col1 + 1] && temp2 == map[row1][col1 + 2] ||
                    col1 >= 2 && temp2 == map[row1][col1 - 1] && temp2 == map[row1][col1 - 2] ||
                    col1 > 1 && col1 < 7 && temp2 == map[row1][col1 - 1] && temp2 == map[row1][col1 + 1]) {
                temp = map[row1][col1];
                map[row1][col1] = map[row2][col2];
                map[row2][col2] = temp;
                switchPossible = true;
            }
        }

        if (!switchPossible) {
            System.out.println("Hibás bemenet, csere nem történt!");
        }


        searchEqualsAndChangeToX(row1, col1, row2, col2, temp, temp2);


        System.out.println();
        for (int k = 0; k < map.length; k++) {
            System.out.println();
            for (int l = 0; l < map[k].length; l++) {
                System.out.print(map[k][l] + " ");
            }
        }
    }

    private static void searchEqualsAndChangeToX(int row1, int col1, int row2, int col2, char temp, char temp2) {

        if (row1 == row2 || col1 == col2) {
            if (row2 <= 5 && row2 >= 2 && map[row2 + 1][col2] == map[row2][col2] && map[row2 + 2][col2] == map[row2][col2] &&
                    map[row2 - 1][col2] == map[row2][col2] && map[row2 - 2][col2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2 + 1][col2] = 'X';
                map[row2 + 2][col2] = 'X';
                map[row2 - 1][col2] = 'X';
                map[row2 - 2][col2] = 'X';


            } else if (row2 <= 5 && row2 >= 1 && map[row2 + 1][col2] == map[row2][col2] && map[row2 + 2][col2] == map[row2][col2] &&
                    map[row2 - 1][col2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2 + 1][col2] = 'X';
                map[row2 + 2][col2] = 'X';
                map[row2 - 1][col2] = 'X';

            } else if (row2 <= 6 && row2 >= 2 && map[row2 + 1][col2] == map[row2][col2] && map[row2 - 1][col2] == map[row2][col2] &&
                    map[row2 - 2][col2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2 + 1][col2] = 'X';
                map[row2 - 1][col2] = 'X';
                map[row2 - 2][col2] = 'X';

            } else if (row2 <= 6 && row2 >= 1 && map[row2 + 1][col2] == map[row2][col2] && map[row2 - 1][col2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2 + 1][col2] = 'X';
                map[row2 - 1][col2] = 'X';

            } else if (row2 >= 2 && map[row2 - 1][col2] == map[row2][col2] &&
                    map[row2 - 2][col2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2 - 1][col2] = 'X';
                map[row2 - 2][col2] = 'X';

            } else if (row2 <= 5 && map[row2 + 1][col2] == map[row2][col2] && map[row2 + 2][col2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2 + 1][col2] = 'X';
                map[row2 + 2][col2] = 'X';
            }
        }


        if (col1 == col2 || row1 == row2) {

            if (col2 <= 5 && col2 >= 2 && map[row2][col2 + 1] == map[row2][col2] && map[row2][col2 + 2] == map[row2][col2] &&
                    map[row2][col2 - 1] == map[row2][col2] && map[row2][col2 - 2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2][col2 + 1] = 'X';
                map[row2][col2 + 2] = 'X';
                map[row2][col2 - 1] = 'X';
                map[row2][col2 - 2] = 'X';

            } else if (col2 <= 5 && col2 >= 1 && map[row2][col2 + 1] == map[row2][col2] && map[row2][col2 + 2] == map[row2][col2] &&
                    map[row2][col2 - 1] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2][col2 + 1] = 'X';
                map[row2][col2 + 2] = 'X';
                map[row2][col2 - 1] = 'X';

            } else if (col2 <= 6 && col2 >= 2 && map[row2][col2 + 1] == map[row2][col2] && map[row2][col2 - 1] == map[row2][col2] &&
                    map[row2][col2 - 2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2][col2 + 1] = 'X';
                map[row2][col2 - 1] = 'X';
                map[row2][col2 - 2] = 'X';

            } else if (col2 <= 6 && col2 >= 1 && map[row2][col2 + 1] == map[row2][col2] && map[row2][col2 - 1] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2][col2 + 1] = 'X';
                map[row2][col2 - 1] = 'X';

            } else if (col2 >= 2 && map[row2][col2 - 1] == map[row2][col2] &&
                    map[row2][col2 - 2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2][col2 - 1] = 'X';
                map[row2][col2 - 2] = 'X';

            } else if (col2 <= 5 && map[row2][col2 + 1] == map[row2][col2] && map[row2][col2 + 2] == map[row2][col2]) {

                map[row2][col2] = 'X';
                map[row2][col2 + 1] = 'X';
                map[row2][col2 + 2] = 'X';
            }
        }

        if (row1 == row2 || col1 == col2) {
            if (row1 <= 5 && row1 >= 2 && map[row1 + 1][col1] == map[row1][col1] && map[row1 + 2][col1] == map[row1][col1] &&
                    map[row1 - 1][col1] == map[row1][col1] && map[row1 - 2][col1] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1 + 1][col1] = 'X';
                map[row1 + 2][col1] = 'X';
                map[row1 - 1][col1] = 'X';
                map[row1 - 2][col1] = 'X';

            } else if (row1 <= 5 && row1 >= 1 && map[row1 + 1][col1] == map[row1][col1] && map[row1 + 2][col1] == map[row1][col1] &&
                    map[row1 - 1][col1] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1 + 1][col1] = 'X';
                map[row1 + 2][col1] = 'X';
                map[row1 - 1][col1] = 'X';

            } else if (row1 <= 6 && row1 >= 2 && map[row1 + 1][col1] == map[row1][col1] && map[row1 - 1][col1] == map[row1][col1] &&
                    map[row1 - 2][col1] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1 + 1][col1] = 'X';
                map[row1 - 1][col1] = 'X';
                map[row1 - 2][col1] = 'X';

            } else if (row1 <= 6 && row1 >= 1 && map[row1 + 1][col1] == map[row1][col1] && map[row1 - 1][col1] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1 + 1][col1] = 'X';
                map[row1 - 1][col1] = 'X';

            } else if (row1 >= 2 && map[row1 - 1][col1] == map[row1][col1] &&
                    map[row1 - 2][col1] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1 - 1][col1] = 'X';
                map[row1 - 2][col1] = 'X';

            } else if (row1 <= 5 && map[row1 + 1][col1] == map[row1][col1] && map[row1 + 2][col1] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1 + 1][col1] = 'X';
                map[row1 + 2][col1] = 'X';
            }
        }


        if (col1 == col2 || row1 == row2) {
            if (col1 <= 5 && col1 >= 2 && map[row1][col1 + 1] == map[row1][col1] && map[row1][col1 + 2] == map[row1][col1] &&
                    map[row1][col1 - 1] == map[row1][col1] && map[row1][col1 - 2] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1][col1 + 1] = 'X';
                map[row1][col1 + 2] = 'X';
                map[row1][col1 - 1] = 'X';
                map[row1][col1 - 2] = 'X';

            } else if (col1 <= 5 && col1 >= 1 && map[row1][col1 + 1] == map[row1][col1] && map[row1][col1 + 2] == map[row1][col1] &&
                    map[row1][col1 - 1] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1][col1 + 1] = 'X';
                map[row1][col1 + 2] = 'X';
                map[row1][col1 - 1] = 'X';

            } else if (col1 <= 6 && col1 >= 2 && map[row1][col1 + 1] == map[row1][col1] && map[row1][col1 - 1] == map[row1][col1] &&
                    map[row1][col1 - 2] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1][col1 + 1] = 'X';
                map[row1][col1 - 1] = 'X';
                map[row1][col1 - 2] = 'X';

            } else if (col1 <= 6 && col1 >= 1 && map[row1][col1 + 1] == map[row1][col1] && map[row1][col1 - 1] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1][col1 + 1] = 'X';
                map[row1][col1 - 1] = 'X';

            } else if (col1 >= 2 && map[row1][col1 - 1] == map[row1][col1] &&
                    map[row1][col1 - 2] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1][col1 - 1] = 'X';
                map[row1][col1 - 2] = 'X';

            } else if (col1 <= 5 && map[row1][col1 + 1] == map[row1][col1] && map[row1][col1 + 2] == map[row1][col1]) {

                map[row1][col1] = 'X';
                map[row1][col1 + 1] = 'X';
                map[row1][col1 + 2] = 'X';
            }
        }

        if (row2 <= 5 && map[row2][col2] == 'X' && map[row2 + 1][col2] == temp && map[row2 + 2][col2] == temp) {

            map[row2 + 1][col2] = 'X';
            map[row2 + 2][col2] = 'X';

        } else if (row2 >= 2 && map[row2][col2] == 'X' && map[row2 - 1][col2] == temp && map[row2 - 2][col2] == temp) {

            map[row2 - 1][col2] = 'X';
            map[row2 - 2][col2] = 'X';

        } else if (col2 >= 2 && map[row2][col2] == 'X' && map[row2][col2 - 1] == temp && map[row2][col2 - 2] == temp) {

            map[row2][col2 - 1] = 'X';
            map[row2][col2 - 2] = 'X';

        } else if (col2 <= 5 && map[row2][col2] == 'X' && map[row2][col2 + 1] == temp && map[row2][col2 + 2] == temp) {

            map[row2][col2 + 1] = 'X';
            map[row2][col2 + 2] = 'X';

        }


        if (row1 <= 5 && map[row1][col1] == 'X' && map[row1 + 1][col1] == temp2 && map[row1 + 2][col1] == temp2) {

            map[row1 + 1][col1] = 'X';
            map[row1 + 2][col1] = 'X';

        } else if (row1 >= 2 && map[row1][col1] == 'X' && map[row1 - 1][col1] == temp2 && map[row1 - 2][col1] == temp2) {

            map[row1 - 1][col1] = 'X';
            map[row1 - 2][col1] = 'X';

        } else if (col1 >= 2 && map[row1][col1] == 'X' && map[row1][col1 - 1] == temp2 && map[row1][col1 - 2] == temp2) {

            map[row1][col1 - 1] = 'X';
            map[row1][col1 - 2] = 'X';

        } else if (col1 <= 5 && map[row1][col1] == 'X' && map[row1][col1 + 1] == temp2 && map[row1][col1 + 2] == temp2) {

            map[row1][col1 + 1] = 'X';
            map[row1][col1 + 2] = 'X';
        }
    }

    public static void floatXToTop() {

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j <= 7; j++) {
                if (map[i][j] == 'X') {
                    boolean end = false;
                    int tempI = i - 1;
                    while (!end && tempI > 0) {
                        if (map[tempI][j] == 'X') {
                            tempI--;
                        } else {
                            char tempChar = map[i][j];
                            map[i][j] = map[tempI][j];
                            map[tempI][j] = tempChar;
                            end = true;
//                            System.out.println("Csere:" + i + "_ " + j + "_ " + tempI);
                        }
                    }
                }
            }
        }

        System.out.println();
        for (int k = 0; k < map.length; k++) {
            System.out.println();
            for (int l = 0; l < map[k].length; l++) {
                System.out.print(map[k][l] + " ");
            }
        }
    }

    public static int countPoints() {
        int countX = 0;
        int temp = 0;
        countX = getCountX(countX);
        do {
            floatXToTop();
            randomize();
            temp = checkTable(5);
            countX += temp;
        } while (temp > 0);

        System.out.println();

        for (int k = 0; k < map.length; k++) {
            System.out.println();
            for (int l = 0; l < map[k].length; l++) {
                System.out.print(map[k][l] + " ");
            }
        }

        return countX;
    }

    private static int getCountX(int countX) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'X') {
                    countX++;
                }
            }
        }
        return countX;
    }

    private static void randomize() {
        Random random2 = new Random();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'X') {
                    int randomIndex = random2.nextInt(methods.fruits().length);
                    map[i][j] = methods.fruits()[randomIndex];
                }
            }
        }
    }


    public static int checkTable(int maxEqual) {
        int count = 0;
        for (int currentEquals = maxEqual; currentEquals >= 3; currentEquals--) {
            for (int i = 1; i <= 7; i++) {
                for (int j = 1; j <= 7; j++) {
                    if (map[i][j] != 'X' && j <= 8 - currentEquals) {
                        boolean equality = false;
                        for (int l = 0; l < currentEquals; l++) {
                            if (map[i][j] == map[i][j + l]) {
                                equality = true;
                            } else {
                                equality = false;
                                break;
                            }
                        }
                        if (equality) {
                            count += currentEquals;
                            for (int m = 0; m < currentEquals; m++) {
                                map[i][j + m] = 'X';
                            }
                        }
                    }

                    if (map[i][j] != 'X' && i <= 8 - currentEquals) {
                        boolean equality = false;
                        for (int l = 0; l < currentEquals; l++) {
                            if (map[i][j] == map[i + l][j]) {
                                equality = true;
                            } else {
                                equality = false;
                                break;
                            }
                        }
                        if (equality) {
                            count += currentEquals;
                            for (int m = 0; m < currentEquals; m++) {
                                map[i + m][j] = 'X';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
