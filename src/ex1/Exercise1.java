package ex1;

class FeedingActivity extends Thread {

    @Override
    public void run() {
        System.out.println("We have started feeding!");
    }
}

class CleaningActivity implements Runnable {

    @Override
    public void run(){
        System.out.println("We have started cleaning!");
    }
}
public class Exercise1 {
    public static void main(String[] args) {
        Thread feed = new FeedingActivity();
        Thread clean = new Thread(new CleaningActivity());

        clean.start();
        feed.start();

    }
}
