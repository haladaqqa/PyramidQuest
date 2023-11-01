# Pyramid Quest

## Project Overview

The Pyramid Treasure Hunt project is developed as part of a Computer Science assignment. It is a Java-based program designed to find a safe path through the mystical pyramid of X. The pyramid consists of interconnected hexagonal chambers with various characteristics, and the objective is to find a path from the entrance chamber to treasure chambers while adhering to specific constraints.

The key components of the project include implementing doubly linked lists, an extended stack abstract data type (ADT) using doubly linked lists, and a path-finding algorithm that utilizes a stack data structure.

## Project Structure

### DLStack

The `DLStack` class represents an extended stack ADT implemented using a doubly linked list. It includes the following methods:

- `push(T dataItem)`: Adds the given data item to the top of the stack.
- `pop()`: Removes and returns the data item at the top of the stack.
- `pop(int k)`: Removes and returns the k-th data item from the top of the stack.
- `peek()`: Returns the data item at the top of the stack without removing it.
- `isEmpty()`: Checks if the stack is empty.
- `size()`: Returns the number of data items in the stack.
- `getTop()`: Returns the top node of the stack.
- `toString()`: Overrides the default `toString` method to provide a readable representation of the stack.

### FindPath

The `FindPath` class is responsible for computing a path through the pyramid. It uses a stack to keep track of the path and follows a specific algorithm to navigate through the chambers. The main methods in this class are:

- `path()`: Calculates a path from the entrance to treasure chambers, satisfying predefined constraints.
- `getMap()`: Returns the pyramid map.
- `isDim(Chamber currentChamber)`: Checks if a chamber is dim (meets specific criteria).
- `bestChamber(Chamber currentChamber)`: Selects the best chamber to move to from the current chamber, considering certain constraints.

## Getting Started

1. Compile the Java code:

   ```bash
   javac DLStack.java FindPath.java
