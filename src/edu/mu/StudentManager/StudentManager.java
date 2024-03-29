package edu.mu.StudentManager;
import edu.mu.Student.Student;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentManager {
	
	private Student[] students;	
	
	
	
	
	//Abhi Pasupuleti's Code
	public boolean readFromFile(String fileName)
	{
				
		int count = 0; //Create a count variable to get the number of lines in file.
		
		try {
			Scanner fileIn = new Scanner(new FileInputStream(fileName)); //scans the file.

			
			while(fileIn.hasNextLine()) //while there is a next line keep looping
			{
					fileIn.nextLine(); //using nextLine() and count++ to get the number of lines in file to know how many students in the file.
					count++;
			}
			students = new Student[count]; //makes the student array of size count
			fileIn.close(); //closes the file so when i reopen it starts from beginning
			
			fileIn = new Scanner(new FileInputStream(fileName)); // reopens the file to start from the beginning again.
			
			int index = 0; // index variable to go through each student
			while(fileIn.hasNextLine()) 
			{
					String line = fileIn.nextLine(); //gets the next line to hold the whole line 
					String parts[] = line.split(" "); //splits the line at each " " so now the parts array has the id, Name, grade.
					int id = Integer.parseInt(parts[0]); //using parseInt to parse it from String to int and then storing it in id.
					String Name = parts[1] + " " + parts[2]; //combining the 2nd element and 3rd element with space in between for the Name
					double grade = Double.parseDouble(parts[3]); //using parseDouble to parse 4th element from String to double and then storing it in grade.
					students[index] = new Student(id, Name, grade); //takes current student and and makes the students with their correspoding id, Name, grade.
					index++;
				
			}
			fileIn.close();//closes file
			return true;
		} catch (FileNotFoundException e) //if file not found then return no file found and return false.
		{
			System.out.println("No File Found");
			e.printStackTrace();
			return false;
		}
		
	}
		//Nitin code
		public void displayStudents() {
			//checking if student length 0 then tell user no student
			//else
			//iterates through the student data and prints student info by calling to 'toString'
			if(students.length == 0) {
				System.out.println("No student found");
			}else {
				for(int i = 0; i < students.length; i++) {
					Student student = students[i];
					System.out.println(student); //called toString method in Student.java file
				}
			}
		}
		
		public boolean searchStudentById(int id)
		{
			//runs through the student array with the length
			//uses an if statement to determine if the student's id is 
			//equal to the id in the parameter
			//if it does match, it prints out the information of the student
			//and if it doesn't, prints an error message.
			//Matthew Robison wrote this function
			for(int i=0; i<students.length; i++)
			{
				if(students[i].getId() == id)
				{
					System.out.println("Student was found! " + students[i].toString()) ;
					return true;
				}
				
			}
				System.out.println("The student was not found. Please try again!");
				return false;
		}

		
		//Aditya
		public boolean updateStudentGradeById(int id, double grade) {
			
			if(searchStudentById(id)) {
				//loops through student array, finds student with id, and sets their grade
				for(int i=0; i<students.length; i++)
				{
					if(students[i].getId() == id)
					{
						students[i].setGrade(grade);
					}	
				}
			}
			else {
				return false;
			}
			
			return true;
		}

	
	
	
}
