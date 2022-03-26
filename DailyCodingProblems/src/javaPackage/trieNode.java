package javaPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/*
Tries take less memory than other general-purpose containers when you need to store many strings 
with a high degree of overlap: if there are many prefixes shared by two or more strings in the set, 
then tries are the answer.

Tries allow to implement core operations like search, insert and delete with a number of operations 
proportional to the length of the input string (regardless of how many keys are stored in the container). 
For general-purpose containers, the best we can get is O(m*log(n)), when there are n keys stored, and the 
input string has m characters.

Tries vastly outperform general-purpose containers on two key operations on sets of strings:
Finding the longest prefix of an input string s;
Enumerating all the strings starting with a certain prefix.
*/

public class trieNode {
    
    Map<Character, trieNode> children;
    boolean storesKey;

    public trieNode(String key)
    {
        children = new HashMap<>();

        if(key.isEmpty())
            storesKey = true;
        else
        {
            storesKey = false;
            Character ch = key.charAt(0);
            children.put(ch, new trieNode(key.substring(1)));
        }
    }

    public trieNode()
    {
        children = new HashMap<>();
        storesKey = false;
    }

    public trieNode search(String key)
    {
        if(key.isEmpty())
            return storesKey ? this : null;
        else
        {
            Character ch = key.charAt(0);
            if(children.containsKey(ch))
            {
                return children.get(ch).search(key.substring(1));
            }
            else
                return null;
        }
    }

    public boolean add(String key)
    {
        if(key.isEmpty())
        {
            // word already exists in trie
            if(this.storesKey)
                return false;
            else
            {
                // reached the end of the trie, so set trieNode storesKey to true
                // then return true for successfully adding key
                this.storesKey = true;
                return true;    
            }
        }
        else
        {
            Character ch = key.charAt(0);
            if(children.containsKey(ch))
                return children.get(ch).add(key.substring(1));
            else
            {
                children.put(ch, new trieNode(key.substring(1)));
                return true;
            }
        }
    }

    public boolean remove(String key, AtomicBoolean purge)
    {
        if(key.isEmpty())
        {
            // end of the recursive call
            if(storesKey)
            {
                // set the nodes storesKey to false so the trie no longer 
                // contains the word and if there's no children (leaf node)
                // then set purge to true until we reach next 
                // storesKey node (end word) or has children node
                storesKey = false;
                if(children.isEmpty())
                {
                    purge.set(true);
                }
                return true;
            }
            // Word exists in the trie but doesn't have
            // storesKey aka isn't contained in the trie
            // but might be a prefix to another word
            else
                return false;
        }
        else
        {
            Character ch = key.charAt(0);
            if(children.containsKey(ch))
            {
                // will keep returning true if reached the end of string
                boolean deleted = children.get(ch).remove(key.substring(1), purge);

                // if the end node had no children then purge will be true
                // and we keep deleting nodes until we reach the next node with children
                // or a node that stores another key
                if(deleted && purge.get())
                {
                    children.remove(ch);
                    if(!children.isEmpty() || this.storesKey)
                        purge.set(false);
                } 
                return deleted;           
            }
            // trie doesn't contain the char so just return false
            else
                return false;
        }
    }

    public static void main(String[] args)
    {
        
    }
}
