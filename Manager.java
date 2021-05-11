package budget;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class Manager {
    double balance;
    Map<String, Double> food;
    Map<String, Double> clothes;
    Map<String, Double> entertainment;
    Map<String, Double> other;
    List<Map<String, Double>> allPurchases;
    String[] categoryNames = {"Food", "Clothes", "Entertainment", "Other", "All"};

    Manager () {
        balance = 0.0;
        food = new LinkedHashMap<>();
        clothes = new LinkedHashMap<>();
        entertainment = new LinkedHashMap<>();
        other = new LinkedHashMap<>();

        allPurchases = new LinkedList<>();
        allPurchases.add(food);
        allPurchases.add(clothes);
        allPurchases.add(entertainment);
        allPurchases.add(other);
    }

    public void addIncome(double addedIncome) {
         balance += addedIncome;
    }

    public void addPurchase(String item, double cost, int category) {
        allPurchases.get(category - 1).put(item, cost);
        balance -= cost;
    }

    public boolean isListEmpty(int category) {
        return allPurchases.get(category - 1).size() == 0;
    }
    public void showPurchaseList(int choice) {
        double total = 0.0;
        System.out.println();
        System.out.printf("%s:\n", categoryNames[choice - 1]);
        if (choice == 5) {
            for (Map<String, Double> category : allPurchases) {
                category.forEach((name, price) -> System.out.printf(("%s $%.2f\n"), name, price));
                total += category.values().stream().reduce(0.0, Double::sum);
            }
        } else {
            allPurchases.get(choice - 1).forEach((name, price) -> System.out.printf(("%s $%.2f\n"), name, price));
            total += allPurchases.get(choice - 1).values().stream().reduce(0.0, Double::sum);
        }

        System.out.printf("Total sum: $%.2f\n" , total);
    }
    // /Users/mikestagney/Downloads/purchases.txt
    public double getBalance() {
        return Math.max(0.0 , balance);
    }
    public void saveAllData() {
        File file = new File("purchases.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(balance);
            for (int i = 0; i < allPurchases.size(); i++) {
                if (allPurchases.get(i).size() != 0) {
                    writer.println(categoryNames[i]);
                    writer.println(i);
                    allPurchases.get(i).forEach((name, price) -> {
                            writer.println(name);
                            writer.println(price);
                    });
                }
            }
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
    }
    public void loadAllData() {
        File file = new File("purchases.txt");
        try (Scanner scanner = new Scanner(file)) {
            for (Map<String, Double> category : allPurchases) {
                category.clear();
            }
            balance = Double.parseDouble(scanner.nextLine());
            int mapIndex = 0;
            while (scanner.hasNext()) {
                String name = scanner.nextLine();
                if (Arrays.asList(categoryNames).contains(name)) {
                    mapIndex = Integer.parseInt(scanner.nextLine());
                    name = scanner.nextLine();
                }
                Double price = Double.parseDouble(scanner.nextLine());
                allPurchases.get(mapIndex).put(name, price);
            }

        } catch (Exception e) {
            System.out.println("IO exception!");
        }
    }
    public void sortByType() {
        Map<String, Double> type = new LinkedHashMap<>();
        double sum = 0.0;
        for (int i = 0; i < categoryNames.length - 1; i++) {
            double total = allPurchases.get(i).values().stream().reduce(0.0, Double::sum);
            type.put(categoryNames[i], total);
            sum += total;
        }
        sortAndPrintMap("Types:", " -",  type);
    }
    public void sortByItem(int category) {
        Map<String, Double> itemsForSort;
        System.out.println();
        String nameCategory = "";
        if (category == 5) {
            nameCategory = "All";
            itemsForSort = new LinkedHashMap<>();
            for (var entry : allPurchases) {
                itemsForSort.putAll(entry);
            }

        } else {
            itemsForSort = allPurchases.get(category);
             nameCategory = categoryNames[category];
        }
        double sum = itemsForSort.values().stream().reduce(0.0, Double::sum);
        if (sum == 0.0) {
            System.out.println("The purchase list is empty!");
            return;
        }
        sortAndPrintMap(nameCategory, "" ,itemsForSort);
    }
    void sortAndPrintMap(String nameCategory, String divider, Map<String, Double> itemsForSort) {
        Double sum = 0.0;
        System.out.println(nameCategory);

        itemsForSort.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach((entry) -> System.out.printf(("%s%s $%.2f\n"), entry.getKey(), divider, entry.getValue()));

        System.out.printf("Total sum: $%.2f\n\n", sum);
    }

}
