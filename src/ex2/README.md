# 🌳 Exercise 2: Java Threading with `sleep()` and `join()`

Use sleep() and join(): Create a ParkOperations class with two threads, one for feeding
and another for cleaning. Start both threads and then use sleep() to simulate a time delay
for the feeding activity. Use join() to ensure cleaning only happens after feeding is complete

## Overview 📜
In this project, we will create a `ParkOperations` class that has two threads: one for feeding animals and another for cleaning the park.
- The feeding thread will simulate a delay using `sleep()` to represent the time taken to feed the animals.
- The cleaning thread will use `join()` to wait until feeding is complete before starting.

## Project Structure 🗂️
- `ParkOperations` – Contains the two thread variable that are managed using `sleep()` and `join()`. 🚀

