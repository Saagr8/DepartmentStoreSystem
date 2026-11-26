
package departmentstoresystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    // List to store all employees
    private ArrayList<Employee> employees = new ArrayList<>();
    // Store employees added by the user
private ArrayList<Employee> newEmployees = new ArrayList<>();

    // Method to read employees from the file
    public void loadEmployees() {

        try {
            File file = new File("Applicants_Form.txt");
            Scanner reader = new Scanner(file);

            // Skip the first line (column headings)
            reader.nextLine();

            // Read each employee
            while (reader.hasNextLine()) {

                String line = reader.nextLine();

                // Separate the information using commas
                String[] details = line.split(",");

                if (details.length == 3) {

                    String name = details[0].trim();
                    String managerType = details[1].trim();
                    String department = details[2].trim();

                    // Create a new employee
                    Employee employee = new Employee(
                            name, managerType, department);

                    // Add employee to our list
                    employees.add(employee);
                }
            }

            reader.close();

            System.out.println("File read successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // Method to display employees
    public void displayEmployees() {

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("Total employees: " + employees.size());
    }

    // Sort employees and return the sorted list
    public ArrayList<Employee> sortEmployees() {

        // Sort employees using Merge Sort
        employees = MergeSort.sort(employees);

        // Return the sorted employee list
        return employees;
    }
    
    // Search for an employee by name
    public Employee searchEmployee(String name) {

        // Remove extra spaces
        name = name.trim();

        // Check if the name is empty
        if (name.isEmpty()) {
            return null;
        }

        // Sort employees before searching
        employees = MergeSort.sort(employees);

        // Search using Binary Search
        int index = BinarySearch.search(
                employees, name, 0, employees.size() - 1);

        // Employee not found
        if (index == -1) {
            return null;
        }

        // Return the employee we found
        return employees.get(index);
    }


    // Get available manager types
    public ArrayList<String> getManagerTypes() {

        ArrayList<String> types = new ArrayList<>();

        for (Employee employee : employees) {

            if (!types.contains(employee.getManagerType())) {
                types.add(employee.getManagerType());
            }
        }

        return types;
    }

    // Get existing departments
    public ArrayList<String> getDepartments()
    {
        

        ArrayList<String> departments = new ArrayList<>();

        for (Employee employee : employees) {

            if (!departments.contains(employee.getDepartment())) {
                departments.add(employee.getDepartment());
            }
        }

        return departments;
    }

    // Add a new employee
    public boolean addEmployee(String name, String managerType,
            String department) {

        // Check employee name
        if (name.trim().isEmpty()) {
            return false;
        }

        // Check manager type
        if (!getManagerTypes().contains(managerType)) {
            return false;
        }

        // Check department
        if (!getDepartments().contains(department)) {
            return false;
        }

        // Create employee object
        Employee employee = new Employee(
                name.trim(), managerType, department);

        // Add employee to our main list
        employees.add(employee);

        // Keep the list sorted
        employees = MergeSort.sort(employees);

        // Store the newly added employee
        newEmployees.add(employee);

        return true;
    }


    // Return the newly added employees
    public ArrayList<Employee> getNewEmployees() {

        return new ArrayList<>(newEmployees);
    }

  

    // Create a binary tree using our employee list
    public EmployeeTree createEmployeeTree() {

        EmployeeTree tree = new EmployeeTree();

        // Insert all employees into the tree
        for (Employee employee : employees) {
            tree.insert(employee);
        }

        return tree;
    }

}