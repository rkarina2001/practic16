package exercise;

public class QueueNode {
    public QueueNode next;
    public QueueNode prev;
    public Order value;

    public QueueNode(QueueNode next, QueueNode prev, Order value) {
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    public QueueNode getNext() {
        return next;

    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    public QueueNode getPrev() {
        return prev;
    }

    public void setPrev(QueueNode prev) {
        this.prev = prev;
    }

    public Order getValue() {
        return value;
    }

    public void setValue(Order value) {
        this.value = value;
    }

}
