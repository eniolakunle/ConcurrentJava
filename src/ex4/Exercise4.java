package ex4;

import java.util.concurrent.atomic.AtomicReference;

public class Exercise4 {

    static class Dinosaur {
        private AtomicReference<String> status;

        public Dinosaur(String status) {
            this.status = new AtomicReference<>(status);
        }

        public String getStatus() {
            return status.get();
        }

        public void setStatus(String status) {
            this.status.set(status);
        }
    }

    static class DinosaurStatusUpdater implements Runnable {
        private Dinosaur dinosaur;
        private String newStatus;

        public DinosaurStatusUpdater(Dinosaur dinosaur,
                                     String newStatus) {
            this.dinosaur = dinosaur;
            this.newStatus = newStatus;
        }

        @Override
        public void run() {
            dinosaur.setStatus(newStatus);
            System.out.println("Dinosaur status set to: "
                    + dinosaur.getStatus());
        }
    }


    public static void main(String[] args) {
            Dinosaur dinosaur = new Dinosaur("Healthy");
            Thread updater1 = new Thread(new
                    DinosaurStatusUpdater(dinosaur, "Feeding"));
            Thread updater2 = new Thread(new
                    DinosaurStatusUpdater(dinosaur, "Resting"));
            updater1.start();
            updater2.start();

    }
}

