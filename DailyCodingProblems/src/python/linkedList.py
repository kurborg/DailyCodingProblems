"""
An object for storing a single node of a linked list.
Models 2 attributes, data and the link to the next node in the list
run python -i linkedList.py to start an interactive python terminal passing 
in our file for class use
"""

class node:
    data = None
    nextNode = None

    def __init__ (self,data):
        self.data = data

    def __repr__(self):
        return "<Node data: %s>" %self.data

"""
Singly linked list
"""
class LinkedList:

    def __init__(self):
        self.head = None

    def is_empty(self):
        self.head == None

    """
    Returns the number of nodes in our list in linear time O(N)
    because we need to visit each node
    """
    def size(self):
        current = self.head
        count = 0

        while current:
            count+=1
            current = current.nextNode

        return count