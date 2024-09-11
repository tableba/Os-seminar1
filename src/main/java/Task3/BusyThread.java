package Task3;

public class BusyThread implements Runnable {
    @Override
    public void run(){

//      keep track of elapsed time
        int timeMs = 0;

        try {
        while (timeMs < 60000) {
                Thread.sleep(10);
            timeMs += 10;
            System.out.println("elapsed time: " + timeMs + " miliseconds");
        }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
