package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Tuesday 24-Mar-2020
 *
 */

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

public class Solution {

    public static  Node insert(Node head,int data) {
        //Complete this method
    	if ( head == null ) {
    		head = new Node(data);
    	} else {
    		Node node = new Node(data);
    		Node currentNode = head;
    		
    		while ( currentNode.next != null ) {
    			currentNode = currentNode.next;
    		}
    		currentNode.next = node;
    	}
    	
    	return head;
    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
