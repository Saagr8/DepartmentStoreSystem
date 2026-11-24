
package departmentstoresystem;

import java.util.ArrayList;

public class MergeSort {

    // Recursive method to sort employees
    public static ArrayList<Employee> sort(ArrayList<Employee> employees) {

        // Stop recursion when the list has 0 or 1 employee
        if (employees.size() <= 1) {
            return employees;
        }

        // Find the middle of the list
        int middle = employees.size() / 2;

        // Divide the list into two parts
        ArrayList<Employee> left = new ArrayList<>(
                employees.subList(0, middle));

        ArrayList<Employee> right = new ArrayList<>(
                employees.subList(middle, employees.size()));

        // Sort both parts using recursion
        left = sort(left);
        right = sort(right);

        // Merge both sorted parts
        return merge(left, right);
    }

    // Method to combine two sorted lists
    private static ArrayList<Employee> merge(
            ArrayList<Employee> left, ArrayList<Employee> right) {

        ArrayList<Employee> sorted = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Compare employee names from both lists
        while (i < left.size() && j < right.size()) {

            String leftName = left.get(i).getName();
            String rightName = right.get(j).getName();

            if (leftName.compareToIgnoreCase(rightName) <= 0) {
                sorted.add(left.get(i));
                i++;
            } else {
                sorted.add(right.get(j));
                j++;
            }
        }

        // Add any remaining employees
        while (i < left.size()) {
            sorted.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            sorted.add(right.get(j));
            j++;
        }

        return sorted;
 
    }
}