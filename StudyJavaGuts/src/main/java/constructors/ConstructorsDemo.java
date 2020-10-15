package constructors;

import constructors.classes.AbstractCreature;
import constructors.classes.Animal;
import constructors.classes.Lion;

import java.io.IOException;

public class ConstructorsDemo {
    public static void main(String[] args) throws IOException {

        var lion = new Lion();   // all constructors called in top down manner

        System.out.println(lion instanceof Lion);   // true
        System.out.println(lion instanceof Animal);  // true
        System.out.println(lion instanceof AbstractCreature);  // true;

        Animal animal = lion;
        System.out.println(animal instanceof Lion);   // true! even though animal is of type Animal, object it ends up pointing to a Lion object
        System.out.println(animal instanceof Animal);  // true
        System.out.println(animal instanceof AbstractCreature);  // true

        Animal anotherAnimal = new Animal();
        System.out.println(anotherAnimal instanceof Lion == false);   //  false
        System.out.println(anotherAnimal instanceof Animal);  // true
        System.out.println(anotherAnimal instanceof AbstractCreature);  // true

        AbstractCreature ameub = lion;
        System.out.println(ameub instanceof Lion);   //  false
        System.out.println(ameub instanceof Animal);  // true
        System.out.println(ameub instanceof AbstractCreature);  // true
    }
}
