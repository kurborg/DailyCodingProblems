package javaPackage;

public class doubleLinkedListPalindrome {

    static class Node
    {
        char data;
        Node prev, next;

        public Node(char data_)
        {
            this.data = data_;
        }
    }

    static Node push(Node head, char new_data)
    {
        Node newNode = new Node(new_data);
        newNode.next = head;
        newNode.prev = null;
        if(head != null)
            head.prev = newNode;
        head = newNode;
        return head;
    }

    static boolean isPalindrome(Node head)
    {
        Node left = head;
        Node right = head;

        while(right.next != null)
            right = right.next;
        
        while(left != right)
        {
            if(left.data != right. data)
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
    
        if (isPalindrome(head))
            System.out.printf("It is Palindrome");
        else
            System.out.printf("Not Palindrome");
    }
    
}
