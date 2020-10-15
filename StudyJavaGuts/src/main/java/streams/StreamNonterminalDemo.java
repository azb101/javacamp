package streams;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamNonterminalDemo {
    public static void main(String[] args) {
        var lst = List.of(1,2,3);

        // filter
        var count = lst.stream().filter(s -> s > 2).count();
        System.out.println(count);
        System.out.println();
        // reduce
        var sumOfSquares = lst.stream().map(s -> s * s).reduce(0, (a,b)->(a+b));
        System.out.println(sumOfSquares);
        System.out.println();

        // flatMap
        var user1 = new User("admin", "1", "2", "3");
        var user2 = new User("foo", "6", "10");
        var users = List.of(user1, user2);
        users.stream().flatMap((user)-> user.phones.stream() ).forEach(System.out::println);
        System.out.println();

        // limit
        lst.stream().limit(2).forEach(System.out::println);
        System.out.println();

        // peek
        var peeked = lst.stream().peek((s)->System.out.println(s + "< "));
        peeked.count();
        System.out.println();
    }

    static class User {
        public String name;
        public List<String> phones = new ArrayList<>();

        public User(String name, String... phones) {
            this.name = name;
            this.phones = Arrays.asList(phones);
        }
    }
}
