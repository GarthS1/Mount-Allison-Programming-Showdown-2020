import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** The first line contains an integer, n (1<n<40000), the number of keywords in the data bank. 
 *  This is followed by n lines, each of which contains a keyword string k that is between 1 and 25 characters 
 *  in length (inclusive). All characters in a keyword are guaranteed to fall in the [32,126] ASCII range, 
 *  and no keyword begins or ends with a space or a hyphen.
 *
 */
public class ProblemF {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numLines = scan.nextInt();
		ArrayList<String> theWords = new ArrayList<String>(); 
		int numUniq = 0;
		
		scan.nextLine();
		for(int i = 0; i < numLines; i++) {
			String line = scan.nextLine();
			theWords.add(line.replaceAll("-", " ").toLowerCase());
		}
		
		Collections.sort(theWords);

		for(int i = 0; i < numLines; i++) {
			if( i == 0)
			{
				numUniq++;
			}
			else if( !(theWords.get(i).equals(theWords.get(i-1)))  ) {
				numUniq++;
			}
		}
		System.out.println(numUniq);
	}
}
