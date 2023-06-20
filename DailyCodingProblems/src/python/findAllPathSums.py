def findAllPathSums(tree, targetSum):
    if tree is None:
        return []
    
    paths = []

    def recursivePathSum(node, currentSum):
        if node is None:
            return
        
        currentSum += node.data

        if currentSum == targetSum and node.left is None and node.right is None:
            paths.append(node.data)
        
        recursivePathSum(node.left, currentSum)
        recursivePathSum(node.right, currentSum)
    
    recursivePathSum(tree, 0)

    return paths
