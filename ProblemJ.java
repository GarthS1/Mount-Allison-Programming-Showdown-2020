import java.util.Scanner;

public class ProblemJ {
	private Scanner scan;
	private int numOfStudent;

	ProblemJ(){
		scan = new Scanner(System.in);
	}
	
	public static void main(String args[]) {
		ProblemJ test = new ProblemJ();
		test.getStudent();
		test.calculate();
	}
	
	private void getStudent() {
		numOfStudent = scan.nextInt();
	}
	
	private void calculate() {
		int[] studentValues = new int[numOfStudent];
		for(int i = 0; i < numOfStudent; i++) {
			studentValues[i] = scan.nextInt();
		}
		System.out.println(findSum(studentValues));
		System.out.println(findNewSum(studentValues));
	}
	
	private double findSum(int[] values) {
		double sum = 0;
		boolean part2 = false;
		
		for(int i= 0; i < numOfStudent; i++) {
			if(values[i] < 0)
				part2 = true;
			if(!part2)
				sum+= Math.pow(.8, i) * values[i];
			else {
				if(values[i] >= 0) {
					sum+= Math.pow(.8, i-1) * values[i];
				}
			}
		}
		sum /= 5;
		return sum;
	}
	
	private double findNewSum(int [] values) {
		double sum = 0;
		int [] arrayCopy = values.clone();
		for(int i = 0; i < numOfStudent; i++) {
			arrayCopy[i] = -1;
			sum += findSum(arrayCopy);
			arrayCopy[i] = values[i];
		}
		sum/= numOfStudent;
		return sum;
		
	}
}
