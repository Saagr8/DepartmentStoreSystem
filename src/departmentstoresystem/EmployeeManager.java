
package departmentstoresystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    // List to store all employees
    private ArrayList<Employee> employees = new ArrayList<>();

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

}
