package javaPackage;

public class subtreeOfTree {
    
    static boolean sameTree(Node root1, Node root2)
    {
        if(root1 == null && root2 == null)
            return true;

        if(root1 != null && root2 != null && root1.data == root2.data)
            return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
        
        return false;
    }

    static boolean isSubtree(Node root1, Node root2)
    {
        if(root2== null)
            return true;
        if(root1 == null)
            return false;
        
        if(sameTree(root1, root2))
            return true;
        
        return isSubtree(root1.left, root2.left) || isSubtree(root1.right, root2.right);
    }
}
