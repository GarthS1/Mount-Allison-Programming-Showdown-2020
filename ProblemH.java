import java.util.Scanner;

public class ProblemH {
	private Scanner scan;
	private int capacity;
	private int farmWithCows;
	private int regulatoryVisit;

	ProblemH(){
		scan = new Scanner(System.in);
		capacity = scan.nextInt();
		farmWithCows = scan.nextInt();
		regulatoryVisit = scan.nextInt();
	}
	
	public static void main(String args[]) {
		ProblemH test = new ProblemH();
		test.doEverything();
	}
	
	/**
	 * receives input from user about how many cows in the farm and calculates based on regulatoryVisit
	 */
	private void doEverything() {
		int[] numOfCows = new int[farmWithCows];
		for(int i = 0; i < farmWithCows; i++)
			numOfCows[i] = scan.nextInt();
		
		int[] daysRequiredToMultiply = new int[farmWithCows];
		
		for(int i = 0; i < farmWithCows; i++){
			int counter = 1;
			for(int j = 2; j < 2000; j*=2 ) {
				if(numOfCows[i] * j > capacity) {
					daysRequiredToMultiply[i] = counter;
					break;
				}
				counter++;
			}
		}
		
		
		calculateRegulatoryVisit(daysRequiredToMultiply);
	}
	
	/**
	 * asks for user input for when regulatory visited
	 * @param data is the data of how many days required for the cow to be moved out of the farm
	 */
	private void calculateRegulatoryVisit(int [] data) {
		int[] output = new int[regulatoryVisit];
		for(int i = 0; i < regulatoryVisit; i++) {
			output[i] = calculate(scan.nextInt(), data);
		}
		for(int i = 0; i < regulatoryVisit; i++)
			System.out.println(output[i]);
	}
	
	/**
	 * calculates output for given day a when regulatory visits
	 * @param data stores how many days required to move cows to new farm
	 * @return output
	 */
	private int calculate(int a, int[] data) {
		if(a == 0)
			return farmWithCows;
		int output = 0;
		for(int i = 0; i < data.length; i++) {
			if(a>= data[i])
				output += Math.pow(2, (a - data[i] + 1));
			else
				output++;
		}
		return output;
	}
	
}
