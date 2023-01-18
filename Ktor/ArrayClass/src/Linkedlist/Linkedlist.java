package Linkedlist;

public class Linkedlist {

    public class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Node first;
    Node last;

    public void addLast(int item){
        var node = new Node(item);

        if(first == null){
            first = last = node;
        }else {
            last.next = node;
        }

    }

    //addFirst
    //addLast
    //deleteFirst
    //deleteLast
    //contains
    //indexOf
}
