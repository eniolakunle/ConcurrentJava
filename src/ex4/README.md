# 🦖 Exercise 5: Solving Race Conditions

Solve race conditions in the following code snippet. updater1 and updater2 both are
trying to update the status of the same dinosaur object. Since they run concurrently, it might
lead to inconsistent outputs. Use the synchronized keyword or AtomicReference to
prevent data inconsistency: [Click Here For Code Snippet](#code-in-question)

## Overview 📜
In this project, we solve race conditions in a Java program where two threads, `updater1` and `updater2`, attempt to update the status of the same `Dinosaur` object concurrently. Without synchronization, this concurrent access can lead to data inconsistencies.

This guide provides the following solution:
1. Using `AtomicReference` to manage the `Dinosaur` object atomically, which is thread-safe by design.

## Project Structure 🗂️
- `Dinosaur` – A simple class representing a dinosaur with a status field managed with `AtomicReference` . 🦕


## Code In Question❓

```
class Dinosaur {
    private String status;

    public Dinosaur(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class DinosaurStatusUpdater implements Runnable {
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

public class Main {
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
```