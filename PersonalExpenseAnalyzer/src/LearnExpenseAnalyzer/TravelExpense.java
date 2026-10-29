package LearnExpenseAnalyzer;

public class TravelExpense extends Expense {

    public TravelExpense(int id, String description,
                         String category, double amount,
                         String paymentMode) {

        super(id, description, category, amount, paymentMode);
    }

    @Override
    public void displayExpense() {

        System.out.println("Travel Expense:");
        super.displayExpense();
    }
}