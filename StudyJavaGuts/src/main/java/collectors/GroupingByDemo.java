package collectors;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class GroupingByDemo {
    public static void main(String[] args) {

        var lst = new ArrayList<Data>();
        lst.add(new Data(1, "orange"));
        lst.add(new Data(1, "orange"));
        lst.add(new Data(2, "orange"));
        lst.add(new Data(1, "green"));
        lst.add(new Data(5, "green"));
        lst.add(new Data(2, "maroon"));

        // simple by one field
        var temp = lst.stream().collect(groupingBy(Data::getType));
        System.out.println(temp.getClass());
        System.out.println(temp);
        System.out.println();

        // by several fields
        System.out.println(lst.stream().collect(groupingBy(data -> Pair.of(data.getType(), data.getId()))));
        System.out.println();

        // nested grouping
        System.out.println(lst.stream().collect(groupingBy(Data::getType,  groupingBy(Data::getId))));

        // group by type and take item with maxId (only item)
        System.out.println(lst.stream().collect(groupingBy(Data::getType,  maxBy(comparing(Data::getId)))));
    }

    static class Data {
        private int id;
        private String type;

        public Data(int id, String type) {
            this.id = id;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
