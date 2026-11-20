/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentstoresystem;

/**
 *
 * @author Pun Magar Tiger
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          // Create our EmployeeManager object
        EmployeeManager manager = new EmployeeManager();

        // Read employee information from the file
        manager.loadEmployees();

        // Display all employees
        manager.displayEmployees();
    }
    
}
