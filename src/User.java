// package OOPS.Final_Presentation;

public class User {
    private String name;
    private String contact_number;
    private String email_id;
    private Address[] address=new Address[5];
    private int number_of_addresses=0;
    User.Cart cart;

    public User(String name, String number, String email_id)
    {
        this.name=name;
        this.contact_number=number;
        this.email_id=email_id;
        cart=new User.Cart();
    }
    
    public User(String name, String number)
    {
        this.name=name;
        this.contact_number=number;
        this.email_id=null;
        cart=new User.Cart();
    }

    boolean add_address(String name, int x, int y)
    {
        if(this.number_of_addresses>=5)
        {
            return false;
        }
        Address temp=new Address(name, x, y);
        this.address[this.number_of_addresses++]=temp;
        return true;
    }

    boolean order(int delivery_index, boolean regular_delivery)
    {
        if(cart.restaurant==null||cart.dishes[0]==null)
        {
            System.out.println("Cart is empty");
            return false;
        }
        Bill bill;
        if(delivery_index>number_of_addresses||delivery_index<=0)
        {
            System.out.println("Invalid Address Index entered\n");
            return false;
        }
        int orderNumber=(int)(Math.random()*1000000+100);
        if(getEmailId() != null && !getEmailId().isEmpty())
        {
            bill=new Bill(this.getName(), orderNumber, cart, this.getContactNumber(), this.getEmailId());
        }
        else
        {
            bill=new Bill(this.getName(), orderNumber, cart, this.getContactNumber());
        }
        bill.calculateBill();
        if(regular_delivery)
        {
            RegularDelivery delivery=new RegularDelivery();
            delivery.deliveryTime(this.address[delivery_index-1], cart.restaurant.address);
        }
        else
        {
            EcoSaverDelivery delivery=new EcoSaverDelivery();
            delivery.deliveryTime(this.address[delivery_index-1], cart.restaurant.address);
        }
        return true;
    }

    boolean order(int delivery_index, boolean regular_delivery, String UPIId)
    {
        if(cart.restaurant==null||cart.dishes[0]==null)
        {
            System.out.println("Cart is empty");
            return false;
        }
        Bill bill;
        if(delivery_index>number_of_addresses||delivery_index<=0)
        {
            System.out.println("Invalid Address Index entered\n");
            return false;
        }
        int orderNumber=(int)(Math.random()*1000000+100);
        if(getEmailId() != null && !getEmailId().isEmpty())
        {
            bill=new Bill(this.getName(), orderNumber, cart, this.getContactNumber(), this.getEmailId());
        }
        else
        {
            bill=new Bill(this.getName(), orderNumber, cart, this.getContactNumber());
        }
        bill.calculateBill(UPIId);
        if(regular_delivery)
        {
            RegularDelivery delivery=new RegularDelivery();
            delivery.deliveryTime(this.address[delivery_index-1], cart.restaurant.address);
        }
        else
        {
            EcoSaverDelivery delivery=new EcoSaverDelivery();
            delivery.deliveryTime(this.address[delivery_index-1], cart.restaurant.address);
        }
        return true;
    }

    boolean order(int delivery_index, boolean regular_delivery, long Card_Number)
    {
        if(cart.restaurant==null||cart.dishes[0]==null)
        {
            System.out.println("Cart is empty");
            return false;
        }
        Bill bill;
        if(delivery_index>number_of_addresses||delivery_index<=0)
        {
            System.out.println("Invalid Address Index entered\n");
            return false;
        }
        int orderNumber=(int)(Math.random()*1000000+100);
        if(getEmailId() != null && !getEmailId().isEmpty())
        {
            bill=new Bill(this.getName(), orderNumber, cart, this.getContactNumber(), this.getEmailId());
        }
        else
        {
            bill=new Bill(this.getName(), orderNumber, cart, this.getContactNumber());
        }
        bill.calculateBill(Card_Number);
        if(regular_delivery)
        {
            RegularDelivery delivery=new RegularDelivery();
            delivery.deliveryTime(this.address[delivery_index-1], cart.restaurant.address);
        }
        else
        {
            EcoSaverDelivery delivery=new EcoSaverDelivery();
            delivery.deliveryTime(this.address[delivery_index-1], cart.restaurant.address);
        }
        return true;
    }

    static class Cart
    {
        Restaurant restaurant;
        Dish[] dishes;
        int number_of_dishes=0;
        final int max_number_of_dishes=10;

        public Cart()
        {
            this.restaurant=null;
            dishes=new Dish[this.max_number_of_dishes];
        }

        void update_restaurant(Restaurant restaurant)
        {
            this.restaurant=restaurant;
            this.dishes=new Dish[this.max_number_of_dishes];
        }

        boolean add_dish(Dish dish)
        {
            if(number_of_dishes>=max_number_of_dishes)
            {
                return false;
            }
            this.dishes[number_of_dishes]=dish;
            return true;
        }
    }

    //setters
    void setContactNumber(String number)
    {
        this.contact_number=number;
    }
    void setEmailId(String email_id)
    {
        this.email_id=email_id;
    }

    //getters
    String getName()
    {
        return this.name;
    }
    String getContactNumber()
    {
        return this.contact_number;
    }
    String getEmailId()
    {
        return this.email_id;
    }
    
}
