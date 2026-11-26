
package departmentstoresystem;

public class EmployeeNode {

    // Store employee information
    Employee employee;

    // Left and right child nodes
    EmployeeNode left;
    EmployeeNode right;

    // Constructor
    public EmployeeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }
}
