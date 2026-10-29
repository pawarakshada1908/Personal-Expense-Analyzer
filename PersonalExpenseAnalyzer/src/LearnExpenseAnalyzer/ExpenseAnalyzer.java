package LearnExpenseAnalyzer;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseAnalyzer implements ExpenseOperations {

    ArrayList<Expense> expenses = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    double budget;

    public void addExpense() {

        try {

            System.out.print("Enter Expense ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Description: ");
            String description = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                throw new InvalidAmountException(
                        "Amount must be greater than 0."
                );
            }

            sc.nextLine();

            System.out.print("Enter Payment Mode: ");
            String paymentMode = sc.nextLine();

            Expense e = new Expense(
                    id,
                    description,
                    category,
                    amount,
                    paymentMode
            );

            expenses.add(e);

            System.out.println("Expense added successfully!");

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public void viewExpenses() {

        if (expenses.size() == 0) {

            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n========== ALL EXPENSES ==========");
        System.out.println(
                "ID | Description | Category | Amount | Payment Mode"
        );

        for (Expense e : expenses) {

            e.displayExpense();
        }
    }

    public void searchExpense() {

        sc.nextLine();

        System.out.print("Enter description to search: ");
        String search = sc.nextLine();

        boolean found = false;

        for (Expense e : expenses) {

            if (e.getDescription().equalsIgnoreCase(search)) {

                e.displayExpense();
                found = true;
            }
        }

        if (!found) {

            System.out.println("Expense not found.");
        }
    }

    public void searchExpense(int id) {

        boolean found = false;

        for (Expense e : expenses) {

            if (e.getId() == id) {

                e.displayExpense();
                found = true;
            }
        }

        if (!found) {

            System.out.println("Expense not found.");
        }
    }

    public void categoryExpense() {

        sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        double total = 0;
        boolean found = false;

        System.out.println("\n========== CATEGORY EXPENSES ==========");

        for (Expense e : expenses) {

            if (e.getCategory().equalsIgnoreCase(category)) {

                e.displayExpense();

                total = total + e.getAmount();

                found = true;
            }
        }

        if (found) {

            System.out.println(
                    "Total " + category +
                    " Expense = ₹" + total
            );

        } else {

            System.out.println("No expenses found.");
        }
    }

    public double calculateTotal() {

        double total = 0;

        for (Expense e : expenses) {

            total = total + e.getAmount();
        }

        return total;
    }

    public void highestExpense() {

        if (expenses.size() == 0) {

            System.out.println("No expenses found.");
            return;
        }

        Expense highest = expenses.get(0);

        for (Expense e : expenses) {

            if (e.getAmount() > highest.getAmount()) {

                highest = e;
            }
        }

        System.out.println("\n========== HIGHEST EXPENSE ==========");

        highest.displayExpense();
    }

    public void lowestExpense() {

        if (expenses.size() == 0) {

            System.out.println("No expenses found.");
            return;
        }

        Expense lowest = expenses.get(0);

        for (Expense e : expenses) {

            if (e.getAmount() < lowest.getAmount()) {

                lowest = e;
            }
        }

        System.out.println("\n========== LOWEST EXPENSE ==========");

        lowest.displayExpense();
    }

    public void setBudget() {

        System.out.print("Enter monthly budget: ");
        budget = sc.nextDouble();

        System.out.println("Budget set successfully!");
    }

    public void checkBudget() {

        double total = calculateTotal();

        System.out.println("\n========== BUDGET STATUS ==========");

        System.out.println("Budget        : ₹" + budget);
        System.out.println("Total Expense : ₹" + total);

        if (total < budget) {

            System.out.println(
                    "Remaining     : ₹" + (budget - total)
            );

        } else if (total == budget) {

            System.out.println("Budget completely used.");

        } else {

            System.out.println(
                    "Budget exceeded by ₹" +
                    (total - budget)
            );
        }
    }

    public void deleteExpense() {

        System.out.print("Enter Expense ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < expenses.size(); i++) {

            if (expenses.get(i).getId() == id) {

                expenses.remove(i);

                System.out.println(
                        "Expense deleted successfully!"
                );

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Expense not found.");
        }
    }
}
