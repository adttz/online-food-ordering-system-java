// import OOPS.Final_Presentation.Payment;

public class CODPayment extends Bill implements Payment{

    public CODPayment(String userName, int orderNumber, User.Cart cart, String phoneNumber)
    {
        super(userName, orderNumber, cart, phoneNumber);
    }

    @Override
    public double pay(double amount) {
        System.out.println("Order placed with Cash on Delivery for amount: " + amount);
        return amount;
    }

    @Override
    public String getPaymentMethod() {
        return "Cash on Delivery";
    }
}
