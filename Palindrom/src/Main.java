public class Main {
    public static void main(String[] args) {


        isPalindrom("Eb merev dögét, s tégöd verembe!");
    }
    public static void isPalindrom(String str) {

        String newStr = str.toLowerCase().replaceAll("\\W", "");
        char[] ch = newStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = newStr.length() - 1; i > -1; i--) {
            sb.append(ch[i]);
        }
        String stringReverse = sb.toString();
        System.out.println(str);
        if (newStr.equals(stringReverse)) {
            System.out.println("Ez egy palindrom.");
        } else System.out.println("Ez nem palindrom.");
    }
}