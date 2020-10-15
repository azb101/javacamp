package streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamAdditionalDemo {
    public static void main(String[] args) {

        var lst1 = List.of("a", "b");
        var lst2 = List.of("c");

        Stream.concat(lst1.stream(), lst2.stream()).forEach(System.out::println);
    }
}
