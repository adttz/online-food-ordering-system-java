// package OOPS.Final_Presentation;

public class Address {
    String name;
    int x;
    int y;

    public Address(String name, int x, int y)
    {
        this.name=name;
        this.x=x;
        this.y=y;
    }

    //getters
    public String getName() {
        return name;
    }
    public int getX() {
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
