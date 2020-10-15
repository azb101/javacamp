package functional;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        // custom
        MyInterface labmda = () -> {
            System.out.println("Running");
        };

        labmda.Run();

        // function
         var doubled = FunctionDemo.<Integer, Integer>ChangeValue((a) -> {
             return a * 2;
         }, 10);
        System.out.println(doubled);

        // consumer
        Consumer<Double> cons = (doubleValue) -> System.out.println(doubleValue * 100);
        cons.accept(5.0);
    }

    interface MyInterface {
        void Run();
    }

    static <I extends Number,T extends Number> T ChangeValue(Function<I, T> fun, I num) {
        return fun.apply(num);
    }
}
