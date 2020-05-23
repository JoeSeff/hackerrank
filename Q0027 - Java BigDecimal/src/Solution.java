import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Wednesday 04-Mar-2020
 *
 */

public class Solution {

	public static void main(String[] args) {

		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n + 2];

		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}

		sc.close();

		// Write your code here
		class ObjString {
			private int index;
			private BigDecimal value;
			private String inputString;

			public ObjString() {
			}

			/**
			 * @param index
			 * @param value
			 * @param inputString
			 */
			public ObjString(int index, String inputString) {
				super();
				this.index = index;
				this.value = new BigDecimal(inputString);
				this.inputString = inputString;
			}

			/**
			 * @return the index
			 */
			public int getIndex() {
				return index;
			}

			/**
			 * @param index the index to set
			 */
			public void setIndex(int index) {
				this.index = index;
			}

			/**
			 * @return the value
			 */
			public BigDecimal getValue() {
				return value;
			}

			/**
			 * @param value the value to set
			 */
			public void setValue(BigDecimal value) {
				this.value = value;
			}

			/**
			 * @return the inputString
			 */
			public String getInputString() {
				return inputString;
			}

			/**
			 * @param inputString the inputString to set
			 */
			public void setInputString(String inputString) {
				this.inputString = inputString;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return inputString;
			}

		}

		class ObjStringComparator implements Comparator<ObjString> {

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
			 */
			@Override
			public int compare(ObjString o1, ObjString o2) {

				if (o1.getValue().compareTo(o2.getValue()) == 0) {
					if (o1.getIndex() < o2.getIndex()) {
						return 1;
					} else if (o1.getIndex() == o2.getIndex()) {
						return 0;
					} else {
						return -1;
					}
				} else if (o1.getValue().compareTo(o2.getValue()) == 1) {
					return 1;
				} else {
					return -1;
				}
			}

		}

		List<ObjString> objList = new ArrayList<>();
		for (int a = 0; a < n; a++) {
			objList.add(new ObjString(a, s[a]));
		}

		Collections.sort(objList, new ObjStringComparator());
		Collections.reverse(objList);

		for (int b = 0; b < objList.size(); b++) {
			s[b] = objList.get(b).toString();
		}

		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}

	}

}
