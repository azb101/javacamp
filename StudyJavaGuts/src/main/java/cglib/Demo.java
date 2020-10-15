package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Animal.class);
        enhancer.setCallback((FixedValue)()->{
            System.out.println("Hello from callback");
            return "aaaaaaaaa";
        });

        var animalProxy = (Animal)enhancer.create();
        animalProxy.Say();
        var name = animalProxy.getName();
        System.out.println(name);

        System.out.println("------------");

        // another example
        var anotherEnh = new Enhancer();
        anotherEnh.setSuperclass(Animal.class);
        anotherEnh.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable {
                System.out.println(method.getName() + " virtualized ");
                if(method.getDeclaringClass() != Animal.class && method.getReturnType() == String.class) {
                    return "This is Animal class or String class";
                } else {
                    return "Some result";
                    // throw new RuntimeException("Do not know what to do.");
                }
            }
        });

        var anotherProxy = (Animal)anotherEnh.create();
        anotherProxy.Say();
        var anotherName = anotherProxy.getName();
        System.out.println(anotherName);
    }
}
