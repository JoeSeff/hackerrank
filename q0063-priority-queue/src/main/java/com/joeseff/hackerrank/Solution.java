package com.joeseff.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * @author JWachiuri
 * @created Thursday 26-Mar-2020
 *
 */

class Student implements Comparable<Student>{
	private int id;
	private String name;
	private double cgpa;

	/**
	 * @param id
	 * @param name
	 * @param cgpa
	 */
	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cgpa
	 */
	public double getCgpa() {
		return cgpa;
	}

	/**
	 * @param cgpa the cgpa to set
	 */
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "[ " + cgpa + ", " + name + ", " + id + " ]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Student o) {
		
		if ( Double.compare(this.getCgpa(), o.getCgpa()) > 0 ) {
			return 1;
		} else if ( Double.compare(this.getCgpa(), o.getCgpa()) ==0 ) {
			
			// Name ASC
			int nameIndex = this.getName().compareTo(o.getName());
			
			if ( nameIndex != 0) {
				return -1 * nameIndex;
			} else {
				// ID ASC
				if ( this.getId() < o.getId() ) {
					return -1;
				} else if ( this.getId() == o.getId() ) {
					return 0;
				} else {
					return 1;
				}
			}
		} else {
			return -1;
		}

	}

}

class Priorities {

	public List<Student> getStudents(List<String> events) {
		List<Student> studentList = getStudentList(events);
		
		return studentList;
	}
	
	private List<Student> getStudentList(List<String> events) {
		List<Student> studentList = new ArrayList<>();
		PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(1000, Collections.reverseOrder());
		
		for ( String event : events ) {
			
			if ( event.contains("ENTER") ) {
				String[] params = event.split("\\s+");
				
				Student student = new Student(Integer.parseInt(params[3]), params[1], Double.parseDouble(params[2]));
				studentPriorityQueue.add(student);
				
			} else {
				studentPriorityQueue.poll();
			}
		}
		
		while (!studentPriorityQueue.isEmpty()) {
			studentList.add(studentPriorityQueue.poll());
		}
		
		return studentList;
	}
}

public class Solution {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}

}
