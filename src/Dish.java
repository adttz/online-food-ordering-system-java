public class Dish {
    private String name;
    private int rate;
    private boolean isVeg;
    private String type; //type of food: Chinese, Indian, etc
 
    public Dish(String name, int rate, boolean veg, String type)
    {
        this.name = name;
        this.rate = rate;
        this.isVeg = veg;
        this.type = type;
    }
 
    public String getName()
    {
        return this.name;
    }
 
    public String getType()
    {
        return this.type;
    }
 
    public int getRate()
    {
        return this.rate;
    }
 
    public boolean isVeg()
    {
        return this.isVeg;
    }
 
    public String getDishDetails() {
        return "Dish: " + name + ", Type: " + type + ", Rate: " + rate + ", Veg: " + isVeg;
    }
    
}