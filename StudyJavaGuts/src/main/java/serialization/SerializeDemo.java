package serialization;

import java.io.*;

public class SerializeDemo {
    static final String path = "temp.txt";

    public static void main(String[] args) {
        var data = new Data();
        data.id = 11;
        data.dist = 102;

        System.out.println("New object: " + data);

        serialize(data, path);

        System.out.println("Deserialized: " + deserialize(path));
    }

    private static Data deserialize(String path) {
        try(var fileInputStream = new FileInputStream(path);
            var objectInputStream = new ObjectInputStream(fileInputStream)) {

            return (Data)objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void serialize(Data data, String path) {
        try(var fileOutputStream = new FileOutputStream(path);
            var objectStream = new ObjectOutputStream(fileOutputStream)) {
            objectStream.writeObject(data);

            System.out.println("Serialized");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Data implements Serializable {
        int id;
        int dist;

        private static final long serialVersionUID = 1235L;

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", dist=" + dist +
                    '}';
        }
    }
}
