package com.joeseff.hackerrank;

import java.util.BitSet;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Monday 23-Mar-2020
 *
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readInputandCreateBitsets();
	}

	public static void readInputandCreateBitsets() {
		try (Scanner scanner = new Scanner(System.in)) {

			String[] params = scanner.nextLine().split(" ");
			int bitsetSize = Integer.parseInt(params[0]);
			int noOfOps = Integer.parseInt(params[1]);

			BitSet p = new BitSet(bitsetSize);
			BitSet q = new BitSet(bitsetSize);
			
			filterLogic(p, q, noOfOps, scanner);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void filterLogic(BitSet p, BitSet q, int noOfOps, Scanner scanner) {

			for (int c = 0; c < noOfOps; c++) {
				String[] opsLineArr = scanner.nextLine().split("\\s+");

				String op = opsLineArr[0];
				int bitSetIndicator = Integer.parseInt(opsLineArr[1]);
				int index = Integer.parseInt(opsLineArr[2]);
				
				switch (op) {
					case "AND":
						andOp(p, q, bitSetIndicator);
						break;
	
					case "OR":
						orOp(p, q, bitSetIndicator);
						break;
	
					case "XOR":
						xorOp(p, q, bitSetIndicator);
						break;
	
					case "FLIP":
						flipOp(p, q, bitSetIndicator, index);
						break;
	
					case "SET":
						setOp(p, q, bitSetIndicator, index);
						break;
	
					default:
						break;
				}
				
				System.out.printf("%d %d\n", p.cardinality(), q.cardinality());
				
			}

	}

	public static BitSet andOp(BitSet p, BitSet q, int bitSetIndicator) {
		if (bitSetIndicator == 1) {
			p.and(q);
			return p;
		} else {
			q.and(p);
			return q;
		}
	}

	public static BitSet orOp(BitSet p, BitSet q, int bitSetIndicator) {
		if (bitSetIndicator == 1) {
			p.or(q);
			return p;
		} else {
			q.or(p);
			return q;
		}
	}

	public static BitSet xorOp(BitSet p, BitSet q, int bitSetIndicator) {
		if (bitSetIndicator == 1) {
			p.xor(q);
			return p;
		} else {
			q.xor(p);
			return q;
		}
	}

	public static BitSet flipOp(BitSet p, BitSet q, int bitSetIndicator, int index) {
		if (bitSetIndicator == 1) {
			p.flip(index);
			return p;
		} else {
			q.flip(index);
			return q;
		}
	}

	public static BitSet setOp(BitSet p, BitSet q, int bitSetIndicator, int index) {
		if (bitSetIndicator == 1) {
			p.set(index);
			return p;
		} else {
			q.set(index);
			return q;
		}
	}

}
