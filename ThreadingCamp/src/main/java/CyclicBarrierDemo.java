import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        var n = 8;
        var cyclycBarrier = new CyclicBarrier(n);
        var rand = new Random();

        for(int i=0; i < n; i++)
        {
            new Thread(()->{
               var name = Thread.currentThread().getName();
                System.out.println(name + " going to the bowling");

                try
                {
                    TimeUnit.SECONDS.sleep(rand.nextInt(10));
                    cyclycBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println(name + " choosing threads");

                try
                {
                    TimeUnit.SECONDS.sleep(rand.nextInt(10));
                    cyclycBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println(name + " start playing");
            }).start();
        }
    }
}
