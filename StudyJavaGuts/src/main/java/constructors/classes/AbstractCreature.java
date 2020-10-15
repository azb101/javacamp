package constructors.classes;

public abstract class AbstractCreature {

    public AbstractCreature() {
        System.out.println("init abstract creature");
    }

    protected String name;

    abstract void Say();
}
