/**
Baxter Scott owns The Enlightened Dairy Co., a dairy company with magical cows. Early each morning, he brushes his teeth, strolls outside, and finds that the cows have doubled in number. With double the number of cows, he can produce double the quantity of milk. While he is ecstatic that he has so many cows and so much milk, the Dairy Regulator forces him to keep at most C cows on any given farm, which greatly complicates his business.

At The Enlightened Dairy Co., Baxter has access to an unlimited number of farms, each with a maximum capacity of C cows. On each farm, cows reproduce at the same rate: they always double in number when the clock strikes midnight. To stay within the Regulator’s rules, whenever a farm has strictly more than C cows, Baxter selects half of the cows on that farm and moves them to an entirely new, empty farm. More precisely, if there are D≤C cows on a farm, he leaves all D cows on the farm, but if there are D>C cows on a farm, he leaves ⌈D2⌉ cows on the farm and takes ⌊D2⌋ cows to a new, empty farm. (Here ⌈ ⌉ and ⌊ ⌋ denote the ceiling and floor functions, which round up/down to the nearest integer, respectively.) He does this early every morning, before the Regulator could possibly show up, so that he can avoid paying hefty Moo Fees.

The Regulator needs to know how many farms she will be inspecting when she visits The Enlightened Dairy Co. The Regulator inspects every farm that has at least one cow, and does not inspect any farm with zero cows. Given the number of cows on each farm with at least one cow on Day 0, compute the number of farms that need inspecting on any given day.

Input
The first line of input contains three space-separated integers, C, N, and M, where C (1≤C≤1000) is the maximum number of cows allowed on a farm, N (0≤N≤1000) is the number of farms with at least one cow on Day 0, and M (1≤M≤50) is the number of different days on which the Regulator visits. The following N lines of input each have a single integer ci (1≤ci≤C), representing the number of cows on the ith of the N farms on Day 0. The final M lines each have a single integer dj (0≤dj≤50), representing a day when the Regulator visits. All dj are distinct.

Output
For each dj, output one line with a single integer: the number of farms the Regulator will inspect on Day dj.

Sample Input 1	Sample Output 1
1 5 5
1
1
1
1
1
0
1
2
3
4
5
10
20
40
80
Sample Input 2	Sample Output 2
2 5 3
1
2
1
2
1
0
1
2
5
7
14
**/
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
