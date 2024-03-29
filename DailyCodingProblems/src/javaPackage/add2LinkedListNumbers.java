package javaPackage;

//You are given two non-empty linked lists representing two non-negative integers. 
//The digits are stored in reverse order and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public class add2LinkedListNumbers{
	
	
	public static void main(String[] args) {
		
		ListNode list1 = new ListNode(3, new ListNode(4, new ListNode(5)));
		ListNode list2 = new ListNode(7, new ListNode(9, new ListNode(8)));
		
		add2LinkedListNumbers solution = new add2LinkedListNumbers();
		ListNode result = new ListNode();
		result = solution.addTwoNumbers(list1, list2);
		
		solution.printReverse(result);
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        
        while(p != null || q!= null){
            int x = (p!=null)? p.val: 0;
            int y = (q!=null)? q.val:0;
            int sum = carry + x + y;
            
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        } 
        
        if(carry >0 )
    			curr.next = new ListNode(carry);
        
        
        return dummyHead.next;
    }
	
	void printReverse(ListNode head) 
    { 
        if (head == null) return; 
  
        // print list of head node 
        printReverse(head.next); 
  
        // After everything else is printed 
        System.out.print(head.val+""); 
    } 
}