package constructors.classes;

public class Animal extends AbstractCreature {

    public Animal() {
        System.out.println("Animal");
    }

    @Override
    protected void Say() {
        System.out.println("I'm " + name);
    }
}
