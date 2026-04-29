
public class Invoice {
    private final String customerId;
    private final double amount;

    public Invoice(String customerId, double amount) {
        this.customerId = customerId;
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }
}