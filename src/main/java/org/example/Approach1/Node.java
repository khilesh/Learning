package org.example.Approach1;

class Node {
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    Node prev, next;
}