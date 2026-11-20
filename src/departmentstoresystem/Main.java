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
        // Create our first employee
        Employee emp1 = new Employee(
                "Benjamin Hill", "Head Manager", "Operations");

        // Create our second employee
        Employee emp2 = new Employee(
                "John Smith", "Senior Manager", "Finance");

        // Display employee information
        System.out.println("Department Store Employees");
        System.out.println("--------------------------");

        System.out.println(emp1);
        System.out.println(emp2);
    }
    
}
