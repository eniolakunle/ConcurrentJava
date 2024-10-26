package ex2;

public class Exercise2 {

    public static void main(String[] args) {
        ParkOperations park = new ParkOperations();
        park.feeding.start();
        park.cleaning.start();

    }

    static class ParkOperations {

        final Thread feeding = new Thread(() -> {
            try {
                System.out.println("Feeding time!");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        final Thread cleaning = new Thread(() -> {
            try {
                //wait for feeding to finish before continuing.
                feeding.join();
                System.out.println("CLeaning Up!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


    }
}
