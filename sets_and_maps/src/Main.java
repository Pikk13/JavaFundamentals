import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Integer> integerSet = new HashSet<>();  // a sima hashset nem őrzi meg a sorrendiséget, gyorsabb
        integerSet.add(3);
        integerSet.add(66);
        integerSet.add(24);
        integerSet.add(9);
        integerSet.add(12);
        integerSet.add(64);
        integerSet.add(37);
        System.out.println(integerSet);
        System.out.println();
        Set<Integer> integerLinkedHashSet = new LinkedHashSet<>(); // a linkedhashset megőrzi a sorrendiséget, hátránya, hogy lassabb
        integerLinkedHashSet.add(3);
        integerLinkedHashSet.add(66);
        integerLinkedHashSet.add(24);
        integerLinkedHashSet.add(9);
        integerLinkedHashSet.add(12);
        integerLinkedHashSet.add(64);
        integerLinkedHashSet.add(37);
        System.out.println(integerLinkedHashSet);

        System.out.println();
        SortedSet<Integer> integerTreeSet = new TreeSet<>(integerSet);  //a treeset szortírozza, rendezi az elemeket, ezért nagyon gyors
        System.out.println(integerTreeSet); // nővekvő sorrendbe rakta az elemeket

        System.out.println(integerTreeSet.headSet(37)); // headset
        System.out.println(integerTreeSet.tailSet(37)); // tailset
        System.out.println(integerTreeSet.first()); // first element
        System.out.println(integerTreeSet.last());  //last element
        System.out.println(integerTreeSet.subSet(3, 64)); // subset -kezdőérték és végső érték (tól - ig)
        // ha ebből törölnénk elemet, akkor az integerTreeSetből is törlődni fog

        SortedSet<Integer> integers = new TreeSet<>(integerTreeSet.subSet(3, 64));  // ez már egy új TreeSet
        System.out.println(integers); // itt ha törlünk, akkor az integerTreeSetet változatlanul hagyja

        System.out.println("================================");

        NavigableSet<Integer> integerNavigableSet = new TreeSet<>(integerSet);
        System.out.println(integerNavigableSet);
        System.out.println(integerNavigableSet.headSet(37, true)); // megadható, hogy a megadott értéket is tartalmazza-e
        System.out.println(integerNavigableSet.tailSet(12, false)); // ne tartalmazza a kezdőértéket
        System.out.println(integerNavigableSet.ceiling(35));
        System.out.println(integerNavigableSet.floor(35));
        System.out.println(integerNavigableSet.descendingSet());
        System.out.println(integerNavigableSet.higher(37));
        System.out.println(integerNavigableSet.lower(37));
        System.out.println(integerNavigableSet.subSet(9, true, 24, true));
        System.out.println(integerNavigableSet);

        System.out.println("===============================MAP============================");
        Map<String, Integer> stringIntegerMap = new HashMap<>();   // String lesz a kulcs(KEY), Integer az érték(VALUE)!!!
        stringIntegerMap.put("Karcsika", 52); // A kulcsok mindig EGYEDIEK!
        stringIntegerMap.put("Ferike", 82);
        stringIntegerMap.put("Sanyika", 2);
        stringIntegerMap.put("Marcsika", 52); // ugyanaz az érték, tartozhat több kulcshoz is. Marcsika és Karcsika is 52
        stringIntegerMap.put("Sanyika", 22);  // Ez a kulcs már szerepel, így felülíródik az eredeti kulcs
        System.out.println(stringIntegerMap);
        System.out.println(stringIntegerMap.containsKey("Ferike")); // containsKey - boolean...
        System.out.println(stringIntegerMap.containsValue(22)); // containsValue - itt true
        System.out.println(stringIntegerMap.isEmpty()); // üres? false
        System.out.println(!stringIntegerMap.isEmpty()); // nem üres? true
        System.out.println(stringIntegerMap.keySet()); // a kulcsok kiiratása - keySet. Itt setként van kiiratva
        stringIntegerMap.put("Zolika", 33);
        System.out.println(stringIntegerMap);
        stringIntegerMap.replace("Zolika", 5);
        System.out.println(stringIntegerMap);


        Set<Map.Entry<String, Integer>> entries = stringIntegerMap.entrySet();  //Entry - a mapünkben tárolt kulcsérték-pár bejárható formája
        System.out.println(entries);
        stringIntegerMap.forEach((a, b) -> System.out.println("Kulcs: " + a + ", érték: " + b)); // forEach

        for (var elem : entries) {  // foreach
            System.out.println(elem);
        }
        for (var element : entries) {  //foreach külön kiiratva a kulcsot és az értéket
            System.out.println("Kulcs: " + element.getKey() + ", érték: " + element.getValue());
        }


        stringIntegerMap.putIfAbsent("Cilike", 66); // csak akkor rakja bele, ha nem létezik, máskülönben nem csinál semmit
        System.out.println(stringIntegerMap);

        Person szemely1 = new Person();
        szemely1.setId("2344lllkkk");
        Map<String, Person> stringPersonMap = new HashMap<>();
        stringPersonMap.put(szemely1.getId(), szemely1);
        System.out.println(stringPersonMap);

        System.out.println("======================================");




    }
}