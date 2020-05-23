package com.joeseff.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Monday 30-Mar-2020
 *
 */

class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class Solution {

	static void levelOrder(Node root) {
		// Write your code here

		// Breadth first is a queue
		// Depth first is a stack
		Queue<Node> queue = new LinkedList<Node>();

		if (root == null)
			return;

		queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			System.out.print(current.data + " ");

			if (current.left != null) {
				queue.add(current.left);
			}

			if (current.right != null) {
				queue.add(current.right);
			}
		}
		System.out.println();

	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);
	}
}
