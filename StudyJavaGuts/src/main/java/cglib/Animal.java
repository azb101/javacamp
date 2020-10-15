package cglib;

public class Animal {
    private String name = "tiger";

    public Animal() {
    }

    public void Say() {
        System.out.println(name);
    }

    public String getName(){
        return name;
    }
}
