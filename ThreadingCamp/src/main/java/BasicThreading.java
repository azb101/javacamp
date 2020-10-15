import java.io.IOException;

public class BasicThreading {
    public static void main(String[] args) throws IOException {
        var t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from : " + Thread.currentThread().getName() + " thread");
            }
        });

        t1.setName("myown");
        t1.setUncaughtExceptionHandler(new ueh());
        System.out.println(t1.getPriority());
        t1.start();

        var t2 = new Thread(()-> System.out.println("Hello from labmdad thread"));
        t2.start();

        var t3 = new Runnable() {
            @Override
            public void run() {

            }
        };

        var run = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is working");
            }
        };

        run.run();

        var t5 = new Thread(run);
        t5.setName("abuse");
        // t5.run(); will run in same thread
        t5.start();
    }

    class MyThread extends Thread
    {
        @Override
        public void run() {

        }
    }

    static class ueh implements Thread.UncaughtExceptionHandler
    {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            e.printStackTrace();
        }
    }

}
