import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account
{
    Lock lock = new ReentrantLock();
    Condition enoughMoney = lock.newCondition();
    Condition enoughRoom = lock.newCondition();

    public String name;
    int balance = 0;
    Bank bank;

    public Account(Bank bank, int b, String name)
    {
        this.bank = bank;
        this.balance = b;
        this.name = name;
    }

    void deposit(int money) throws InterruptedException {
        long l = balance + money;

        while (l > Integer.MAX_VALUE)
            enoughRoom.await();

        balance += money;
        enoughMoney.signal();
    }

    void withdraw(int money) throws InterruptedException {
        while (balance - money < 0) {
            //System.out.println(this.name);
            enoughMoney.await();
        }

        balance -= money;
        enoughRoom.signal();
    }

    void lock()
    {
        lock.lock();
    }

    void unlock()
    {
        lock.unlock();
    }
}