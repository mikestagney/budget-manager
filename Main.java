package budget;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userChoice;
        Manager budgetManager = new Manager();

        while(true) {
            displayMenu();
            userChoice = getInputFromUser();
            System.out.println();
            switch (userChoice.charAt(0)) {
                case ('0'):
                    exitApp();
                    break;
                case ('1'):
                    enterIncome(budgetManager);
                    break;
                case ('2'):
                    enterPurchase(budgetManager);
                    break;
                case ('3'):
                    displayListPurchases(budgetManager);
                    break;
                case ('4'):
                    System.out.printf("Balance: $%.2f\n" , budgetManager.getBalance());
                    break;
                case ('5'):
                    savePurchases(budgetManager);
                    break;
                case ('6'):
                    loadPurchases(budgetManager);
                    break;
                case ('7'):
                    sortChoices(budgetManager);
                    break;
            }
        }
    }
    static void exitApp() {
        System.out.println("Bye!");
        System.exit(0);
    }
    static void enterIncome(Manager budgetManager) {
        System.out.println("Enter income:");
        int income = Integer.parseInt(getInputFromUser());
        budgetManager.addIncome(income);
        System.out.println("Income was added!");
    }
    static void enterPurchase(Manager budgetManager) {
        while (true) {
            addChooseOrListPurchasesMenu("Adding");
            int category = Integer.parseInt(getInputFromUser());
            if (category == 5) return;
            System.out.println("Enter purchase name:");
            String name = getInputFromUser();
            System.out.println("Enter its price:");
            double price = Double.parseDouble(getInputFromUser());
            budgetManager.addPurchase(name, price, category);
            System.out.println();
            System.out.println("Purchase was added!");
        }
    }

    static void displayListPurchases(Manager budgetManager) {
        while (true) {
            addChooseOrListPurchasesMenu("Listing");
            int category = Integer.parseInt(getInputFromUser());
            if (category == 6) return;
            if (category < 5 && budgetManager.isListEmpty(category)) {
                System.out.println("The purchase list is empty");
            } else {
                budgetManager.showPurchaseList(category);
            }
        }
    }
    static void savePurchases(Manager budgetManger) {
        budgetManger.saveAllData();
        System.out.println("Purchases were saved!");
    }
    static void loadPurchases(Manager budgetManager) {
        budgetManager.loadAllData();
        System.out.println("Purchases were loaded!");
    }
    static void sortChoices(Manager budgetManager) {
        while (true) {
            sortMenu();
            String choice = getInputFromUser();
            System.out.println();
            switch (choice.charAt(0)) {
                case('1'):
                    budgetManager.sortByItem(5);
                    break;
                case('2'):
                    budgetManager.sortByType();
                    break;
                case('3'):
                    addChooseOrListPurchasesMenu("Choosing");
                    choice = getInputFromUser();
                    int category = Integer.parseInt(choice) - 1;
                    budgetManager.sortByItem(category);
                    break;
                case('4'):
                    return;
            }
        }

    }
    static void sortMenu() {
        System.out.println();
        System.out.println("How do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort by certain type");
        System.out.println("4) Back");
    }
    static void addChooseOrListPurchasesMenu(String menuType) {
        System.out.println();
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        if (menuType.equals("Adding")) {
            System.out.println("5) Back");
        }
        if (menuType.equals("Listing")) {
            System.out.println("5) All");
            System.out.println("6) Back");
        }

    }
    static void displayMenu() {
        System.out.println();
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
    }
    static String getInputFromUser() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
