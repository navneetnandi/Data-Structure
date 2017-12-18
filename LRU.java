
public class LRUCache {
    
    public class Dnode{
    
        int key, val;
        Dnode prev, next;

        public Dnode(int k, int v){
            key = k;
            val = v;
        }
    }
    
    int capacity;
    HashMap<Integer, Dnode> hm;
    Dnode head,tail;
    
    public LRUCache(int cap) {
        
        capacity = cap;
        hm = new HashMap<Integer, Dnode>();
        head = new Dnode(0,0);
        tail = new Dnode(0,0);
        
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        
    }
    
    public int get(int key) {
        
        if(hm.containsKey(key)){
            
            Dnode node = hm.get(key);
            int returnVal = node.val;
            removeNode(node);
            moveToHead(node);
            return(returnVal);
        }
        
         return(-1);
    }
    
    //A helper method. Removes the node the position it is in an linking up the previous node with the next node
    public void removeNode(Dnode node){
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    //A helper method. Puts the node into the front of the queue (but just after the "dummy" head)
    public void moveToHead(Dnode node){
        
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
        
    }
    
    
    public void put(int key, int value) {
        
        if(!hm.containsKey(key)){
            //Put this in the LRU and also in the hashmap
            //You also need to consider if the LRU is full or not
            Dnode node = new Dnode(key,value);
            if(hm.size() < capacity){
                hm.put(key,node);
                moveToHead(node);
            }
            else{
                hm.remove(tail.prev.key); //Removing it from the hashmap. We need to remove it from the hashmap before removing it from LRU 
                                        //bcoz removing from LRU would change the tail and tail.prev will point to an incorrect node
                removeNode(tail.prev); //Removing the last element from the LRU (Remember we have a dummy tail)
                moveToHead(node);
                hm.put(key,node);
            }
        }
        else{
            //This key is already there in the LRU
            //We write code to do something similar to the get(int) method of LRUCache
            //but we cant call get(int) bcoz it returns a value
            
            Dnode node = hm.get(key);
            node.val = value;
            removeNode(node);
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */