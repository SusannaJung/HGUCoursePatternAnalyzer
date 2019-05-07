package edu.handong.analysis;

import edu.handong.analysis.datamodel.*;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		int k=0;
		
		Student[] initStudent = new Student[numOfStudents];
		
		Student[] checkStudent=new Student[lines.length];
		
		for(int i=0;i<numOfStudents;i++) {
			
			initStudent[i]= new Student(" ");
		}
		
		for(int i=0;i<lines.length;i++) {
			
			checkStudent[i]=new Student(lines[i].split(",")[1].trim());
			
			if(!(studentExist(initStudent,checkStudent[i]))) {
				
				initStudent[k]= new Student(checkStudent[i].getName());
				
				k++;
			}
			
		}
		
		return initStudent;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		
		while(students!=null && student!=null) {
		
			for(int i=0;i<numOfStudents;i++) {
			
				if(student.getName().equals(students[i].getName())) {
				
				return true;
				
				}
			}
		}	

		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		int k=0;
		
		Course[] initCourse = new Course[numOfCourses];
		
		Course[] checkCourse=new Course[lines.length];
		
		for(int i=0;i<numOfCourses;i++) {
			
			initCourse[i]= new Course(" ");
		}
		
		for(int i=0;i<lines.length;i++) {
			
			checkCourse[i]=new Course(lines[i].split(",")[2].trim());
			
			if(!(courseExist(initCourse,checkCourse[i]))) {
				
				initCourse[k]= new Course(checkCourse[i].getCourseName());
				
				k++;
			}
			
		}
				
		return initCourse;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		while(courses!=null && course!=null) {
			
			for(int i=0;i<numOfCourses;i++) {
				
				if(course.getCourseName().equals(courses[i].getCourseName())){
					
					return true;
				}
			}
		}

		return false;
	}

}
