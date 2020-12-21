package exercise;

public class InternetOrderManager implements OrdersManager {
    QueueNode head;
    QueueNode tail;
    int size;

    InternetOrderManager(){
        this.head=new QueueNode(null,null,null);
        this.tail=head;
        head.setNext(tail);
        head.setPrev(tail);
        size=0;
    }

    public boolean add(Order order){
        QueueNode cur=new QueueNode(tail,head,order);
        tail.next=cur;
        cur.next.setPrev(cur);
        head=cur;
        size++;
        return true;
    }

    public Order remove(){
        QueueNode cur=tail;
        tail.getPrev().setNext(head);
        head.setPrev(tail.getPrev());
        tail=tail.getPrev();
        size--;
        return cur.getValue();
    }
    public Order order(){
        return tail.getValue();
    }

    @Override
    public int itemsQuantity(String itemName) {
        int cost=0;
        Order[] orders=getOrders();
        for (Order order : orders) {
            cost += order.itemsQuantity(itemName);
        }
        return cost;
    }

    @Override
    public int itemsQuantity(MenuItem itemName) {
        int cost=0;
        Order[] orders=getOrders();
        for (Order order : orders) {
            cost += order.itemsQuantity(itemName);
        }
        return cost;
    }

    @Override
    public Order[] getOrders() {
        if(head.getValue()==null)return new Order[0];
        Order[] orders=new Order[size];
        QueueNode cur=head;
        for(int i=0;i<size;i++){
            orders[i]=cur.getValue();
            cur=cur.getNext();
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int cost=0;
        Order[] orders=getOrders();
        for (Order order : orders) {
            cost += order.costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }

    @Override
    public void remove(Order order) {
        QueueNode node=head;
        do{
            boolean f;
            f = true;
            MenuItem[] menuItems = order.getItems();
            MenuItem[] menuItems1 = node.getValue().getItems();
            if(menuItems.length!=menuItems1.length) {
                f=false;
            }
            for(int j=0;j<menuItems.length;j++){
                if (!(menuItems[j].getName().equals(menuItems1[j].getName()))||order.itemsQuantity(menuItems[j])!=node.getValue().itemsQuantity(menuItems1[j])){
                    f=false;
                    break;
                }
            }
            if(f){
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
                if(node==head) head=node.getNext();
                if(node==tail) tail=node.getPrev();
            }
            return;
        }while (node!=tail);
    }
}
