import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        System.out.println("Fast Food World Order Tracker");
        Order[] restaurantOrders;
        Scanner input = new Scanner(System.in);
        OrderList OrderList = new OrderList();
        Order emptyOrder = new Order();

        int breakOut = 0;

        while(breakOut == 0)
        {
            System.out.println("Please select a menu option: " + "\n" +
                                "1- Create order" + "\n" +
                                "2- Delete order" + "\n" +
                                "3- Ready order" + "\n" +
                                "4- Print orders" + "\n" +
                                "5- Print all orders" + "\n" +
                                "6- Exit");
            int choice = input.nextInt();

            if(choice == 1)
            {
                String[] items = new String[3];

                System.out.print("Enter item 1: ");
                String item = input.next();
                System.out.print("Enter item 2: ");
                String item2 = input.next();
                System.out.print("Enter item 3: ");
                String item3 = input.next();

                items[0] = item;
                items[1] = item2;
                items[2] = item3;

                Order newOrder = new Order(items);
                OrderList.addOrder(newOrder);
                System.out.println("Order has been added");
            }
            else if(choice == 2)
            {
                System.out.print("Please enter order id: ");
                int id = input.nextInt();

                OrderList.removeOrder(id);
                System.out.println("Order has been removed.");
            }
            else if(choice == 3)
            {
                System.out.print("Please enter order id: ");
                int id = input.nextInt();

                OrderList.readyOrder(id);
                System.out.println("Order has been set to \"Ready\"");
            }
            else if(choice == 4)
            {
                System.out.print("Please enter order id: ");
                int id = input.nextInt();

                if(OrderList.printOrder(id) == "")
                {
                    System.out.println("No such order found");
                }
                else
                {
                    OrderList.printOrder(id);
                }


            }
            else if(choice == 5)
            {
                OrderList.printOrders();
            }
            else if(choice == 6)
            {
                System.out.println("Shutting off...");
                breakOut = 1;
            }
        }
    }
}
