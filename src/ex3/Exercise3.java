package ex3;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercise3 {

    static Callable<Boolean> taskCreator(String taskName, Long delay) {
        return () -> {
            try {
                System.out.println("Thread: " + Thread.currentThread().threadId() + " is " + taskName);
                Thread.sleep(delay);
                System.out.println("Thread: " + Thread.currentThread().threadId() + " is done " + taskName);
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) {
        TaskAssigner assigner = new TaskAssigner();
        List<Callable<Boolean>> tasks = List.of(
                Exercise3.taskCreator("eating.", 4000L),
                Exercise3.taskCreator("flying.", 10000L),
                Exercise3.taskCreator("digging a hole.", 1500L),
                Exercise3.taskCreator("treating a patient.", 8000L),
                Exercise3.taskCreator("charging their phone.", 2500L)
        );
        assigner.assignTasks(tasks);
    }

    static class TaskAssigner {
        // 3 employees represented as threads.
        private final ExecutorService employees = Executors.newFixedThreadPool(3);

        private void assignTasks(List<Callable<Boolean>> tasks) {

            boolean allDone = false;
            System.out.println("Distributing tasks...");

            try {
                List<Future<Boolean>> taskFutures = employees.invokeAll(tasks);
                do {
                    // run this loop until all tasks are finished
                    allDone = taskFutures.stream().allMatch(Future::isDone);
                } while (!allDone);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Tasks complete!");
                employees.shutdown();
            }

        }
    }
}
