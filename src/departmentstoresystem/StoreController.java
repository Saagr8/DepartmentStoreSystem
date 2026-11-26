
package departmentstoresystem;

import java.util.Scanner;
import java.util.ArrayList;

public class StoreController {

    // Method to start our program
    public void start() {

        // Create EmployeeManager
        EmployeeManager manager = new EmployeeManager();

        // Load employees from the text file
        manager.loadEmployees();

        // Create our View
        ConsoleView view = new ConsoleView();

        // Read user input
        Scanner input = new Scanner(System.in);

        // Keep the program running
        boolean running = true;
        while (running) {
    view.showMenu();

    
        
        // Read the user's menu choice

        System.out.print("Enter your choice: ");

        // Check if the user entered a number
        if (input.hasNextInt()) {

            
int choice = input.nextInt();
input.nextLine();

// Convert the number to a MenuOption
MenuOption selectedOption = MenuOption.fromNumber(choice);

// Check for invalid menu choices
if (selectedOption == null) {
    System.out.println("Invalid option!");
    continue;
}

// Use Enum to handle menu choices
switch (selectedOption) {


case SORT:
    System.out.println("SORT selected");

    ArrayList<Employee> sortedEmployees = manager.sortEmployees();

    view.showSortedEmployees(sortedEmployees);

    break;

             

case SEARCH:
    System.out.println("SEARCH selected");

    // Ask for employee name
    System.out.print("Enter employee name: ");
    String name = input.nextLine();

    // Check if name is empty
    if (name.trim().isEmpty()) {
        System.out.println("Please enter an employee name!");
        break;
    }

    // Search for the employee
    Employee foundEmployee = manager.searchEmployee(name);

    // Ask View to display the result
    view.showSearchResult(foundEmployee);

    break;



           
case ADD_RECORDS: {

    System.out.println("ADD RECORDS selected");

    // Ask for employee name
    System.out.print("Enter employee name: ");
    String employeeName = input.nextLine().trim();

    // Check if name is empty
    if (employeeName.isEmpty()) {
        System.out.println("Name cannot be empty!");
        break;
    }

    // Get available manager types
    ArrayList<String> managerTypes = manager.getManagerTypes();

    System.out.println("\nChoose Manager Type:");

    for (int i = 0; i < managerTypes.size(); i++) {
        System.out.println((i + 1) + ". " + managerTypes.get(i));
    }

    System.out.print("Enter manager type number: ");

    // Check manager type input
    if (!input.hasNextInt()) {
        System.out.println("Please enter a number!");
        input.nextLine();
        break;
    }

    int managerChoice = input.nextInt();
    input.nextLine();

    if (managerChoice < 1 || managerChoice > managerTypes.size()) {
        System.out.println("Invalid manager type!");
        break;
    }

    String selectedManager = managerTypes.get(managerChoice - 1);

    // Get available departments
    ArrayList<String> departments = manager.getDepartments();

    System.out.println("\nChoose Department:");

    for (int i = 0; i < departments.size(); i++) {
        System.out.println((i + 1) + ". " + departments.get(i));
    }

    System.out.print("Enter department number: ");

    // Check department input
    if (!input.hasNextInt()) {
        System.out.println("Please enter a number!");
        input.nextLine();
        break;
    }

    int departmentChoice = input.nextInt();
    input.nextLine();

    if (departmentChoice < 1 || departmentChoice > departments.size()) {
        System.out.println("Invalid department!");
        break;
    }

    String selectedDepartment = departments.get(departmentChoice - 1);

    // Add the employee
    boolean added = manager.addEmployee(
            employeeName, selectedManager, selectedDepartment);

   
if (added) {
    System.out.println("\nEmployee added successfully!");

    // Ask View to display new employees
    view.showNewEmployees(manager.getNewEmployees());

} else {
    System.out.println("Could not add employee!");
}


    break;
}


               

case BINARY_TREE:

    // Create binary tree
    EmployeeTree tree = manager.createEmployeeTree();

    // Ask the View to display the tree
    view.showBinaryTree(tree);

    break;



                case EXIT:
                    System.out.println("Goodbye!");
                      running = false;
                      break;
               

                default:
                    System.out.println("Invalid option!");
            }

        } else {
    System.out.println("Please enter a number!");
    input.nextLine();
}

    
  }
}
}

