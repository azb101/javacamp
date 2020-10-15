package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo3 {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();
        List<Orange> orangeList = new ArrayList<>();

        fruitList.add(new Fruit());
        fruitList.add(new Fruit());
        orangeList.add(new Orange());

        // List<?> allFruits = new ArrayList<>();


        List<?> allFruits = orangeList;
        allFruits.add(null);

        System.out.println(allFruits);

        allFruits.remove(0);
        System.out.println(allFruits);
    }
}
