package exercise;

public interface Order {
    boolean add(MenuItem menuItem);
    String[] itemNames();
    int itemsQuantity();
    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem itemName);
    MenuItem[] getItems();
    boolean remove(String itemName);
    boolean remove(MenuItem itemName);
    int removeAll(String itemName);
    int removeAll(MenuItem itemName);
    MenuItem[] sortedItemsByCostDesc();
    int costTotal();
    Customer getCustomer();
    void setCustomer(Customer customer);
}
