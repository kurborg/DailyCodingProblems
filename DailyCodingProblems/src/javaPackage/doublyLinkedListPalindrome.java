package javaPackage;

public class doublyLinkedListPalindrome {
    
    static class Node
    {
        char data;
        Node prev; 
        Node next;
    }

    static Node push(Node head, char data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = null;
        newNode.next = head;
        if(head != null)
        {
            head.prev = newNode;
        }
        head = newNode;
        
        return head;
    }

    static boolean isPalindrome(Node head)
    {
        if(head == null)
            return true;

        Node left = head;
        Node right = head;

        while(right.next != null)
            right = right.next;
        
        while(left != right)
        {
            if(left.data != right.data)
                return false;
            
            left = left.next;
            right = right.prev;
        }
        
        return true;
    }
    public static void main(String[] args)
    {
        Node head = null;
        head = push(head, 'l');
        head = push(head, 'e');
        head = push(head, 'v');
        head = push(head, 'e');
        head = push(head, 'l');

        System.out.println(isPalindrome(head));

        Node head2 = null;
        head2 = push(head2, 'l');
        head2 = push(head2, 'e');
        head2 = push(head2, 'v');
        head2 = push(head2, 'e');
        head2 = push(head2, 'v');
        
        System.out.println(isPalindrome(head2));
    }
}
