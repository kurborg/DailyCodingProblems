'''
Mirror binary trees

Problem statement: Given the root node of a binary tree, swap the ‘left’ and ‘right’ children for each node.
'''


class Tree:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def __repr__(self):
        return str(self.data)

    def insert(self, data):
        if data < self.data:
            if self.left == None:
                self.left = Tree(data)
            else:
                self.left.insert(data)
        else:
            if self.right == None:
                self.right = Tree(data)
            else:
                self.right.insert(data)

    def mirror(self):
        if self.left is not None:
            self.left.mirror()
        if self.right is not None:
            self.right.mirror()
        self.left, self.right = self.right, self.left


