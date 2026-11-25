
package departmentstoresystem;

import java.util.ArrayList;

public class BinarySearch {

    // Recursive method to search for an employee
    public static int search(ArrayList<Employee> employees,
            String name, int left, int right) {

        // Stop if the employee is not found
        if (left > right) {
            return -1;
        }

        // Find the middle position
        int middle = (left + right) / 2;

        // Compare the middle employee with the searched name
        String middleName = employees.get(middle).getName();

        int result = middleName.compareToIgnoreCase(name);

        // Employee found
        if (result == 0) {
            return middle;
        }

        // Search the left half
        if (result > 0) {
            return search(employees, name, left, middle - 1);
        }

        // Search the right half
        return search(employees, name, middle + 1, right);
    }
}
