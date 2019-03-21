package lesson4.zadanie1;

public class Node {
    int x;
    Node next;

    public Node(int x) {
        this.x = x;
    }






    public Node() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +"}";
    }
}
