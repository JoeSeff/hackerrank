import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author ONYX
 * @created 23 Feb 2020 19:40:52
 * @project Q0024 - Bus Stand
 * 
 */

class Result {

	/*
	 * Complete the 'kthPerson' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER k 2. INTEGER_ARRAY p 3. INTEGER_ARRAY q
	 */

	public static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q) {
		List<Integer> resultList = new ArrayList<>();
		
		for ( Integer i = 0; i < q.size(); i++ ) {
			Queue<Integer> queue = new LinkedList<>();
			boolean isBusFull = false;
			int count = 0;
			
			// populate queue
			for(int x = 1; x <= p.size(); x++) {
				queue.add(x);
			}
			
			if ( queue.isEmpty() ) {
				resultList.add(0);
				break;
			}
			
			// Check for time expiry for dequeuing
			for ( Integer j = 0; (j < p.size() && !isBusFull ); j++ ) {
				
				/*if ( resultList.contains(0) ) {
					break;
				}*/
				
				// Check if time has expired
				// int patience = p.get(j);
				// int busArrival = q.get(i);
				if ( p.get(j) < q.get(i) ) {
					
					if ( !queue.isEmpty() ) {
						queue.remove();
					}
					
					count++;
					
					if ( queue.isEmpty() && i == (q.size() - 1) && resultList.size() < q.size() ) {
						resultList.add(0);
					}
				} else {
					// fill the bus
					for (int z = 0; z < k; z++) {
						count++;
						
						if ( queue.isEmpty() ) {
							resultList.add(0);
							count = 0;
							// break;
						} else {
							queue.remove();

							if ( z == (k - 1) ) {
								resultList.add(count);
								isBusFull = true;
								// count = 0;
								break;
							}
						}
					}
					
					
				}
			}
		}
		
		return resultList;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		int pCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> p = new ArrayList<>();

		for (int i = 0; i < pCount; i++) {
			int pItem = Integer.parseInt(bufferedReader.readLine().trim());
			p.add(pItem);
		}

		int qCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> q = new ArrayList<>();

		for (int i = 0; i < qCount; i++) {
			int qItem = Integer.parseInt(bufferedReader.readLine().trim());
			q.add(qItem);
		}

		List<Integer> result = Result.kthPerson(k, p, q);
		
		// result.stream().forEach(System.out::println);
		System.out.println("Result: " + result);

		/*for (int i = 0; i < result.size(); i++) {
			bufferedWriter.write(String.valueOf(result.get(i)));

			if (i != result.size() - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();*/

		bufferedReader.close();
//		bufferedWriter.close();
	}
}










