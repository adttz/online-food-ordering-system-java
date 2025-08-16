public class RegularDelivery extends Delivery {
 
    int speed = 40; //Assuming the speed at which a regular order travels is 40 kmph
    
    public void deliveryTime(Address source, Address destination)
    {
        double dist = Math.sqrt((Math.pow(source.x - destination.x, 2)) + (Math.pow(source.y - destination.y, 2)));
        System.out.println("Expected Time of Arrival of your order: "+(100*dist/speed)+" minutes");
    }
}
