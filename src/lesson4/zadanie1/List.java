package lesson4.zadanie1;



public class List {
    private Node head;

    public void add(int x) {
        if (head == null)
            head = new Node(x);
        else {
            Node node2 = this.getHead();
            while (node2.getNext() != null) {
                node2 = node2.getNext();
            }
            node2.setNext(new Node(x));

        }

    }

    @Override
    public String toString() {
        String list = "";

        Node node2 = this.getHead();
        while (node2.getNext() != null) {
            list +=" " + node2.getX();
            node2 = node2.getNext();
        } list +=" " + node2.getX();

        return list;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}


