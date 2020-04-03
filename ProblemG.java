/**
People are rarely content with what they have — they always seem to want more. Sometimes this is just healthy ambition, but at other times it is clearly motivated by shallow materialism, or worse. Perhaps we could accept this as an unavoidable aspect of human nature, but the problem is that this mindset appears to be spreading rapidly to the world of mathematics and computer science. For example, greedy algorithms are already well known for taking as much as they can in each iteration, but now geometric shapes are getting in on the act! So far, only regular polygons have been affected, but who knows where it will end?

In a regular n-sided polygon (n-gon), all n sides are of equal length, and all interior angles are the same. (For our purposes, a polygon includes its interior, i.e., it is a solid shape.) In the past, the area of a regular n-gon with a given side length was fixed, which was very convenient for students tasked with calculating its area, but now, whenever it gets the chance, a regular n-gon will carry out an expansion operation informally known as a “land grab.” A land grab with expansion distance d>0 works as follows: every point outside the regular n-gon that is at most distance d from some point in the regular n-gon is absorbed and becomes a part of the enlarged n-gon. Over time, a regular n-gon might carry out many land grabs. (Technically, a regular n-gon ceases to be a regular n-gon after the first such land grab, but, sadly, it doesn’t notice that its greed is causing it to lose its identity.) Figure 1 depicts the two test cases in the sample input: a regular 3-gon (triangle) after a single land grab, and a regular 4-gon (square) after two land grabs.

Given an initial regular n-gon and an expansion distance d, what is the area of the resulting region after a specified number of land grabs?

\includegraphics[width=0.7\textwidth ]{shapes06}
Figure 1: Illustration of test cases in Sample Input 1
Input
The first line of input contains an integer, N, the number of test cases (1≤N≤100). Each of the next N lines contains the information for a single regular n-gon, given as four space-separated integers, n ℓ d g, where n is the initial number of sides (3≤n≤60), ℓ is the initial side length, d is the expansion distance (1≤ℓ,d≤10), and g is the number of land grabs (0≤g≤20).

Output
For each test case, output the area of the region occupied by the n-gon after g land grabs. Each area will be considered correct if it is within 10−6 of the official answer.

Sample Input 1	Sample Output 1
2
3 8 1 1
4 5 2 2
54.85440557469184
155.2654824574367
**/
import java.util.Scanner;

public class ProblemG {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numTestCases = scan.nextInt();
		for(int i = 0; i < numTestCases; i++) {
			int n = scan.nextInt();
			int l = scan.nextInt();
			int d = scan.nextInt();
			int g = scan.nextInt();
			double r = d * g;
			double area = n * l * l / ( 4 * Math.tan( Math.PI / n));
			double subArea =  n * r * l + Math.PI * r * r ;
			System.out.println(area + subArea);
		}
			
			/*double s = Math.sqrt( 2 * r * r * ( 1 - Math.cos( 2 * Math.PI / n) ) );
			double b = s;
			//if(n != 3) {
				b = ( (Math.sin( (Math.PI - 2 * Math.PI / n) / 2)) / ( Math.sin( 2 * Math.PI / n))) * s;
			//}
			System.out.println( n * ( (l + 2*b) * (l + 2*b) / (4 * Math.tan( Math.PI / n) ) - Math.sqrt( (4 * b * b - s * s) / 4) * s / 2 + r * r * Math.PI / n - s * ( r - r * ( 1 - Math.cos( Math.PI/n) ) ) / 2)  );
		}*/
	}
}
