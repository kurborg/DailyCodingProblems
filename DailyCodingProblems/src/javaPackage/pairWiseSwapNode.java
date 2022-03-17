package javaPackage;

public class pairWiseSwapNode {

    Node head;

    class Node
    {
        int data;
        Node next;

        Node(int data_)
        {
            data = data_;
        }
    }

    public void pairWiseSwap()
    {
        Node tempHead = head;

        while(tempHead != null && tempHead.next != null)
        {
            int temp = head.data;
            tempHead.data = tempHead.next.data;
            tempHead.next.data = temp;
            tempHead = tempHead.next.next;
        }
    }

    public Node push(int newData)
    {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
        
        return head;
    }

    public static void main(String[] args)
    {
        pairWiseSwapNode list = new pairWiseSwapNode();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);


    }
    
}
