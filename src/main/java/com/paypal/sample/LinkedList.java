package com.paypal.sample;

import java.util.Scanner;

public class LinkedList {

    Node head;
    Node tail;

    /*
     * Adds Node to end of list with given `num` as data
     * Make sure it correctly sets the head (and tail)
     * when adding the first item to the list
     */
    public void add(int num) {
        // your code here
        Node node = new Node(num);
        if (head == null) {
            head = node;
            return;
        }
        node.next = null;
        
    }

    /*
     * Returns value of node at given index
     */
    public int get(int index) {
        // your code here
        return 0;
    }
}

class Node {
    int data;
    Node next;

    public Node(int d) {
        data = d;
    }

    public Node(int d, Node n) {
        data = d;
        next = n;
    }
}

class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == -6) {
                System.out.println(list.get(b));
            } else if (a == -9) {
                list.add(b);
            }
        }
    }
}