// import Final_Presentation.Payment;

public class CreditCardPayment extends Bill implements Payment{
    private long cardNumber;
    private final double transactionFees=1.03; //3% transaction fees

    public CreditCardPayment(String userName, int orderNumber, User.Cart cart, String phoneNumber, long cardNumber) {
        super(userName, orderNumber, cart, phoneNumber);
        this.cardNumber = cardNumber;
    }

    @Override
    public double pay(double amount) {
        amount*=this.transactionFees;
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
        return amount;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}
