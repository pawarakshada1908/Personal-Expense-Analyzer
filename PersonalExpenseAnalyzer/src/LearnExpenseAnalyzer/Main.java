package LearnExpenseAnalyzer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseAnalyzer analyzer = new ExpenseAnalyzer();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("       PERSONAL EXPENSE ANALYZER");
            System.out.println("======================================");

            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Category-wise Expense");
            System.out.println("5. Calculate Total Expense");
            System.out.println("6. Highest Expense");
            System.out.println("7. Lowest Expense");
            System.out.println("8. Set Monthly Budget");
            System.out.println("9. Check Budget");
            System.out.println("10. Delete Expense");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    analyzer.addExpense();
                    break;

                case 2:
                    analyzer.viewExpenses();
                    break;

                case 3:

                    System.out.println("1. Search by Description");
                    System.out.println("2. Search by ID");

                    System.out.print("Enter choice: ");
                    int searchChoice = sc.nextInt();

                    if (searchChoice == 1) {

                        analyzer.searchExpense();

                    } else if (searchChoice == 2) {

                        System.out.print("Enter Expense ID: ");
                        int id = sc.nextInt();

                        analyzer.searchExpense(id);

                    } else {

                        System.out.println("Invalid choice.");
                    }

                    break;

                case 4:
                    analyzer.categoryExpense();
                    break;

                case 5:

                    System.out.println(
                            "Total Expense = ₹" +
                            analyzer.calculateTotal()
                    );

                    break;

                case 6:
                    analyzer.highestExpense();
                    break;

                case 7:
                    analyzer.lowestExpense();
                    break;

                case 8:
                    analyzer.setBudget();
                    break;

                case 9:
                    analyzer.checkBudget();
                    break;

                case 10:
                    analyzer.deleteExpense();
                    break;

                case 11:

                    System.out.println(
                            "Thank you for using Personal Expense Analyzer!"
                    );

                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 11);

        sc.close();
    }
}