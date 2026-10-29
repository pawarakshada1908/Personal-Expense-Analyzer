package LearnExpenseAnalyzer;

public class FoodExpense extends Expense {

    public FoodExpense(int id, String description,
                       String category, double amount,
                       String paymentMode) {

        super(id, description, category, amount, paymentMode);
    }

    @Override
    public void displayExpense() {

        System.out.println("Food Expense:");
        super.displayExpense();
    }
}