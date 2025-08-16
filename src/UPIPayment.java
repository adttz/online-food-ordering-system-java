// import OOPS.Final_Presentation.Payment;

public class UPIPayment extends Bill implements Payment{
    private String upiId;
    private final double transactionFees=1.01; //1% transaction fees

    public UPIPayment(String userName, int orderNumber, User.Cart cart, String phoneNumber, String upiId) {
        super(userName, orderNumber, cart, phoneNumber);
        this.upiId = upiId;
    }

    @Override
    public double pay(double amount) {
        amount*=this.transactionFees;
        System.out.println("Paid " + amount + " using UPI: " + upiId);
        return amount;
    }

    @Override
    public String getPaymentMethod() {
        return "UPI";
    }
}
