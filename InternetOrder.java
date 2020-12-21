package exercise;
import java.util.Arrays;
public class InternetOrder implements Order {
    private int size;
    private ListNode head;
    private ListNode tail;
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

    InternetOrder(){
        size=0;
        this.head=new ListNode(null,null,null);
        this.tail=new ListNode(null,null,null);
        this.head.setNext(this.tail);
        this.head.setPrev(this.tail);
        this.tail.setNext(head);
        this.tail.setPrev(head);
    }

    InternetOrder(Order order){
        this();
        MenuItem[] menuItems=order.getItems();
        for(MenuItem item: menuItems)
            for(int i=0;i<order.itemsQuantity(item);i++) this.add(item);
    }

    @Override
    public boolean add(MenuItem menuItem) {
        if(head.getValue()==null) {
            head.setValue(menuItem);
            size++;
            return true;
        }
        if(tail.getValue()==null) {
            tail.setValue(menuItem);
            size++;
            return true;
        }
        ListNode cur=tail;
        while (cur.getNext()!=head){
            cur=cur.getNext();
        }
        cur.setNext(new ListNode(head,cur,menuItem));
        head.setPrev(cur.getNext());
        size++;
        return true;
    }

    @Override
    public String[] itemNames() {
        String[] itemNames=new String[1];
        if(head.getValue()==null) {
            return new String[0];
        }
        itemNames[0]=head.getValue().getName();
        if(tail.getValue()==null){
            return itemNames;
        }
        ListNode cur=head.getNext();
        while (cur!=head){
            if(!checkName(itemNames,cur.getValue().getName())) {
                String[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = cur.getValue().getName();
                itemNames = newArray;
            }
            cur=cur.getNext();
        }
        return itemNames;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int quantity=0;
        ListNode cur=head;
        if(cur.getValue().getName().equals(itemName))quantity++;
        if(cur.getNext().getValue()!=null)cur=cur.getNext();
        else return quantity;
        if(head.getValue()==null)return 0;
        while(cur!=head){
            if(cur.getValue().getName().equals(itemName))quantity++;
            cur=cur.getNext();
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem itemName) {
        int quantity=0;
        ListNode cur=head;
        if(cur.getValue().getName().equals(itemName.getName()))quantity++;
        if(cur.getNext().getValue()!=null)cur=cur.getNext();
        else return quantity;
        if(head.getValue()==null)return 0;
        while(cur!=head){
            if(cur.getValue().getName().equals(itemName.getName()))quantity++;
            cur=cur.getNext();
        }
        return quantity;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] itemNames=new MenuItem[1];
        if(head.getValue()==null) {
            return new MenuItem[0];
        }
        itemNames[0]=head.getValue();
        if(tail.getValue()==null){
            return itemNames;
        }
        ListNode cur=head.getNext();
        while (cur!=head){
            if(!checkName(itemNames,cur.getValue())) {
                MenuItem[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = cur.getValue();
                itemNames = newArray;
            }
            cur=cur.getNext();
        }
        return itemNames;
    }

    @Override
    public boolean remove(String itemName) {
        if(itemsQuantity(itemName)==0)return false;
        ListNode cur=head;
        while(!cur.getValue().getName().equals(itemName)) cur=cur.getNext();
        if(size>2) {
            cur.prev.setNext(cur.getNext());
            cur.next.setPrev(cur.getPrev());
            if (cur == head)
                head = head.getNext();
            tail = head.getNext();
        }
        if (size==2){
            head=cur.getNext();
            tail=new ListNode(head,head,null);
            head.setNext(tail);
            head.setPrev(tail);
        }
        if(size==1){
            size=0;
            this.head=new ListNode(null,null,null);
            this.tail=new ListNode(null,null,null);
            this.head.setNext(this.tail);
            this.head.setPrev(this.tail);
            this.tail.setNext(head);
            this.tail.setPrev(head);
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(MenuItem itemName) {
        if(itemsQuantity(itemName)==0)return false;
        ListNode cur=head;
        while(cur.getValue()!=itemName) cur=cur.getNext();
        if(size>2) {
            cur.prev.setNext(cur.getNext());
            cur.next.setPrev(cur.getPrev());
            if (cur == head)
                head = head.getNext();
            tail = head.getNext();
        }
        if (size==2){
            head=cur.getNext();
            tail=new ListNode(head,head,null);
            head.setNext(tail);
            head.setPrev(tail);
        }
        if(size==1){
            size=0;
            this.head=new ListNode(null,null,null);
            this.tail=new ListNode(null,null,null);
            this.head.setNext(this.tail);
            this.head.setPrev(this.tail);
            this.tail.setNext(head);
            this.tail.setPrev(head);
        }
        size--;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count=0;
        while(itemsQuantity(itemName)!=0) {
            ListNode cur = head;
            while (!cur.getValue().getName().equals(itemName)) cur = cur.getNext();
            if (size > 2) {
                cur.prev.setNext(cur.getNext());
                cur.next.setPrev(cur.getPrev());
                if (cur == head)
                    head = head.getNext();
                tail = head.getNext();
            }
            if (size == 2) {
                head = cur.getNext();
                tail = new ListNode(head, head, null);
                head.setNext(tail);
                head.setPrev(tail);
            }
            if (size == 1) {
                size = 0;
                this.head = new ListNode(null, null, null);
                this.tail = new ListNode(null, null, null);
                this.head.setNext(this.tail);
                this.head.setPrev(this.tail);
                this.tail.setNext(head);
                this.tail.setPrev(head);
            }
            size--;
            count++;
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem itemName) {
        int count=0;
        while(itemsQuantity(itemName)!=0) {
            ListNode cur = head;
            while (cur.getValue() != itemName) cur = cur.getNext();
            if (size > 2) {
                cur.prev.setNext(cur.getNext());
                cur.next.setPrev(cur.getPrev());
                if (cur == head)
                    head = head.getNext();
                tail = head.getNext();
            }
            if (size == 2) {
                head = cur.getNext();
                tail = new ListNode(head, head, null);
                head.setNext(tail);
                head.setPrev(tail);
            }
            if (size == 1) {
                size = 0;
                this.head = new ListNode(null, null, null);
                this.tail = new ListNode(null, null, null);
                this.head.setNext(this.tail);
                this.head.setPrev(this.tail);
                this.tail.setNext(head);
                this.tail.setPrev(head);
            }
            size--;
            count++;
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
