package edu.mu.Student;

public class Student {
	//variables
		private int id;
		private String name;
		private double grade;
		
		//constructors
		public Student(int id, String name, double grade) {
			super();
			this.id = id;
			this.name = name;
			this.grade = grade;
		}
		
		public Student() {
			super();
		}

		//getters and setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getGrade() {
			return grade;
		}
		public void setGrade(double grade) {
			this.grade = grade;
		}

		@Override
		public String toString() {
			return "Student [id: " + id + ", name: " + name + ", grade: " + grade + "]";
		}
}
