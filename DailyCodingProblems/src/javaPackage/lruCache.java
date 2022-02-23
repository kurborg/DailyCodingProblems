package javaPackage;

import java.util.HashMap;
import java.util.Map;

public class lruCache {

    class Node{
        int key, val;
        Node prev; 
        Node next;
    
        public Node(int key_, int val_)
        {
            this.key = key_;
            this.val = val_;
        }
    }

    class doubleList{
        Node head;
        Node tail;
        int size;

        public doubleList()
        {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x)
        {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public void remove(Node x)
        {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst()
        {
            if(head.next == tail)
                return null;
            
            Node x = head.next;
            remove(x);
            return x;
        }

        public int size()
        {
            return this.size;
        }
    }

    Map<Integer, Node> key2Node;
    int capacity;
    doubleList cache;

    public lruCache(int capacity)
    {
        key2Node = new HashMap<>();
        this.capacity = capacity;
        cache = new doubleList();
    }

    public int get(int key)
    {
        if(!key2Node.containsKey(key))
            return -1;
        makeRecentKey(key);
        return key2Node.get(key).val;
    }

    private void makeRecentKey(int key)
    {
        if(!key2Node.containsKey(key))
            return;
        
        Node x = key2Node.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecentlyKey(int key, int val)
    {
        Node x = new Node(key, val);
        cache.addLast(x);
        key2Node.put(key, x);
    }

    private void deleteKey(int key)
    {
        if(!key2Node.containsKey(key))
        {
            return;
        }
        Node x = key2Node.get(key);
        cache.remove(x);
        key2Node.remove(key);
    }

    private void removeLeastRecently()
    {
        Node leastRecentlyUsed = cache.removeFirst();

        if(leastRecentlyUsed == null)
            return;
        key2Node.remove(leastRecentlyUsed.key);
    }

    public void put(int key, int val)
    {
        if(key2Node.containsKey(key))
        {
            deleteKey(key);
            addRecentlyKey(key, val);
            return;
        }

        if(cache.size() == capacity)
        {
            removeLeastRecently();
        }
        addRecentlyKey(key, val);
    }
    
    public static void main(String[] args)
    {
        lruCache cache = new lruCache(3);
        cache.put(0, 5);
        cache.put(1, 13);
        cache.put(2, 28);
        cache.put(0, 9);
        System.out.print(cache.get(0));
    }
}
