# 🛠️ Exercise 3: Java Task Assigner

Use ExecutorService: Create a TaskAssigner class where you use ExecutorService
to assign tasks to employees. Tasks could be represented as Runnable or Callable objects,
and employees could be represented as threads

## Overview 📜
This project demonstrates task assignment in Java using the `ExecutorService`. Here, we create a `TaskAssigner` class that uses `ExecutorService` to manage tasks represented as `Runnable` or `Callable` objects. Each task is assigned to an employee, represented as a thread.

## Project Structure 🗂️
- `TaskAssigner` – Manages task distribution using `ExecutorService`. 🚀
- `taskCreator` – Defines a `Callable` task to simulate tasks with results. 📊
