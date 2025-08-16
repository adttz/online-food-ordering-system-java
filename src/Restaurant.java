public class Restaurant
{
    String name;
    Address address;
    Dish[] dishes;
    final int MAX_DISHES = 10;
    int dishCount;
 
    public Restaurant(String name, int x, int y)
    {
        this.name=name;
        Address add=new Address(name, x, y);
        this.address=add;
        this.dishCount = 0;
        this.dishes = new Dish[this.MAX_DISHES];
    }

    public Restaurant(String name, int x, int y, Dish[] dishes)
    {
        this.name=name;
        this.dishes = new Dish[this.MAX_DISHES];
        Address add=new Address(name, x, y);
        this.address=add;
        this.dishes = dishes;
        this.dishCount = dishes.length;
    }
 
    public Address getAddress()
    {
        return this.address;
    }
    public Dish[] getDishes()
    {
        return this.dishes;
    }
    public String getName()
    {
        return this.name;
    }
 
    public void addDish(Dish dish)
    {
        if(this.dishCount<this.MAX_DISHES)
            this.dishes[this.dishCount++] = dish;
    }
 
    public boolean isDishPresent(Dish dish)
    {
        for(Dish ele: this.dishes)
            if(ele!= null && ele.getName().equalsIgnoreCase(dish.getName()))
                return true;
        return false;
    }
}