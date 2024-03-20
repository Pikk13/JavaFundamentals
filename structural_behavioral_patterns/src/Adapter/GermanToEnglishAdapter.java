package Adapter;

// Bővítjük a régi osztály funkcionalitását
//Adapter - az új interfész szerint működik, de a régi osztályt használja
// Tárol egy példányt az eredeti(régi)osztályból
public class GermanToEnglishAdapter implements EnglishService{

    private GermanService germanService; //régi osztály példánya

    public GermanToEnglishAdapter(GermanService germanService){
        this.germanService = germanService;
    }


    @Override
    public void performTaskInEnglish(String input) {
        System.out.println("Perform task in english, translate to german");
        var s = input.replace("Hello", "Hallo");  // megváltoztatjuk az eredeti funkcionalitást
        this.germanService.taskInGerman(s);
    }
}
