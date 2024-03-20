import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String dough;
    private String sauce;
    private List<String> toppings = new ArrayList<>();

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + toppings +
                '}';
    }

    public static class PizzaBuilder {

        private String dough;
        private String sauce;
        private List<String> toppings;



        public PizzaBuilder(String dough) {
            this.dough = dough;
        }

        public PizzaBuilder withSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder plusToppings(List toppings) {
            this.toppings = toppings;
            return this;
        }

        public Pizza build() {
            var instance = new Pizza();
            instance.dough = this.dough;
            instance.sauce = this.sauce;
            instance.toppings = this.toppings;


            return instance;
        }

        @Override
        public String toString() {
            return "PizzaBuilder{" +
                    "dough='" + dough + '\'' +
                    ", sauce='" + sauce + '\'' +
                    ", toppings=" + toppings +
                    '}';
        }
    }
}



