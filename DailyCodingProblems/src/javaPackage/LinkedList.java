package javaPackage;

public class LinkedList {
    
    Node head;

    static class Node{
        int value;
        Node next;

        Node(int value_)
        {
            value = value_;
            next = null;
        }
    }

    void shiftKNodes(int k)
    {
        // null case
        if(k == 0)
            return;

        Node current = head;
        int count = 1;

        // get to kth node in linked list
        while(count < k && current != null)
        {
            current = current.next;
            count++;
        }

        // k bigger than linked list case
        if(current == null)
            return;

        Node kthNode = current;

        // now point current to last node
        while(current.next != null)
            current = current.next;

        // make last node point to head
        current.next = head;

        // make head the next node from k then make the kth node point to null next
        head = kthNode.next;
        kthNode.next = null;

    }

    void printLinkedList()
    {
        Node current = head;

        System.out.println();

        while(current != null)
        {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);
        list.head.next.next.next.next  = new Node(50);
        list.head.next.next.next.next.next = new Node(60);

        // 10 -> 20 -> 30 -> 40 -> 50 -> 60
        list.printLinkedList();

        list.shiftKNodes(4);

        //50 -> 60 -> 10 -> 20 -> 30 -> 40
        list.printLinkedList();
        
    }
}
