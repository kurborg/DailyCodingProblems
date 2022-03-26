package javaPackage;

import java.util.concurrent.atomic.AtomicBoolean;

// Explanation:
// https://dev.to/mlarocca/ternary-search-tree-core-methods-java-implementation-2hlj

public class ternarySearchTree {
    
    private tstNode root; 
    
    public ternarySearchTree()
    {
        root = null;
    }

    public String search(String element)
    {
        return root == null || root.search(element) == null ? null : element;
    }

    public boolean add(String key, boolean storesKey)
    {
        if(root == null)
        {
            root = new tstNode(key, storesKey);
            return true;
        }
        else
        {
            return root.add(key, storesKey) != null;
        }
    }

    public boolean remove(String key)
    {
        if(root == null)
            return false;
        else
        {
            AtomicBoolean purge = new AtomicBoolean(false);
            return root.remove(key, purge);
        }
    }

    public void clear()
    {
        root = null;
    }


    private class tstNode
    {
        private Character ch;
        private boolean storesKey;

        private tstNode left = null;
        private tstNode right = null;
        private tstNode middle = null;

        public tstNode(String key, boolean storesKey)
        {
            if(key.isEmpty())
            {
                throw new IllegalArgumentException();
            }

            ch = key.charAt(0);
            if(key.length() > 1)
            {
                middle = new tstNode(key.substring(1), storesKey);
            }
            else
            {
                this.storesKey = storesKey;
            }
        }

        public tstNode search(String key)
        {
            if(key.isEmpty())
                return null;
            
            Character c = key.charAt(0);

            if(ch.equals(c))
            {
                if(key.length() == 1)
                {
                    return this;
                }
                else
                {
                    return middle == null? null: middle.search(key.substring(1));
                }
            }
            else if(ch.compareTo(c) < 0)
            {
                return left == null ? null : left.search(key.substring(1));
            }
            else
            {
                return right == null ? null : right.search(key.substring(1));
            }
        }

        private tstNode add(String key, boolean storesKey)
        {
            Character c = key.charAt(0);

            if(ch.equals(c))
            {
                if(key.length() == 1)
                {
                    boolean updated = this.storesKey;
                    this.storesKey = storesKey;
                    // if updated is true then key already existed so return null
                    // else return the node
                    return updated ? null : this;
                }
                else if(this.middle != null)
                {
                    return middle.add(key.substring(1), storesKey);
                }
                else
                {
                    this.middle = new tstNode(key.substring(1), storesKey);
                    return middle.search(key.substring(1));
                }
            }
            else if(ch.compareTo(c) < 0)
            {
                if(this.left != null)
                {
                    return left.add(key.substring(1), storesKey);
                }
                else
                {
                    left = new tstNode(key.substring(1), storesKey);
                    return left.search(key.substring(1));
                }
            }
            else
            {
                if(this.right != null)
                {
                    return right.add(key.substring(1), storesKey);
                }
                else
                {
                    right = new tstNode(key.substring(1), storesKey);
                    return right.search(key.substring(1));
                }
            }
        }

        private boolean remove(String key, AtomicBoolean purge) {
            Character c = key.charAt(0);
            if (c.equals(this.ch)) {
                if (key.length() == 1) {
                    if (this.storesKey) {
                        storesKey = false;
                        // If this node stores a key, and it's a leaf, 
                        // then the path to this node can be purged.
                        purge.set(this.isLeaf());
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    boolean deleted = this.middle == null
                            ? false
                            : this.middle.remove(key.substring(1), purge);
                    if (deleted && purge.get()) {
                        this.middle = null;
                        purge.set(!this.storesKey && this.isLeaf());
                    }
                    return deleted;
                }
            } else if (c.compareTo(this.ch) < 0) {
                boolean deleted = left == null ? false : left.remove(key, purge);
                if (deleted && purge.get()) {
                    this.left = null;
                    purge.set(!this.storesKey && this.isLeaf());
                }
                return deleted;
            } else {
                boolean deleted = right == null ? false : right.remove(key, purge);
                if (deleted && purge.get()) {
                    this.right = null;
                    purge.set(!this.storesKey && this.isLeaf());
                }
                return deleted;
            }
        }

        private boolean isLeaf()
        {
            if(this.middle == null && this.left == null
            && this.right == null)
                return true;
            else
                return false;
        }

    }
}
