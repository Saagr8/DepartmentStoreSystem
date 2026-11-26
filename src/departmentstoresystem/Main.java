/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentstoresystem;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Pun Magar Tiger
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          // Create EmployeeManager
        EmployeeManager manager = new EmployeeManager();

        // Load employee records
        manager.loadEmployees();
        // Create Scanner to read user input
Scanner input = new Scanner(System.in);

// Control whether the menu should keep running
boolean running = true;

while (running) {

        // Display main menu
        System.out.println();
        System.out.println("DEPARTMENT STORE EMPLOYEE SYSTEM");
        System.out.println("--------------------------------");

        // Display all options from our Enum
        for (MenuOption option : MenuOption.values()) {

            System.out.println(option.getNumber()
                    + ". " + option.getDescription());
    }
        
        // Read the user's menu choice

        System.out.print("Enter your choice: ");

        // Check if the user entered a number
        if (input.hasNextInt()) {

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("SORT selected");
                    manager.sortEmployees();
                    break;

             
case 2:
    System.out.println("SEARCH selected");

    // Ask the user for employee name
    System.out.print("Enter employee name: ");
    String name = input.nextLine();

    // Search for the employee
    manager.searchEmployee(name);

    break;


           
case 3: {

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
        manager.displayNewEmployees();
    } else {
        System.out.println("Could not add employee!");
    }

    break;
}


               
case 4:
    System.out.println("BINARY TREE selected");

    // Create binary tree from our employee list
    EmployeeTree tree = manager.createEmployeeTree();

    // Display employees level by level
    tree.displayLevelOrder();

    // Display total nodes and height
    System.out.println("\nBinary Tree Information");
    System.out.println("------------------------");
    System.out.println("Total Nodes: " + tree.countNodes());
    System.out.println("Tree Height: " + tree.getHeight());

    break;


                case 5:
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