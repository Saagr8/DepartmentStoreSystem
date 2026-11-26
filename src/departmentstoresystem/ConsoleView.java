
package departmentstoresystem;
import java.util.ArrayList;

public class ConsoleView {

    // Display the main menu
    public void showMenu() {

        System.out.println();
        System.out.println("DEPARTMENT STORE EMPLOYEE SYSTEM");
        System.out.println("--------------------------------");

        // Display menu options using Enum
        for (MenuOption option : MenuOption.values()) {

            System.out.println(option.getNumber()
                    + ". " + option.getDescription());
        }
    }

    // Display binary tree results
    public void showBinaryTree(EmployeeTree tree) {

        System.out.println("BINARY TREE selected");

        // Display employees level by level
        tree.displayLevelOrder();

        // Display tree information
        System.out.println("\nBinary Tree Information");
        System.out.println("------------------------");
        System.out.println("Total Nodes: " + tree.countNodes());
        System.out.println("Tree Height: " + tree.getHeight());
    }

    // Display the first 20 sorted employees
    public void showSortedEmployees(ArrayList<Employee> employees) {

        System.out.println("\nFirst 20 Employees (A-Z)");
        System.out.println("-------------------------");

        // Display maximum 20 employees
        int limit = Math.min(20, employees.size());

        for (int i = 0; i < limit; i++) {

            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }


    // Display employee search result
    public void showSearchResult(Employee employee) {

        if (employee == null) {
            System.out.println("Employee not found!");
        } else {

            System.out.println("\nEmployee Found!");
            System.out.println("Name: " + employee.getName());
            System.out.println("Manager Type: "
                    + employee.getManagerType());
            System.out.println("Department: "
                    + employee.getDepartment());
        }
    }

    // Display newly added employees
    public void showNewEmployees(ArrayList<Employee> employees) {

        System.out.println("\nNewly Added Employees");
        System.out.println("-------------------------");

        if (employees.isEmpty()) {
            System.out.println("No new employees added.");
            return;
        }

        for (int i = 0; i < employees.size(); i++) {

            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }
   
}
