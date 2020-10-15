package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo1 {
    public static void main(String[] args) {
        Fruit[] fruitArray = new Fruit[5];
        Orange[] orangeArray = new Orange[5];

        List<Fruit> fruitList = new ArrayList<>();
        List<Orange> orangeList = new ArrayList<>();

        // orange is subclass of fruit
        // as arrays are covariant:
        System.out.println(orangeArray instanceof Fruit[]);     // true
        System.out.println(fruitArray instanceof Fruit[]);      // true
        System.out.println(fruitArray instanceof Orange[]);    // false

        System.out.println();
    }
}
