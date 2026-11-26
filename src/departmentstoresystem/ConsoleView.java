
package departmentstoresystem;

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
}
