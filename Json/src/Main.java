import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            String content = Files.readString(Paths.get("movies-short-1.json"));
            System.out.println("CONTENT!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(content);

            Gson gs = new Gson();
            List<Movie> movieList = Arrays.asList(gs.fromJson(content, Movie[].class));

            System.out.println("FOREACH!!!!!!!!!!!!!!!!!!!!!!");

            movieList.forEach(x -> System.out.println("Movie: " + x));


            System.out.println("*********");
            String neuJson = gs.toJson(movieList);
//            System.out.println(neuJson);
            System.out.println("*********");
            Gson prettyGs = new GsonBuilder().setPrettyPrinting().create();
            String neuJsonPretty = prettyGs.toJson(movieList);
//            System.out.println(neuJsonPretty);


        } catch (IOException e) {
            System.out.println("Nem található a fájl");
        }


        System.out.println("FELADAT: mennyi filmben szerepel Samuel L Jackson?");
        try {
            String content = Files.readString(Paths.get("movies.json"));
//            System.out.println(content);
            Gson gs = new Gson();
            List<Movie> movieList = Arrays.asList(gs.fromJson(content, Movie[].class));

            System.out.println(movieList.stream().filter(x -> x.cast().contains("Samuel L. Jackson")).count());


//            movieList.forEach(x -> System.out.println("Movie: " + x));
            System.out.println("*********");
            String neuJson = gs.toJson(movieList);
//            System.out.println(neuJson);
            System.out.println("*********");
            Gson prettyGs = new GsonBuilder().setPrettyPrinting().create();
            String neuJsonPretty = prettyGs.toJson(movieList);
//            System.out.println(neuJsonPretty);


        } catch (IOException e) {
            System.out.println("Nem található a fájl");
        }

//        1. Olvassuk be a mellékelt movies.json fájlt, majd számoljuk össze,
//        hány filmben szerepelt mondjuk Samuel L. Jackson (vagy tetszőleges színész).
//
//2. Olvassuk be a Persons.json fájlt!
//	1. Ismerjük meg a formátumot, készítsünk hozzá record class-t, vagy POJO-t!
//	2. Olvassuk be egy listába az objektumokat!
//	3. Számoljuk meg, hány olyan személy van, akinek a Google a kedvenc keresőmotorja!
//	4. Számoljuk ki, az emberek hány százaléka idősebb 40 évnél!
//	5. Adjuk hozzá új Person objektumként magunkat a listához!
//	6. Mentsük el a módosított JSON fájlt!
//


        try {
            String content = Files.readString(Paths.get("Persons.json"));
            System.out.println(content);
            Gson gs = new Gson();
            List<Persons> personsList = Arrays.asList(gs.fromJson(content, Persons[].class));
            personsList.forEach(x -> System.out.println("Persons: " + x));
            System.out.println("GOOGLE********************************");
            System.out.println(personsList.stream().filter(x -> x.FavoriteSearchEngine().contains("Google")).count());
            long fourhties = personsList.stream().filter(x -> x.Age() > 40).count();
            double percentage = (fourhties * 100) / (double) personsList.size();
            System.out.println(percentage + " százaléka az embereknek 40 év feletti!");

            List<Persons> arrayList = new ArrayList<>(personsList);
            arrayList.add(new Persons(1313, "István Raffai", "Google", 36, "sereghajto@vipmail.hu"));

            System.out.println();
            Gson prettyGs = new GsonBuilder().setPrettyPrinting().create();
            String prettyGsPersons = prettyGs.toJson(arrayList);
            System.out.println(prettyGsPersons);

//           FILEWRITERRAL beleírni a fileba!

        } catch (IOException e) {
            System.out.println("Nem található a fájl");
        }

        //3. Olvassuk be a Cats.json fájlt!
//	1. Ismerjük meg a formátumot, készítsünk hozzá record class-t, vagy POJO-t!
////	2. Olvassuk be egy listába az objektumokat!
////	3. Számoljuk meg, hány okos cica van!
////	4. Írjuk ki azon cicák nevét, amiknek életkora 7 év felett van!
//
        try {
            String content = Files.readString(Paths.get("Cats.json"));
//            System.out.println(content);
            Gson gs = new Gson();
            List<Cats> catsList = Arrays.asList(gs.fromJson(content, Cats[].class));
            catsList.forEach(x -> System.out.println("Cats: " + x));

            System.out.println("Okos cicák száma: " + (catsList.stream().filter(x -> x.IsClever()).count()));
            catsList.stream().filter(x -> x.Age() > 7).map(x -> x.Name()).forEach(System.out::println);


        } catch (IOException e) {
            System.out.println("Nem található a fájl");
        }


        }
    }