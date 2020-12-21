package exercise;

public interface OrdersManager {
    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem itemName);
    Order[] getOrders();
    int ordersCostSummary();
    int ordersQuantity();
    void remove(Order order);
}
