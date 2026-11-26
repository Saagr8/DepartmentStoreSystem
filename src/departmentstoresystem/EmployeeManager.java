
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

    // Sort employees and display the first 20
    public void sortEmployees() {

        employees = MergeSort.sort(employees);

        System.out.println("\nFirst 20 Employees (A-Z)");
        System.out.println("-------------------------");

        int limit = Math.min(20, employees.size());

        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }

    // Search for an employee by name
    public void searchEmployee(String name) {

        // Check if the name is empty
        name = name.trim();

        if (name.isEmpty()) {
            System.out.println("Please enter an employee name!");
            return;
        }

        // Sort employees before searching
        employees = MergeSort.sort(employees);

        // Search using recursive Binary Search
        int index = BinarySearch.search(
                employees, name, 0, employees.size() - 1);

        // Check if employee was found
        if (index == -1) {

            System.out.println("Employee not found!");

        } else {

            Employee employee = employees.get(index);

            System.out.println("\nEmployee Found!");
            System.out.println("Name: " + employee.getName());
            System.out.println("Manager Type: " + employee.getManagerType());
            System.out.println("Department: " + employee.getDepartment());
        }
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

    // Display employees added by the user
    public void displayNewEmployees() {

        System.out.println("\nNewly Added Employees");
        System.out.println("-------------------------");

        if (newEmployees.isEmpty()) {
            System.out.println("No new employees added.");
            return;
        }

        for (int i = 0; i < newEmployees.size(); i++) {

            System.out.println((i + 1) + ". "
                    + newEmployees.get(i));
        }
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
