
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
}
