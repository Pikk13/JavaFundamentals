import java.util.*;

public class Main {
    public static void main(String[] list) {

        List<Integer> integerList = new ArrayList<>();  //új lista létrehozása

        integerList.add(8);
        integerList.set(0, 11);
        System.out.println(integerList);
        integerList.add(9);
        integerList.set(1, 7);
        System.out.println(integerList);   //eddig add és set

        System.out.println(integerList.size()); // lista mérete

        System.out.println("COMPARATOR!!!!!!!!!!!!!!!");
        MyComparator myComparator = new MyComparator();
        Collections.sort(integerList);// sort
        System.out.println(integerList);

        integerList.add(66);
        integerList.add(44);
        System.out.println(integerList);

        System.out.println(integerList.subList(0, 2)); //sublist

        integerList.remove(3);                    //remove
        System.out.println(integerList);

        System.out.println(integerList.get(2));         //get  - a leggyakrabban használt metódus...

        final List<Integer> integers = List.of(1, 2, 2, 3, 5, 7, 8, 9, 3);  //add all
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.addAll(integers);
        System.out.println(integerArrayList);
        System.out.println("==========================");
        Iterator<Integer> iterator = integerList.iterator(); // iterátor (folyamatolvasó)
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        for (int elem : integerList) {    //foreach-el ugyanazt meg lehet csinálni, mint az iterátorral
            System.out.println(elem);
        }
        System.out.println();

        ListIterator<Integer> integerListIterator = integerList.listIterator(1); // attól az indextől
        while (integerListIterator.hasNext()) {                      //indul az iterátor, amit megadunk neki
            System.out.println(integerListIterator.next());
        }

        System.out.println();
        List<String> stringList = new ArrayList<>(); // list-ként tárolt objektum
        stringList.add("Laci");
        stringList.add("Feri");
        stringList.add("Jani");
        stringList.add("Laci");
        stringList.add("Laci");
        stringList.add("Jani");
        System.out.println(stringList.indexOf("Feri"));     // indexOf
        System.out.println();
        System.out.println(stringList.lastIndexOf("Jani"));  //lastIndexOf
        System.out.println();
        Set<String> stringSet = new HashSet<>();     // set -halmaz
        stringSet.add("első");
        stringSet.add("második");
        stringSet.add("harmadik");
        stringSet.add("harmadik");
        stringSet.add("harmadik");

        System.out.println(stringSet);      // nincs sorrendiség, keverve dobálja be a dolgokat, csak egyszer szerepel benne minden elem, nincs ismétlődés
        System.out.println();
        System.out.println(stringSet.size());      // a méretnél is csak a különbözőeket veszi figyelembe
        System.out.println();
        // addAll is működik, mondjuk egy Stringlistából átvett lista esetén

        System.out.println(stringSet.contains("második"));  // tartalmaz-e
        System.out.println();
        System.out.println(stringSet.isEmpty());   //üres-e
        System.out.println();
        Object[] array = stringSet.toArray();

        stringSet.remove("harmadik");
        System.out.println(stringSet);
    }
}