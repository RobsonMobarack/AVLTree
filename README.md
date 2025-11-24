<p align="left">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Java_Swing-F89820?style=for-the-badge&logo=java&logoColor=white" alt="Java Swing">
  <img src="https://img.shields.io/badge/Data_Structure-AVL_Tree-blue?style=for-the-badge" alt="Data Structure: AVL Tree">
  <!-- <img src="https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge" alt="License: MIT"> -->
</p>

# AVL Tree Implementation with Java Swing GUI

This project is an academic implementation of an **AVL Tree (Adelson-Velsky and Landis)**, a self-balancing binary search tree (BST) data structure. The program is developed in Java and utilizes the **Swing library (JFrame)** to provide an interactive graphical user interface (GUI).

This repository was created to demonstrate skills in Java, advanced data structures, and GUI development, applying concepts learned in the **"Algorithms and Programming - Trees and Sorting"** university course.

![GUI SCREENSHOT](https://github.com/RobsonMobarack/AVLTree/blob/master/Assets/AVLTree.jpg)
_(Todo: Record a short GIF showing insertion, search, and a rotation happening!)_

---

## 🚀 About the Project

This project was a core assignment for the **"Trees and Sorting" unit** of my **"Algorithms and Programming"** course. The primary goal was to implement a functional AVL Tree capable of performing fundamental operations and handling self-balancing based on the official assignment criteria.

### Technical Requirements Met

The program strictly adheres to the challenge specifications:

- **Core Operations:** Full implementation of **insertion**, **deletion**, and **search** operations.
- **Keys:** The tree operates exclusively with **integer** keys.
- **Node Structure:** Each node stores only essential information: the key, the **balance factor**, and **pointers** to the left and right subtrees.
- **Data Input:** Operations are requested via keyboard input (console) or the GUI.
- **Rotation Feedback:** For every balancing operation (triggered by insertion or deletion), the console provides a detailed log of the **rotation performed** (Single/Double, Left/Right) and the key that caused the imbalance.
- **Visualization:** The state of the tree is displayed visually after each operation. As the output format was flexible, this requirement was met by implementing a **graphical user interface (GUI) using JFrame** to draw the tree in real-time.

---

## ✨ Features

Beyond the core requirements, this implementation includes:

- **Interactive GUI:** A `JFrame` window allows the user to easily insert, remove, and search for values using buttons and text fields.
- **Real-Time Visualization:** The tree is redrawn on the screen with every change, allowing the user to see the results of their actions and the effect of balancing rotations.
- **Console Reporting:** The console remains active to display the detailed rotation logs (as required by the assignment), serving as both a debugging and learning tool.

---

## 🛠️ Technologies Used

- **Java:** The core language for the project.
- **Java Swing (JFrame):** Used to build the graphical interface and visualize the tree.

---

## 🏃 How to Run

1.  Clone this repository:
    ```bash
    git clone https://github.com/RobsonMobarack/AVLTree
    ```
2.  Open the project in your favorite Java IDE (e.g., Eclipse, IntelliJ IDEA, or NetBeans).
3.  Locate the main class containing the `main` method (the class that initializes the `JFrame`).
4.  Run the file.
5.  Use the button and the input text on the interface to interact with the tree.

---

## 👨‍💻 Author

**Robson Mobarack**

- **LinkedIn:** [Robson Mobarack](https://linkedin.com/in/robson-mobarack)
- **GitHub:** [AVLTree](https://github.com/RobsonMobarack/AVLTree)
