package Task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(new BusyThread());
        thread1.start();
        thread1.join();

        System.out.println("Stopwatch thread has finished");
    }
}
