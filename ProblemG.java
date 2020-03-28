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
