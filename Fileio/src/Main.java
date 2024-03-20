import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File filenameTxt = new File("files/filename.txt");

        try {

            if (filenameTxt.createNewFile()) {
                System.out.println("Sikeresen létrehoztam a fájlt!");
            } else {
                System.out.println("A fájl már létezik.");
            }
            //createNewFile metódus: arra jó, hogy megvizsgálja, létezik-e az adott file, így nem // fordulhat elvileg elő, hogy felülírunk egy létező filet. Nem runtime exceptionjei vannak, amiket le kell kezelni
        } catch (IOException e) {
            System.out.println("IO hiba: " + e);
        }

// Fájl létrehozása teljes könyvtárszerkezettel
        Path pathToFile = Paths.get("files/teszt/mappa/cica.txt"); // Path - útvonal tárolására, elmentésére szolgál

        try {
            Files.createDirectories(pathToFile.getParent());
            if (!Files.exists(pathToFile)) // ha nem létezik a fájl, csak akkor hozza létre
                Files.createFile(pathToFile);
        } catch (IOException e) {
            System.out.println("Nem sikerült a mappa létrehozása." + e);
        }

//        Fájl olvasása Scannerrel
        try {
            Scanner myReader = new Scanner(filenameTxt);
            int rowNumber = 1;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(rowNumber++ + ". " + "Adott sor tartalma: " + line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Forrásfájl nem található: " + filenameTxt.getPath());
        }

        // Fájl írása
        try {
            FileWriter fw = new FileWriter(filenameTxt); // Charset.forname "UTF-8" - megadható neki a karakterkód típusa
            fw.write("Almafa" + System.lineSeparator()); // így platform-független lesz a kód, a \n ebből a szempontból nem jó megoldás
            fw.write("Cicus" + System.lineSeparator());
            fw.write("Kutyus" + System.lineSeparator());
            fw.write("Árvíztűrőtükörfúrógép" + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            System.out.println("Írási hiba! " + e);
        }

//            1. Mentsük le a mellékelt colors-list.txt fájlt, majd nyissuk meg, rendezzük listába a benne
//            lévő színeket, majd adjuk vissza a leghosszabbat.

        File colors = new File("files/colors-list.txt");
        try {
            Scanner colorScanner = new Scanner(colors);
            List<String> colorList = new ArrayList<>();
            while (colorScanner.hasNextLine()) {
                colorList.add(colorScanner.nextLine());
            }
            colorList.stream().max(Comparator.comparing(String::length))
                    .ifPresent(x -> System.out.println("A leghosszab szín: " + x));

// így is lehet kezelni ezt a streamet:
//                String s = colorList.stream().max(Comparator.comparing(String::length))
//                        .orElse("Nincs érték");

//                Optional<String> res = colorList.stream().max(Comparator.comparing(String::length)) if res is present res.get, else "Nincs érték"


            System.out.println("Színek száma: " + colorList.size());
            colorScanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found! " + ex);
        }
//2. Valósítsunk meg keresést. Egy scanner-rel kérjetek be egy szöveget, írjátok ki a találatok számát és soroljátok
// is fel a találatokat. Értelemszerűen az orange-re dobja ki az orange és carrot-orange kifejezéseket is.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Írj be egy színt angolul!");
        String szin = scanner.nextLine();

        try {
            Scanner colorScanner2 = new Scanner(colors);
            List<String> colorList2 = new ArrayList<>();
            while (colorScanner2.hasNextLine()) {
                colorList2.add(colorScanner2.nextLine());
            }
            Long matches = colorList2.stream()
                    .filter(c -> c.contains(szin))
                    .count();
            System.out.println("Találatok száma a keresett színre: " + matches);
            System.out.println("Találati lista:");
            colorList2.stream()
                    .filter(c -> c.contains(szin))
                    .forEach(System.out::println);
            colorScanner2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nincs találat");
        }

        //contains után a streamben collect(Collectors.toList)-el ki lehet menteni változóba. - egy listába,
        // ami var Változó, vagy konkrétan List is lehetne

//3. Legyen adott egy CSV állomány, melynek felépítése:
//Name;BirthYear;Height;JobTitle
//
//	1. Hozzunk létre egy Person osztályt, mely a megfelelő mezők adattagjaival rendelkezik!
//	2. Olvassuk be az állományt, és hozzunk létre belőle Person példányokat, melyeket egy listába gyűjtünk!
//	3. Keressük meg a legfiatalabb és legöregebb embert, írjuk ki az adatait!
//	(Lehetőség szerint használjunk stream műveleteket!)
//	4. Számítsuk ki az átlagos magasságukat!
//	5. Számítsuk ki az átlagos életkorukat!
//	6. Hozzunk létre két új embert, és rakjuk be a listába!
//	7. A lista tartalmát mentsük ki fájlba ezzel felülírva az eredeti fájlt!
//	(Érdemes a person osztályba csinálni egy GetCSVString függvényt, ami visszaadja a mezők értékét
//	pontosvesszőkkel elválasztva) (Figyelj a sortörésekre!)

        List<Person> personsList = new ArrayList<>();
        try {
            File persons = new File("files/Persons.csv");
            Scanner personScan = new Scanner(persons);

            var header = personScan.nextLine(); // kiolvassuk a sort, mert erre a sorra nincs rá szükség
            while (personScan.hasNextLine()) {
                String[] columns = personScan.nextLine().split(";");
                var name = columns[0];
                var birthYeaar = Integer.parseInt(columns[1]);
                var height = Integer.parseInt(columns[2]);
                var jobTitle = columns[3];
                Person p = new Person(name, birthYeaar, height, jobTitle);
                personsList.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No human!!!");
        }
        System.out.println(personsList);
        System.out.println("A legfiatalabb személy: ");
        System.out.println(personsList.stream().max(Comparator.comparingInt(Person::getBirthYear)));
        System.out.println("A legidősebb személy: ");
        System.out.println(personsList.stream().min(Comparator.comparingInt(Person::getBirthYear)));



        int heightSum = 0;
        double heightAverage = 0;
        List<Integer> integerList = (personsList.stream().map(Person::getHeight).toList());
        for (int i = 0; i < integerList.toArray().length; i++) {
           heightSum += (int) integerList.toArray()[i];
           heightAverage = (double)heightSum / integerList.size();
        }
        System.out.println("A személyek testmagasságának átlaga: ");
        System.out.println(heightAverage);  //Ezt úgy is lehetett volna, hogy mapToInt.average.ifPresent--sout
//*********************************
        int ageSum = 0;
        double ageAverage = 0;

        List<Integer> integerList2 = (personsList.stream().map(Person::getBirthYear).toList());

        for (int i = 0; i < integerList2.toArray().length; i++) {
            ageSum += 2023 - (int) integerList2.toArray()[i];
            ageAverage = (double) ageSum / integerList2.size();
        }
        System.out.println("A személyek átlag életkora: ");
        System.out.println(ageAverage);


        Person person1 = new Person("Hej Sándor", 1980, 166, "lakatos");
        Person person2 = new Person("Haj Nándor", 1985, 170, "ács");

        personsList.add(person1);
        personsList.add(person2);


        //7-es feladat
        
//*******************

//        try (FileWriter personListFile = new FileWriter(String.valueOf(personsList))) {
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//
//        Path pathToFile2 = Paths.get("files/personListFile.txt");
//
//        try {
//            Files.createDirectories(pathToFile2.getParent());
//            if (!Files.exists(pathToFile2))
//                Files.createFile(pathToFile2);
//        } catch (IOException e) {
//            System.out.println("Nem sikerült a fájl létrehozása." + e);
//        }


    }
}