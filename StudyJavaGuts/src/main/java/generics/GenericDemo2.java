package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo2 {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();
        List<Orange> orangeList = new ArrayList<>();

        fruitList.add(new Fruit());
        fruitList.add(new Fruit());
        orangeList.add(new Orange());

        List<? super Fruit> allFruits = new ArrayList<>();
        allFruits.add(fruitList.get(0));
        allFruits.add(fruitList.get(0));
        allFruits.add(orangeList.get(0));

        System.out.println(allFruits.get(2));
        allFruits.remove(allFruits.get(0));

        System.out.println(allFruits);

    }
}
