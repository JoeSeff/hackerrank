package com.joeseff.hackerrank;

import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Saturday 28-Mar-2020
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

	public static int getHeight(Node root) {
		int countLeft = 0;
		int countRight  = 0;
		
		if ( root == null ) {
			return 0;
		}
		
		if ( root.left != null ) {
			countLeft = getHeight(root.left) + 1;
		}
		
		if ( root.right != null ) {
			countRight = getHeight(root.right) + 1;
		}

		
		return (countLeft > countRight) ? countLeft : countRight;
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
		int height = getHeight(root);
		System.out.println(height);
	}
}
