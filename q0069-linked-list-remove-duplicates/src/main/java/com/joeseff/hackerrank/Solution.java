package com.joeseff.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * @author JWachiuri
 * @created Monday 30-Mar-2020
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

class Solution {

	public static Node removeDuplicates(Node head) {
		// Write your code here
		Set<Integer> valuesSet = new HashSet<>();
		Node current = head;
		Node previous = null;
		Node newHead = null;

		while (current != null) {

			if (valuesSet.isEmpty() || !valuesSet.contains(current.data)) {
				valuesSet.add(current.data);

				previous = current;
				current = current.next;
			} else {
				// Duplicate

				current = current.next;
				continue;
			}

			newHead = insert(newHead, previous.data);
		}

		return newHead;
	}

	public static Node insert(Node head, int data) {
		Node p = new Node(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		head = removeDuplicates(head);
		display(head);

	}
}
