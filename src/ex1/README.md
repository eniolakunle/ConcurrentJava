# 🧵 Exercise 1: Java Threading

***Create threads***: Create two classes, FeedingActivity and CleaningActivity. Make
FeedingActivity extend the Thread class and CleaningActivity implement the
Runnable interface. In both, override the run method to print out the activity’s name and
a message indicating that the activity is happening.

## Overview 📜
This project demonstrates basic multithreading in Java by creating two classes: `FeedingActivity` and `CleaningActivity`.
- **FeedingActivity** extends the `Thread` class.
- **CleaningActivity** implements the `Runnable` interface.

In both classes, the `run` method is overridden to print the activity's name and a message indicating that the activity is happening.

## Project Structure 🗂️
- `FeedingActivity.java` – Extends the `Thread` class and prints a message. 🐦
- `CleaningActivity.java` – Implements `Runnable` interface and prints a message. 🧽
- `Main.java` – Contains the main method that initiates both threads. 🚀


