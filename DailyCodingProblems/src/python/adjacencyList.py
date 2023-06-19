class ListNode:
    def __init__(self, vertex):
        self.vertex = vertex
        self.next = None

class AdjacencyListNode:
    def __init__(self, numVertices):
        self.numVertices = numVertices
        self.adjacencyList = (None for _ in range(numVertices))

    def addEdge(self, u, v):
        newNode = ListNode(v)

        if self.adjacencyList[u] is None:
            self.adjacencyList[u] = newNode
        else:
            curr = self.adjacencyList[u]
            while curr.next is not None:
                curr = curr.next
            curr.next = newNode

    def getNeighbors(self, u):
        neighbors = []
        curr = self.adjacencyList[u]

        while curr is not None:
            neighbors.append(curr.vertex)
            curr = curr.next
    
        return neighbors
    
class AdjacencyList:
    def __init__(self, numVertices):
        self.numVertices = numVertices
        self.adjacencyList = [[] for _ in range(numVertices)]

    def addEdge(self, u, v):
        self.adjacencyList[u].append(v)
        # Non directed graph add edge both ways
        #self.adjacencyList[v].append(u)

    def getNeighbors(self, u):
        return self.adjacencyList[u]
    
class AdjacencyMatrix:
    def __init__(self, numVertices):
        self.numVertices = numVertices
        self.adjacencyMatrix = [[0 for _ in range(numVertices)] for _ in range(numVertices)]

    def addEdge(self, u, v, weight = 1):
        self.adjacencyMatrix[u][v] = weight
        # Non directed graph add edge both ways
        #self.adjacencyMatrix[v][u] = weight
    s
    def getWeight(self, u, v):
        return self.adjacencyMatrix[u][v]
    
    def getNeighbors(self, u):
        neighbors = []
        for v in range(self.numVertices):
            if self.adjacencyMatrix[u][v] == 1:
                neighbors.append[v]
        
        return neighbors

