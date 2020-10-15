package comparators;

import java.util.*;

public class CompareDemo {
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 3, 5, 2, 6, 3};

        // natural
        var naturalOrderComparator = Comparator.<Integer>naturalOrder();
        Arrays.sort(arr, naturalOrderComparator);
        print(arr);

        // reversed
        Arrays.sort(arr, naturalOrderComparator.reversed());
        print(arr);


        // null first
        Integer[] nullableArray = {5, 2, 3, 5, 2, 6, 3, null, 5, null};
        var comparator = Comparator.<Integer>naturalOrder();
        var nullFirstComparator = Comparator.nullsFirst(comparator);

        Arrays.sort(nullableArray, nullFirstComparator);
        print(nullableArray);

        // null last
        var nullLastComparator = Comparator.nullsLast(comparator);
        Arrays.sort(nullableArray, nullLastComparator);
        print(nullableArray);

        // lambda based
        Arrays.sort(arr, (a,b)->(b-a));
        print(arr);

        // thenComparing with reverseOrder addition
        List<Data> lst = new ArrayList<>();
        lst.add(Data.of(1, 60));
        lst.add(Data.of(1, 20));
        lst.add(Data.of(1, 10));
        lst.add(Data.of(2, 100));

        var effectiveComparator = Comparator.comparing(Data::getId).thenComparing(Data::getDist, Comparator.reverseOrder());
        lst.sort(effectiveComparator);
        System.out.println(lst);
    }

    static class Data {
        int id;
        int dist;

        public static Data of(int id, int dist) {
            var data = new Data();
            data.id = id;
            data.dist = dist;
            return data;
        }

        public int getId(){
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDist(){
            return this.dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", dist=" + dist +
                    '}';
        }
    }

    private static void print(Integer[] arr) {
        for(int i=0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
