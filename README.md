# Department Store Employee Management System

## About the Project

This is my Java project for the Algorithms and Constructs assignment.

I chose a Department Store as my organisation. The program helps to manage employee records using a simple terminal menu.

The program reads employee information from a text file. Each employee has a name, manager type and department.

## Main Features

1. **Sort Employees** — Sorts employees alphabetically using recursive Merge Sort and displays the first 20 records.
2. **Search Employee** — Searches for an employee by name using recursive Binary Search and displays their information.
3. **Add New Employee** — Allows the user to enter a name, choose a manager type and select an existing department. Invalid selections are rejected.
4. **Employee Binary Tree** — Creates a binary tree using level-order insertion and displays the employees, total nodes and tree height.
5. **Exit** — Closes the program.

## Algorithms and Data Structures

### Merge Sort
I used recursive Merge Sort to sort employee names alphabetically.

I chose it because it is efficient for larger lists compared with Bubble Sort. It also has a reliable time complexity of O(n log n).

### Binary Search
I used recursive Binary Search to find employees by their names.

I chose it because the employee list is sorted before searching. It is faster than Linear Search for larger sorted lists.

### Binary Tree
I used a binary tree to organise employee records.

Each node contains employee information and can have a left and right child. I used a Queue to insert employees level by level, filling the left side before the right side.

The tree height is measured by the number of levels.

### ArrayList and Enum
I used an ArrayList to store employees because new records can be added easily.

I also used an Enum to define the menu options and handle the user's menu choice.

## MVC Structure

I organised my Java project using Model-View-Controller (MVC).

- **Model:** Stores employee information and handles sorting, searching and binary tree operations.
- **View:** ConsoleView.java displays the menu and employee results.
- **Controller:** StoreController.java handles user choices and connects the Model and View.
- **Main.java:** Starts the program.

## How to Run the Program

1. Download or clone this repository.
2. Open the project in Apache NetBeans.
3. Make sure Java is installed.
4. Keep Applicants_Form.txt in the main project folder.
5. Run Main.java.
6. Select an option from the terminal menu.

## Employee Data

The program starts with 46 employee records from Applicants_Form.txt.

The file contains three fields: Name, Manager Type and Department.

New employees are stored in the program's memory. They are not saved back to the text file.

## Results

With the original 46 employee records:

- Merge Sort displays the first 20 employees alphabetically.
- Binary Search can find employees by name.
- New employees can be added after input validation.
- The binary tree contains 46 nodes and has 6 levels.

## Future Improvements

In the future, I could improve this project by saving new employee records to the text file, allowing employee details to be updated or deleted, and improving how the employee hierarchy is displayed.
