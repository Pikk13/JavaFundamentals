public class Main {
    public static void main(String[] args) {
        System.out.println(useSummary(3, 6));
        System.out.println(useDifference(3, 6));
        System.out.println(useMultiplication(3, 6));
        System.out.println("Lambdával: ");
        System.out.println(useSummary2(4,8));
        System.out.println(useDifference2(13, 3));
        System.out.println(useMultiplication2(33,56));
    }
        private static int useSummary ( int a, int b){
            Summary summary = new Summary() {
                @Override
                public int sumUp(int a, int b) {
                    return a + b;
                }
            };
            return summary.sumUp(a, b);
        }


        private static int useDifference ( int a, int b){

            Difference difference = new Difference() {
                @Override
                public int countDifference(int a, int b) {
                    return a - b;
                }
            };
            return difference.countDifference(a, b);

        }

        private static int useMultiplication ( int a, int b){
            Multiplication multiplication = new Multiplication() {
                @Override
                public int multiply(int a, int b) {
                    return a * b;
                }
            };
            return multiplication.multiply(a, b);
    }

    private static int useSummary2 ( int a, int b){
        Summary summary = (a1, b1) -> a1 + b1;
        return summary.sumUp(a, b);
    }


    private static int useDifference2 ( int a, int b){

        Difference difference = (a1, b1) -> a1 - b1;
        return difference.countDifference(a, b);

    }

    private static int useMultiplication2 ( int a, int b){
        Multiplication multiplication = (a1, b1) -> a1 * b1;
        return multiplication.multiply(a, b);
    }
}