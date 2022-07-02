package org.example.Approach1;

import java.util.HashMap;

class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;
/**
    Node prev = new Node();
    Node next = new Node();
**/

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            deleteKey(key);
            addRecently(key,value);
            return;
        }

        if(cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key,value);
    }

    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node deletedNode = cache.removeFirst();
        map.remove(deletedNode.key);
    }
/**
    // Node Class
    class Node {
        int key, val;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
**/

/**
    // DoubleList Class
    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeFirst() {
            if(head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }
**/
    public static void main (String [] args ){



        LRUCache lruCacheObj =  new LRUCache(2);

        lruCacheObj.put(1,1);
        lruCacheObj.put(2,2);
        lruCacheObj.get(1);
        lruCacheObj.put(3,3);
        lruCacheObj.get(2);
        lruCacheObj.put(4,4);
        lruCacheObj.get(1);
        lruCacheObj.get(3);
        lruCacheObj.get(4);
/***
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4

 **/
    }
}
