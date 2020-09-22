package in.hp.java.linkedlist.single;

public class LinkedListMain {

    public static void main(String[] args) {
        System.out.println("Demostration of Singly Linked List");
        LinkedList list = new LinkedList();
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        System.out.println();
        list.display();
        list.insertAtStart(6);
        System.out.println();
        list.display();
        list.insertAt(2, 7);
        System.out.println();
        list.display();
        list.deleteAt(2);
        System.out.println();
        list.display();

    }

}
