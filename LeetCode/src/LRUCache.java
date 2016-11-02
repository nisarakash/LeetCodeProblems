import java.util.HashMap;

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(int key,int value) {
        this.key = key;
        this.val = value;
        prev = null;
        next = null;
    }
}

public class LRUCache {
    
    int capacity;
    HashMap<Integer,Node> map = null;
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        map = new HashMap<Integer,Node>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addHead(node);
            head.prev = null;
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addHead(node);
            node.prev = null;
        }
        else {
            if(map.size() >= capacity) {
                map.remove(end.key);
                end = end.prev;
                if(end != null) {
                    end.next = null;
                }
                
            }
            Node newNode = new Node(key,value);
            addHead(newNode);
            map.put(key,newNode);
        }
    }
    
    public void remove(Node node) {
         if(node.prev != null) {
                node.prev.next = node.next;
        }
        else {
            head = node.next;
        }
        
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        else {
            end = node.prev;
        }
    }
    
    public void addHead(Node node) {
        if(head == null && end == null) {
            end = node;
        }
        else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }
}

