package streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminalDemo {
    public static void main(String[] args) {

        var lst = List.of(1,3,5,6,10);

        // anyMatch/allMatch
        System.out.println(lst.stream().anyMatch(x -> x > 4 & x > 2));
        System.out.println(lst.stream().allMatch(x -> x > 4));
        System.out.println(lst.stream().allMatch(x -> x > 0));

        // collect
        System.out.println(lst.stream().filter(s-> s >= 3).collect(Collectors.toList()));
        Object[] arr = lst.stream().filter(s -> s >= 3).toArray();
        for(var obj : arr)
            System.out.println(obj);

        // findAny
        Optional<Integer> firstExisted = lst.stream().findFirst();
        Optional<Integer> firstNotExisted = lst.stream().filter(x -> x > 100).findFirst();
        System.out.println(firstExisted.isEmpty());
        System.out.println(firstNotExisted.isEmpty());
    }
}
