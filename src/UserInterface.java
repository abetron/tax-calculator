import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    String command;
    TaxCalculator calc = new TaxCalculator();

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Hello, welcome to the Abe Tax Calculator!");
        System.out.println("-----------------------------------------");
        System.out.println("Select one of the following by choosing the number and pressing enter.");
        System.out.println("1. Calculate Total Taxes Owed");
        System.out.println("2. Calculate Remaining Tax Obligation. (Must know current taxes withheld)");
        System.out.println("3. Calculate marginal tax bracket");
        System.out.println("4. Calculate effective tax rate");
        System.out.println("Type 'exit' to exit the program");
        System.out.println();

        while (true) {
            System.out.print("Select an option: ");
            command = scanner.nextLine();

            if (command.equals("exit")) {
                System.exit(0);
            }

            if (Integer.parseInt(command) == 1) {
                System.out.print("Enter your gross annual salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                calc.setSalary(salary);
                System.out.println("Total taxes owed: " + String.format("%,.2f", calc.calculateTotalTax()));
            }

            if (Integer.parseInt(command) == 2) {
                System.out.print("Enter your gross annual salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                calc.setSalary(salary);
                System.out.print("Enter taxes paid already (taxes withholding): ");
                double taxWithholding = Double.parseDouble(scanner.nextLine());
                calc.setTaxWithholding(taxWithholding);
                System.out.println("Taxes still to be paid " + (calc.calculateTotalTax() - calc.getTaxWithholding()));
            }

            if (Integer.parseInt(command) == 4) {
                System.out.print("Enter your gross annual salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                calc.setSalary(salary);
                System.out.println("Effective tax rate: " + String.format("%,.2f", calc.calculateEffectiveTaxRate()) + "%.");
            }

            System.out.println();
        }
    }
}
