'''
Delete node with given key

Problem statement: You are given the head of a linked list and a key. You have to delete the node that contains this given key.
'''

class ListNode:
    def __init__(self, vertex):
        self.value = vertex
        self.next = None

def deleteNodeWithKey(head, key):
    if not head:
        return
    
    if head.value == key:
        head.next = head.next.next
    curr = head.next

    while curr:
        if curr.value == key:
            curr.next = curr.next.next
        curr = curr.next
    
    return head
        