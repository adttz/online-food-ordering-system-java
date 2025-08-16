import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
    static Restaurant[] restaurants=new Restaurant[100];
    static User[] users=new User[100];
    static int number_of_restaurants=0;
    static int number_of_users=0;
    public static String allBillsPath="All_Bills.txt";

    static void add_restaurant(String... words)
    {
        Restaurant new_Restaurant=new Restaurant(words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]));
        restaurants[number_of_restaurants++]=new_Restaurant;
        System.out.println("Restaurant "+new_Restaurant.getName()+" added successfully");
        // System.out.println(new_Restaurant.getName());
    }

    static void add_dish(String... words)
    {
        String name=words[1];
        for(Restaurant restaurant:restaurants)
        {
            if(restaurant==null)
            {
                continue;
            }
            if(restaurant.getName().equals(name)==false)
            {
                continue;
            }
            Dish dish=new Dish(words[2], Integer.parseInt(words[3]), Boolean.parseBoolean(words[4]), words[5]);
            restaurant.addDish(dish);
            System.out.println("Dish "+ dish.getName() +" added successfully");
        }
    }

    static void add_user(String... words)
    {
        User user;
        if(words.length==3)
        {
            user=new User(words[1], words[2]);
        }
        else
        {
            user=new User(words[1], words[2], words[3]);
        }
        users[number_of_users++]=user;
        System.out.println("User "+user.getName()+" added successfully");
    }

    static void add_to_cart(String... words) //keyword, user, restaurant, dish
    {
        String user_name=words[1];
        String restaurant_name=words[2];
        String dish_name=words[3];
        for(User user:users)
        {
            if(user==null){continue;}
            if(user.getName().equals(user_name)==false)
            {
                continue;
            }
            for(Restaurant restaurant:restaurants)
            {
                if(restaurant==null){continue;}
                if(restaurant.getName().equals(restaurant_name)==false)
                {
                    continue;
                }
                for(Dish dish:restaurant.getDishes())
                {
                    if(dish==null){continue;}
                    if(dish.getName().equals(dish_name)==false)
                    {
                        continue;
                    }
                    if(user.cart.restaurant==null||user.cart.restaurant.equals(restaurant)==false)
                    {
                        user.cart.update_restaurant(restaurant);
                    }
                    user.cart.add_dish(dish);
                    System.out.println(dish.getName()+" added to cart");
                }
            }
        }
    }

    static void place_order(String... words) //keyword, user, deliveryindex, deliverytype, payment
    {
        String user_name=words[1];
        int delivery_index=Integer.parseInt(words[2]);
        Boolean regular_delivery=Boolean.parseBoolean(words[3]);
        for(User user:users)
        {
            if(user==null){continue;}
            if(user.getName().equals(user_name)==false)
            {
                continue;
            }
            if(words.length==4)
            {
                user.order(delivery_index, regular_delivery);
            }
            else if(Character.isDigit(words[4].charAt(0)))
            {
                user.order(delivery_index, regular_delivery, Long.parseLong(words[4]));
            }
            else
            {
                user.order(delivery_index, regular_delivery, words[4]);
            }
            System.out.println("Order delivered successfully");
        }
    }

    static void add_address(String... words) //address, user, name, x, y
    {
        for(User user:users)
        {
            if(user==null){continue;}
            if(user.getName().equals(words[1])==false){continue;}
            user.add_address(words[2], Integer.parseInt(words[3]), Integer.parseInt(words[4]));
            System.out.println(words[2]+" address added successfully");
        }
    }

    public static void main(String[] args) {
        String fileName = "input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if(words[0].equals("User"))
                {
                    add_user(words);
                }
                else if(words[0].equals("Restaurant"))
                {
                    add_restaurant(words);
                }
                else if(words[0].equals("Dish"))
                {
                    add_dish(words);
                }
                else if(words[0].equals("Item"))
                {
                    add_to_cart(words);
                }
                else if(words[0].equals("Order"))
                {
                    place_order(words);
                }
                else if(words[0].equals("Address"))
                {
                    add_address(words);
                }
            }
        } catch (IOException e) {
            System.out.println("Error opening file");
        }
    }
}
