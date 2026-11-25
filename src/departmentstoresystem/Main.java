/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentstoresystem;
import java.util.Scanner;

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


                case 3:
                    System.out.println("ADD RECORDS selected");
                    break;

                case 4:
                    System.out.println("BINARY TREE selected");
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