public class Order
{
    private int id;
    private static int nextId = 1;
    public boolean ready; //default is false
    public String[] items;

    public Order(String[] orders)
    {
        id = nextId;
        nextId++;
        ready = false;
        items = orders;
    }
    public Order()
    {
        id = nextId;
        nextId++;
        ready = false;
        items = new String[3];

    }

    public int getId()
    {
        return id;
    }

    public String toString()
    {
        String output = "";
       output += ("Order number: " + getId() + "\n");
       if(ready == true)
       {
           output += ("Ready" + "\n");
       }
       else
       {
           output +=("Not Ready" + "\n");
       }

        for (int i = 0; i < items.length; i++)
        {
            output += (items[i] + "\n");
        }

        return output;


    }

}
