public class Bill extends User 
{
    private User.Cart cart;
    private double totalAmount;
    private double finalAmount;
    private int orderNumber;
 
    public Bill(String userName, int orderNumber, User.Cart cart, String phoneNumber)
    {
        super(userName, phoneNumber);
        this.cart = cart;
        this.totalAmount = 0.0;
        this.orderNumber = orderNumber;
    }
 
    public Bill(String userName, int orderNumber, User.Cart cart, String phoneNumber, String email_id)
    {
        super(userName, phoneNumber, email_id);
        this.cart = cart;
        this.totalAmount = 0.0;
        this.orderNumber = orderNumber;
    }
 
    public void calculateBill()
    {
        for(Dish dish: this.cart.dishes)
        {
            if(dish==null){continue;}
            this.totalAmount += dish.getRate();
        }
        this.totalAmount += 0.05 * this.totalAmount; //GST Rate of 5%
        CODPayment payment_portal=new CODPayment(this.getName(), orderNumber, cart, getContactNumber());
        this.finalAmount=payment_portal.pay(this.totalAmount); 
    }

    public void calculateBill(String UPIId)
    {
        for(Dish dish: this.cart.dishes)
        {
            if(dish==null){continue;}
            this.totalAmount += dish.getRate();
        }
        
        this.totalAmount += 0.05 * this.totalAmount; //GST Rate of 5%
        UPIPayment payment_portal=new UPIPayment(this.getName(), orderNumber, cart, this.getContactNumber(), UPIId);
        this.finalAmount=payment_portal.pay(this.totalAmount); 
    }

    public void calculateBill(long Card_Number)
    {
        for(Dish dish: this.cart.dishes)
        {
            if(dish==null){continue;}
            this.totalAmount += dish.getRate();
        }
        
        this.totalAmount += 0.05 * this.totalAmount; //GST Rate of 5%
        CreditCardPayment payment_portal=new CreditCardPayment(this.getName(), orderNumber, cart, getContactNumber(), Card_Number);
        this.finalAmount=payment_portal.pay(this.totalAmount); 
    }
}