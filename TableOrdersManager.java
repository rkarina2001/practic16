package exercise;
import java.util.Arrays;
public class TableOrdersManager implements OrdersManager {
    Order[] orders = new Order[20];

    TableOrdersManager() {
        Arrays.fill(orders, null);
    }

    public boolean addOrder(Order order, int table) {
        if (orders[table] != null) return false;
        orders[table] = order;
        return true;
    }

    public boolean addItem(MenuItem item, int tableNumber) {
        if (orders[tableNumber] == null) return false;
        return orders[tableNumber].add(item);
    }

    public int freeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) return i;
        }
        return -1;
    }

    public int[] freeTableNumbers() {
        int[] freeNumbers = new int[0];
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                freeNumbers = Arrays.copyOf(freeNumbers, freeNumbers.length + 1);
                freeNumbers[freeNumbers.length - 1] = i;
            }
        }
        return freeNumbers;
    }

    public Order getOrder(int table) {
        return orders[table];
    }

    public void remove(int tableNumber) {
        orders[tableNumber] = null;
    }

    public void remove(Order order) {
        boolean f = true;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) {
                f = true;
                MenuItem[] menuItems = order.getItems();
                MenuItem[] menuItems1 = orders[i].getItems();
                if (menuItems.length != menuItems1.length) {
                    f = false;
                    break;
                }
                for (int j = 0; j < menuItems.length; j++) {
                    if (!(menuItems[j].getName().equals(menuItems1[j].getName())) || order.itemsQuantity(menuItems[j]) != orders[i].itemsQuantity(menuItems1[j])) {
                        f = false;
                        break;
                    }
                }
                if (f) orders[i] = null;
                return;
            }
        }
    }

    public void removeAll(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].equals(order)) orders[i] = null;
        }
    }

    @Override
    public int itemsQuantity(String itemName) {
        int cost = 0;
        for (Order order : orders) {
            if (order != null) cost += order.itemsQuantity(itemName);
        }
        return cost;
    }

    @Override
    public int itemsQuantity(MenuItem itemName) {
        int cost = 0;
        for (Order order : orders) {
            if (order != null) cost += order.itemsQuantity(itemName);
        }
        return cost;
    }

    @Override
    public Order[] getOrders() {
        Order[] orders = new Order[0];
        for (Order order : this.orders) {
            if (order != null) {
                orders = Arrays.copyOf(orders, orders.length + 1);
                orders[orders.length - 1] = order;
            }
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        for (Order order : orders) {
            if (order != null) cost += order.costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        int quantity = 0;
        for (Order order : orders) {
            if (order != null) quantity++;
        }
        return quantity;
    }
}
