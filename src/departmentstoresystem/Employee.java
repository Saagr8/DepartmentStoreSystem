/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentstoresystem;

/**
 *
 * @author Pun Magar Tiger 
 */
public class Employee {
    // Variables to store employee details
    private String name;
    private String managerType;
    private String department;

    // Constructor to create an employee
    public Employee(String name, String managerType, String department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    // Get employee name
    public String getName() {
        return name;
    }

    // Get manager type
    public String getManagerType() {
        return managerType;
    }

    // Get department
    public String getDepartment() {
        return department;
    }

    // Display employee information
    @Override
    public String toString() {
        return name + " | " + managerType + " | " + department;
    }
    
}
