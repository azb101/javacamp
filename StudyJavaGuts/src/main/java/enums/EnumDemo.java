package enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;

public class EnumDemo {
    public static void main(String[] args) {
        // enumerate on enum values + invoking abstract method
        for(var en : Planet.values()) {
            System.out.println(en + "  :  " + en.getClass() + "  :  " + en.asLowerCase());
        }
        System.out.println();

        // value of
        System.out.println(Planet.valueOf("EARTH").getGravity());

        // throws illegal argument if not found
        // System.out.println(Planet.valueOf("aaa"));
        System.out.println();

        //using enumSet
        var planets = EnumSet.of(Planet.JUPITER, Planet.MARS);
        for(var planet : planets)
            System.out.println(planet + " has gravity constant of " + planet.getGravity());
        System.out.println();

        // using enumMap
        var map = new EnumMap<Planet, Integer>(Planet.class);
        map.put(Planet.JUPITER, 5);
        map.put(Planet.EARTH, 3);
        System.out.println("EnumMap: " + map);

        var addition = OperationEnum.MULT;
        System.out.println(addition.invoke(3, 5));
    }
}
