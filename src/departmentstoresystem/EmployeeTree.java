
package departmentstoresystem;

import java.util.Queue;
import java.util.LinkedList;

public class EmployeeTree {

    // Root is the first node of our tree
    private EmployeeNode root;

    // Method to insert employees into the tree
    public void insert(Employee employee) {

        EmployeeNode newNode = new EmployeeNode(employee);

        // If the tree is empty, make this the root
        if (root == null) {
            root = newNode;
            return;
        }

        // Queue to check nodes level by level
        Queue<EmployeeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            EmployeeNode current = queue.remove();

            // Check the left side first
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            // Then check the right side
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }

    }
    
    // Display employees level by level
    public void displayLevelOrder() {

        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            System.out.println("\nLevel " + level + ":");

            for (int i = 0; i < levelSize; i++) {

                EmployeeNode current = queue.remove();

                System.out.println(current.employee);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            level++;
        }
    }
    

    // Count the total number of nodes
    public int countNodes() {

        if (root == null) {
            return 0;
        }

        int count = 0;

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            EmployeeNode current = queue.remove();
            count++;

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return count;
    }

    // Calculate the height of the tree
    public int getHeight() {

        if (root == null) {
            return 0;
        }

        int height = 0;

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                EmployeeNode current = queue.remove();

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            height++;
        }

        return height;
    }

}
