public class OrderList
{
    private Order[] orderList = new Order[1];

    public void addOrder(Order order)
    {
        for (int i = 0; i < orderList.length; i++)
        {
            if(orderList[i] == null)
            {
                orderList[i]= order;
            }
        }
        if(orderList[(orderList.length-1)] != null)
        {
            Order[] placeHolder = new Order[(orderList.length*2)];
            for (int i = 0; i < orderList.length; i++) 
            {
                placeHolder[i] = orderList[i];
            }
            orderList=placeHolder;
            /*orderList = new Order[lengthDouble];
            for (int i = 0; i < placeHolder.length; i++)
            {
                orderList[i] = placeHolder[i];
            }*/
        }
        //sortOrder();
    }

    public void removeOrder(int id)
    {
        int index = 0;
        boolean check = false;
        for (int i = 0; i < orderList.length; i++)
        {
            if(orderList[i]!= null && orderList[i].getId() == id)
            {
                index = i;
                check = true;
            }
        }
        if(check == true)
        {

           Order[] placeHolder = new Order[(orderList.length)];
            for (int i = 0; i < orderList.length; i++)
            {
                placeHolder[i] = orderList[i];
            }
            orderList = new Order[placeHolder.length-1];
            for (int i = 0; i < placeHolder.length; i++)
            {
                if(i == index)
                {
                    i++;
                }
                orderList[i] = placeHolder[i];
            }
        }
        //sortOrder();

    }

    public void readyOrder(int id)
    {
        Order access = new Order();
        for (int i = 0; i < orderList.length; i++)
        {
            if(orderList[i]!= null && orderList[i].getId() == id)
            {
                access.ready = true; //ask for help?
            }
        }
    }

    private void sortOrder()
    {
        /*int placeholder = orderList[0].getId();
        for (int i = 0; i < orderList.length; i++)
        {
            if (orderList[i].getId() < orderList[0].getId())
            {

            }
        }*/

        for(int i = 1; i < orderList.length; i++)
        {
            if(orderList[i]!= null){
                int temp = orderList[i].getId();
                Order tempElement = orderList[i];
                int k = i;
                while(k > 0 && temp < orderList[k - 1].getId()) {
                    orderList[k] = orderList[k - 1];
                    k--;
                }
                orderList[k] = tempElement;
            }

        }

    }

    public String printOrder(int id)
    {
        for (int i = 0; i < orderList.length; i++)
        {
            if(orderList[i]!= null && orderList[i].getId() == id)
            {
                //printOrders();
                return toString();
            }
        }

        return "";
    }

    public String printOrders()
    {
        String output = "Ready" + "\n";
        sortOrder();
        Order access = new Order();
        for (int i = 0; i < orderList.length; i++)
        {
            if(orderList[i]!= null && orderList[i].ready == true)
            {
                output += orderList[i].getId() +"\n";
            }
        }
        output += "Preparing" + "\n";
        for (int i = 0; i < orderList.length; i++)
        {
            if(orderList[i]!= null && orderList[i].ready == false)
            {
                output += orderList[i].getId() + "\n";
            }
        }

        return output;
    }


}
