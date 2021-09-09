package com.practice.arrays.companies;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * cache of fixed size
 * remove the least recently used entry
 * void put(int key, int val)
 * int get(int key)
 * boolean delete(int key)
 * <p>
 * <p>
 * LRUCache(int size)
 */


class LRUCache {
    private final Map<Integer, DLNode> cache = new HashMap<>();
    private DLNode head = null;
    private DLNode tail = null;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private void addNodeToHead(DLNode node) {
        if (this.head == null) {
            this.head = node;
            //this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            node.prev = null;
            if (this.tail == null) {
                this.tail = this.head;
                this.tail.next = null;
            }
            this.head = node;

        }
    }

    private void popTail() {
        System.out.println("Tail : " + this.tail);
        if (this.tail != null) {
            DLNode tempNode = this.tail.prev;
            if (tempNode != null)
                tempNode.next = null;
            this.tail = tempNode;
        }
    }

    // If size crosses the capacity removes the tail element
    private void resize() {
        if (cache.size() > capacity) {
            // Log
            System.out.println("Cache is full, hence resizing! ");
            popTail();
        }
    }

    // Adds the node to the top of the cache
    public void put(int key, int value) {
        DLNode node = null;
        if (cache.containsKey(key)) {
            node = cache.get(key);
        } else {
            node = new DLNode(value);
        }
        addNodeToHead(node);
        cache.put(key, node);
        resize();
    }

    // Returns the value if avaialble from the cache and adds the node to the top of the Cache
    public Integer get(int key) {
        if (cache.containsKey(key)) {
            DLNode valueNode = cache.get(key);

            addNodeToHead(valueNode);
            return valueNode.value;
        }
        return null;
    }

    // Removes the current node if available from the cache, and move the linkedlist pointer references appropriately
    public boolean delete(int key) {
        if (cache.containsKey(key)) {
            DLNode valueNode = cache.remove(key);
            DLNode prev = valueNode.prev;
            DLNode next = valueNode.next;
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
            return true;
        }
        return false;
    }

}


class DLNode {
    DLNode next;
    DLNode prev;
    Integer value;

    DLNode(int value) {
        this.value = value;
    }

    public String toString() {
        return this.value + " - ";
    }
}


public class Coupang {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 100);
        lruCache.put(2, 200);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 300);
        lruCache.put(4, 400);
        lruCache.put(5, 500);
        lruCache.put(6, 600);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.delete(4));
    }

}
