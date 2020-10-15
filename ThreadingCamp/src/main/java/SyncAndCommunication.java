import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class SyncAndCommunication {
    public static void main(String[] args) throws InterruptedException {

        var b = new Bank();
        b.run();
    }
}
