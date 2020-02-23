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
 * @created 24 Feb 2020 00:49:50
 * @project Q0025 - Stock Market Prediction
 * 
 */

class Result {

	/*
	 * Complete the 'predictAnswer' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY stockData 2. INTEGER_ARRAY queries
	 */

	public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
		List<Integer> resultList = new ArrayList<>();

		// for i = 0; i < numQueries
		for (int i = 0; i < queries.size(); i++) {

			// get stockAmt for given day
			int searchDay = queries.get(i) - 1;
			int comparisonValue = stockData.get(searchDay);

			// declare data variables
			int leftDay = 0;
			int rightDay = 0;

			// if searchDay is first day then search right
			if (searchDay == 0) {
				leftDay = -5;
				rightDay = searchRightList(stockData.subList(1, stockData.size()), comparisonValue, 1);
			} else if (searchDay == (stockData.size() - 1)) {
				// if searchDay is last day then search left
				leftDay = searchLeftList(stockData.subList(0, stockData.size() - 1), comparisonValue, 0);
				rightDay = -5;
			} else {
				// else split list into sublists and search
				leftDay = searchLeftList(stockData.subList(0, searchDay), comparisonValue, 0);
				rightDay = searchRightList(stockData.subList(searchDay + 1, stockData.size()), comparisonValue,
						searchDay + 1);
			}

			if (leftDay >= 0 && rightDay >= 0) {
				int leftGap = searchDay - leftDay;
				int rightGap = rightDay - searchDay;

				// if left result is at equidistance with right result with ref to searchDay
				// then take left option
				if ((leftGap == rightGap) || (leftGap < rightGap)) {
					resultList.add(leftDay + 1);
				} else {
					resultList.add(rightDay + 1);
				}
			} else if (leftDay >= 0) {
				resultList.add(leftDay + 1);
			} else if (rightDay >= 0) {
				resultList.add(rightDay + 1);
			} else {
				resultList.add(-1);
			}

		}

		return resultList;
	}

	public static Integer searchLeftList(List<Integer> stockDataSubList, Integer comparisonValue, Integer baseIndex) {
		for (int i = stockDataSubList.size()-1; i >= 0 ; i--) {
			if (comparisonValue > stockDataSubList.get(i)) {
				return baseIndex + i;
			}
		}

		return -10;
	}

	public static Integer searchRightList(List<Integer> stockDataSubList, Integer comparisonValue, Integer baseIndex) {
		for (int i = 0; i < stockDataSubList.size() ; i++) {
			if (comparisonValue > stockDataSubList.get(i)) {
				return baseIndex + i;
			}
		}

		return -10;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int stockDataCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> stockData = IntStream.range(0, stockDataCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> result = Result.predictAnswer(stockData, queries);
		result.forEach(System.out::println);

		/*
		 * bufferedWriter.write( result.stream() .map(Object::toString)
		 * .collect(joining("\n")) + "\n" );
		 */

		bufferedReader.close();
//        bufferedWriter.close();
	}
}
