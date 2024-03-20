public class Main {
    public static void main(String[] args) {

        methods.Rules();

        int points = 0;
        while (points < 200){

            methods.startingMap();
            methods.mapAfterSnap();
            int countX = methods.countPoints();
            methods.checkTable(5);


            if (countX == 3) {
                points = points + 15;
            } else if (countX == 4) {
                points = points + 20;
            } else if (countX == 5) {
                points = points + 25;
            } else if (countX == 6) {
                points = points + 30;
            } else if (countX == 7) {
                points = points + 35;
            }
            System.out.println();
            System.out.println("Az eddig elért pontjaid száma: " + points);
        }
        if (points >= 200){
            System.out.println("Elérted vagy meghaladtad a beállított célpontszámot: " + points);
            System.out.println("Gratulálunk, nyertél!");
        }
    }
}