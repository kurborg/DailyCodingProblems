package javaPackage;

public class reverseLinkedList {
    

    public static class ListNode
    {
        private int data;
        private ListNode next;

        ListNode(int data_)
        {
            this.data = data_;
            this.next = null;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public int getData() {
            return data;
        }
    }

    public static ListNode constructListNode()
    {
        ListNode head = null;
        ListNode tail = null;
        for (int i = 1; i <5; i++)
        {
            ListNode node = new ListNode(i);
            
            if(head == null)
                head = node;
            else
                tail.setNext(node);
            
            tail = node;
        }

        return head;
    }

    public static ListNode reverseList(ListNode head)
    {
        ListNode curr = head;
        ListNode previous = null;

        while(curr != null)
        {
            // B | C | D | null
            ListNode next = curr.getNext();
            // A -> null | B -> A | C -> B | D -> null
            curr.setNext(previous);
            // A | B | C | D
            previous = curr;
            // B | C | D | null
            curr = next;
        }

        // D 
        return previous;
    }

// A -> B -> C -> D -> null
// D -> C -> B -> A -> null

    public static void main(String[] args)
    {
        ListNode list = constructListNode();
        ListNode node = list;
        
        while(list != null)
        {
            System.out.print(list.getData());
            list = list.getNext();
        }

        node = reverseList(node);
        
        System.out.println("\nAfter Reversing List:\n");
        
        while(node != null)
        {
            System.out.print(node.getData());
            node = node.getNext();
        }
    }
}

