import java.math.BigInteger;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Wednesday 04-Mar-2020
 *
 */

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String n = scanner.nextLine();

		if (n != null && !n.isEmpty()) {
			BigInteger bigInteger = new BigInteger(n);

			if (bigInteger.isProbablePrime(1))
				System.out.println("prime");
			else
				System.out.println("not prime");
		}

		scanner.close();
	}
}
