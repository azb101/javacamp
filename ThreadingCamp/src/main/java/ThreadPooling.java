import java.io.IOException;
import java.util.concurrent.*;

public class ThreadPooling {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        //var execSvc = Executors.newSingleThreadExecutor();
        // var execSvc = Executors.newFixedThreadPool(10);
        var execSvc = Executors.newWorkStealingPool(2);  // steal some work of other threads

        var runnable1 = new Runnable(){

            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Runnable1 task");
            }
        };

        var callable2 = new Callable<Integer>(){

            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Callable1 task");
                return Integer.MIN_VALUE;
            }
        };

        Callable<String> callable3 = () -> {
            TimeUnit.SECONDS.sleep(3);
            return "Callable3 result";
        };

        var f1 = execSvc.submit(runnable1);
        var f2 = execSvc.submit(callable2);
        var f3 = execSvc.submit(callable3);

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());

        System.out.println("done");

        execSvc.shutdown();
        // execSvc.shutdownNow();
    }
}
