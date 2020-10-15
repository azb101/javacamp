import java.util.Random;

class Bank {

    Account[] accounts = new Account[]{
            new Account(this, 1000, "a"),
            new Account(this, 1000, "b"),
            new Account(this, 1000, "c"),
            new Account(this, 1000, "d")
    };
    Random rand = new Random();

    public void run() throws InterruptedException {

        new Thread(()-> this.transfer(0,1)).start();
        new Thread(()-> this.transfer(1,2)).start();
        new Thread(()-> this.transfer(2,3)).start();
        new Thread(()-> this.transfer(3,0)).start();
    }

    private void transfer(int a, int b)
    {
        while(true)
        {
            var acc1 = accounts[a];
            var acc2 = accounts[b];
            if(acc1 == acc2)
                continue;

            transfer(acc1, acc2, rand.nextInt(100));
        }
    };

    void transfer(Account sourceAccount, Account destinationAccount, int amount) {
        try {
            System.out.println(Thread.currentThread().getName() + ": Transfer from '" + sourceAccount.name + "' to '" + destinationAccount.name + "' done with amount: " + amount + " [" + sourceAccount.balance + "," + destinationAccount.balance + "] in process");

            sourceAccount.lock();
            destinationAccount.lock();

            try
            {
                sourceAccount.withdraw(amount);
                destinationAccount.deposit(amount);
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            finally {
                sourceAccount.unlock();
                destinationAccount.unlock();
            }
        }
        catch (IllegalArgumentException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
