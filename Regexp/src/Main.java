import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "line line like like liVe lipe";
        String regex = "li[kn]e";                       // vagy a k vagy az n legyen azon a helyen
        //        String regex = "li[a-zA-Z0-9]e";  -- ez helyettesíthető [\\w] az összes szám és betű, kis és nagy számok
        //        String regex = "li[^0-9]e"; kizárás- tehát számok nem lehetnek annak a karakternek a helyén
        //        [\\d]  -- digit SZÁMJEGY   \t -- tabulátor    \n -- sortörés  \\s -- szóköz, tabulátor és enter
        //        [\\W]  --- minden másfajta karaktert keres, ami nem \\w
        // lehet kombinálni \\wÉ!   stb
        //         \\S -- a kis s ellentéte, mindent elfogad ami nem szóköz, tabulátor és enter
        // a nagy betűk mindig NEGÁLÁST jelentenek
        // li[\\w]e ?  -- az előtte való karaktert figyeli, amiből vagy van 0, vagy pedig 1
        // li[\\w]e *  -- az előtte való karaktert figyeli, amiből vagy van 0, vagy pedig lehet belőle több is
        // li[\\w]e +  -- az előtte való karaktert figyeli, amiből vagy van 1, vagy pedig lehet belőle több is
        // ^[] sor eleji keresés   [^vbk] itt a ^ negálást jelent - tehát nem lehet kis v
        // [vbk$] ez a sor végi egyezés
        // a . minden karaktert helyettesít Ha konkrétan a szövegben keresünk pontot, akkor "\\."
        // [\\w]+\\.  így nem csak egy karakterre, hanem az egész szóra rákeres? , a végén pedig pont legyen!
        // [\\w]{5}\\.  5 darab bármilyen karakterre keres, a végén pedig pont legyen! {4,5} -- legalább 4, max 5(min-max)
        // ha []+ van, akkor az egész zárójel tartalmára összpontosít, tehát ott eredményként lehet több karakter is a megoldás
        //       \\b[\\w{3}]+\\b] szótípusú(az összes betű és szám) karaktereket-karaktercsoportokat keresek akár az elején, akár a végén van váltás



        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int counter = 0;
        while (matcher.find()) {
            // matcher.start(); -- // indexkeresés, hol kezdődik az adott találat?
            // matcher.end();  -- // a szöveg utáni karakter végén levő index
            // matcher.group();  -- // a talált csoportokat adja vissza
            // matcher.matches();-- booleant ad, nem vár paramétert. 100%-os egyezőséget keres
            // input.length
            counter++;
        }
        System.out.println("Found: " + counter);


//          Amennyiben nem szeretnénk, hogy a kis-nagybetű figyelembe legyen véve:
//          Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        String input2 = "2023. 09. 27.";
        String regex2 = "[0-9][0-9][0-9][0-9]\\. [0-9][0-9]\\. [0-9][0-9]\\.";

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(input2);

        int counter2 = 0;
        while (matcher2.find()) {

            counter2++;
        }

        System.out.println("Found: " + counter2);

        // String regex = "[a-z&&[^p-w]]+" összefűzés is lehetséges
        // String regex = "(\\d{1,3}.*\\1)" ()-lementi az értéket -- az 1-es azt jelöli, hogy még egyszer forduljon elő ugyanaz


//       1. Írjunk egy programot, ami validálja, hogy a bemenetként kapott string HEX-kód vagy sem. Valid HEX-kód:
//      első karakter: #
//      utána pontosan 6 db 0-9-ig terjedő szám vagy a-f vagy A-F karakterek
//
//      2. Írjunk egy regexp-et, amely validál egy telefonszámot. A telefonszám állhat számokból és kötőjelekből. Pl. 56-89-789456
//
//      3. Egészítsük ki a programunkat, hogy kötelezően + jellel kezdődhet.
//
//      4. Opcionálisan + jellel kezdődhet.

        String input3 = "#123456";
        String regexp3 = "^[#][\\w]{6}";

        String mobile = "56-89-789456";
        String mobileRegexp = "[0-9]{2}-[0-9]{2}-[0-9]{6}";

        String mobileWithPlus = "+56-89-789456";
        String mobileRegexpMustPlus = "\\+[0-9]{2}-[0-9]{2}-[0-9]{6}";

        String mobileRegexpOptionalPlus =  "\\+?[0-9]{2}-[0-9]{2}-[0-9]{6}";

        Pattern pattern3 = Pattern.compile(mobileRegexpOptionalPlus);
        Matcher matcher3 = pattern3.matcher(mobileWithPlus);

        int counter3 = 0;
        while (matcher3.find()) {

            counter3++;
        }

        System.out.println("Found: " + counter3);
        String email = "sere-mere_ke.re@gmail.com";
      String emailRegexp = "[\\w-_\\.]+@[a-z]{2,}\\.[a-z]{2,}";

        Pattern pattern4 = Pattern.compile(emailRegexp);
        Matcher matcher4 = pattern3.matcher(email);

        int counter4 = 0;
        while (matcher4.find()) {

            counter4++;
        }
        System.out.println("Found: " + counter4);
    }
}