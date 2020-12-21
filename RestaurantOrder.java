package exercise;
import java.util.Arrays;
public class RestaurantOrder implements Order  {
    int size=0;
    MenuItem[] items=new MenuItem[0];
    Customer customer;

    private boolean checkName(String[] menuItems, String item){
        for (String menuItem : menuItems) {
            if (menuItem.equals(item)) return true;
        }
        return false;
    }

    private boolean checkName(MenuItem[] menuItems, MenuItem item){
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equals(item.getName())) return true;
        }
        return false;
    }

    @Override
    public boolean add(MenuItem menuItem) {
        MenuItem[] newArray = Arrays.copyOf(items, items.length + 1);
        newArray[items.length] = menuItem;
        items = newArray;
        size++;
        return true;
    }

    @Override
    public String[] itemNames() {
        String[] itemNames=new String[0];
        for (MenuItem item : items) {
            if (!checkName(itemNames, item.getName())) {
                String[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = item.getName();
                itemNames = newArray;
            }
        }
        return itemNames;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count=0;
        for (MenuItem item : items) {
            if (item.getName().equals(itemName)) count++;
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem itemName) {
        int count=0;
        for (MenuItem item : items) {
            if (item.getName().equals(itemName.getName())) count++;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] itemNames=new MenuItem[0];
        for (MenuItem item : items) {
            if (!checkName(itemNames, item)) {
                MenuItem[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = item;
                itemNames = newArray;
            }
        }
        return itemNames;
    }

    @Override
    public boolean remove(String itemName) {
        if(itemsQuantity(itemName)==0)return false;
        for(int i=0;i<items.length;i++){
            if(items[i].getName().equals(itemName)){
                if (items.length - 1 - i >= 0) System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                items=Arrays.copyOf(items, items.length -1);
                break;
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(MenuItem itemName) {
        if(itemsQuantity(itemName)==0)return false;
        for(int i=0;i<items.length;i++){
            if(items[i].getName().equals(itemName.getName())){
                if (items.length - 1 - i >= 0) System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                items=Arrays.copyOf(items, items.length -1);
                break;
            }
        }
        size--;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count=0;
        while (itemsQuantity(itemName)!=0) {
            for (int i = 0; i < items.length; i++) {
                if (items[i].getName().equals(itemName)) {
                    if (items.length - 1 - i >= 0) System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                    items = Arrays.copyOf(items, items.length - 1);
                    size--;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem itemName) {
        int count=0;
        while (itemsQuantity(itemName)!=0) {
            for (int i = 0; i < items.length; i++) {
                if (items[i].getName().equals(itemName.getName())) {
                    if (items.length - 1 - i >= 0) System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                    items = Arrays.copyOf(items, items.length - 1);
                    count++;
                    size--;
                    break;
                }
            }
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] menuItems=getItems();
        for(int i=0;i<menuItems.length;i++){
            for (int j=i;j<menuItems.length;j++){
                if(menuItems[i].getCost()<menuItems[j].getCost()) {
                    MenuItem tmp;
                    tmp=menuItems[i];
                    menuItems[i]=menuItems[j];
                    menuItems[j]=tmp;
                }
            }
        }
        return menuItems;
    }

    @Override
    public int costTotal() {
        MenuItem[] menuItems=getItems();
        int cost=0;
        for (MenuItem menuItem : menuItems) {
            cost += menuItem.getCost() * itemsQuantity(menuItem);
        }
        return cost;
    }


    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer=customer;
    }
}
