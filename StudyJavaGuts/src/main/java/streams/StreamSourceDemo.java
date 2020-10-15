package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSourceDemo {
    public static void main(String[] args) {


        int[] ints = {-1, 0, 2, 3, 5};

        List<String> stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");

        // 1. Arrays.stream([])
        var intStream = Arrays.stream(ints);

        // 2. Collection.stream
        var stringStream = stringList.stream();

        // 3. Stream.of
        var randomStream = Stream.of(5, 4, 3, 2, 1);

        // 4. parallel stream
        var parallelStream = stringList.parallelStream();
    }
}
