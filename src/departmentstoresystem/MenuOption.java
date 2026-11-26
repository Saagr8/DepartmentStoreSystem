
package departmentstoresystem;

public enum MenuOption {

    SORT(1, "Sort Employees"),
    SEARCH(2, "Search Employee"),
    ADD_RECORDS(3, "Add New Employee"),
    BINARY_TREE(4, "Display Employee Binary Tree"),
    EXIT(5, "Exit");

    private final int number;
    private final String description;

    // Constructor
    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }

    // Get menu number
    public int getNumber() {
        return number;
    }

    // Get menu description
    public String getDescription() {
        return description;
    }
    
    // Find a menu option using its number
    public static MenuOption fromNumber(int number) {

        for (MenuOption option : MenuOption.values()) {

            if (option.getNumber() == number) {
                return option;
            }
        }

        return null;
    }

}
