package com.joeseff.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


/**
 * @author ONYX
 * @created 20 Feb 2020 00:45:56 
 * @project Q0018 - Meetup Schedule
 * 
 */

class Result {

    /*
     * Complete the 'countMeetings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY departure
     */

    public static int countMeetings(List<Integer> arrival, List<Integer> departure) {
    	// 1. Get list of all available days as a map (day is key, availability as boolean is a value)
    	Map<Integer, Boolean> meetingAvailabilityMap = new HashMap<>();
    	List<Integer> allDays = new ArrayList<>(arrival);
    	allDays.addAll(departure);
    	
    	Collections.sort(allDays);
    	
    	Integer lowestVal = allDays.get(0);
    	Integer highestVal = allDays.get(allDays.size() - 1);
    	
    	for( Integer i = lowestVal; i <= highestVal; i++ ) {
    		meetingAvailabilityMap.put(i, Boolean.TRUE);
    	}
    	    	
    	// 2. Go through the departure array assigning the departure day if available as the meeting day (Mark taken)
    	int counter = 0;
    	int occupiedCounter = 0;
    	for( Integer firstDay : arrival ) {
    		
    		if( meetingAvailabilityMap.get(firstDay) ) {
    			// If available
    			meetingAvailabilityMap.put(firstDay, Boolean.FALSE);
    			counter++;
    			occupiedCounter++;
    			continue;
    		} else {
    			// Not available
    	    	// 3. If not available then loop through the days from arrival date to departure date looking for a day that is not taken (mark taken)
    			Integer upperLimit = departure.get(counter);
    			
    			for(Integer day = firstDay; day <= upperLimit; day++) {
    				if ( meetingAvailabilityMap.get(day) ) {
    					// Available
    					meetingAvailabilityMap.put(day, Boolean.FALSE);
    					occupiedCounter++;
    					break;
    				} 
    			}
    		}
    		counter++;
    	}
    	
    	// 4. Finally, return the count for the number of days marked as taken
        // return (int)meetingAvailabilityMap.values().stream().filter( (Boolean b) -> b ==Boolean.FALSE ).count();
    	return occupiedCounter;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrivalCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arrival = IntStream.range(0, arrivalCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int departureCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> departure = IntStream.range(0, departureCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.countMeetings(arrival, departure);
        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
