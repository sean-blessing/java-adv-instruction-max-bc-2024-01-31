package model;

public class Grade {
	
	private int number;

	public Grade() {
		this.number = 0;
	}

	public Grade(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getLetter() {
		String letterGrade = "";
		// Assuming user enters valid grade, 0 to 100.
		if (number >= 88)
			letterGrade = "A";
		else if (number >= 80)
			letterGrade = "B";
		else if (number >= 67)
			letterGrade = "C";
		else if (number >= 60)
			letterGrade = "D";
		else 
			letterGrade = "F";
		
		return letterGrade;
	}
	
	
	
	

}
