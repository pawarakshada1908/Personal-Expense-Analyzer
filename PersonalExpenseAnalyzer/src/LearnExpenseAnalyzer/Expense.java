package LearnExpenseAnalyzer;

public class Expense {
	

	    private int id;
	    private String description;
	    private String category;
	    private double amount;
	    private String paymentMode;

	    public Expense() {
	    }

	    public Expense(int id, String description, String category,
	                   double amount, String paymentMode) {

	        this.id = id;
	        this.description = description;
	        this.category = category;
	        this.amount = amount;
	        this.paymentMode = paymentMode;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public String getPaymentMode() {
	        return paymentMode;
	    }

	    public void displayExpense() {

	        System.out.println(
	                id + " | " +
	                description + " | " +
	                category + " | ₹" +
	                amount + " | " +
	                paymentMode
	        );
	    }
	}

