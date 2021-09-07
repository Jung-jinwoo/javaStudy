package prob2;

public class Prob2 {
	public static void main(String[] args) {
		int []num = new int[9];
		int []result = new int[10];
		int a;
		for(int i=1; i<=num.length; i++) {
			num[i-1] = i;
		}
		
		for(int i=0; i<num.length; i++) {
			a = num[i];
			for(int j=0; j<result.length; j++) {
				result[j] = a;
				System.out.print(result[j] + " ");
				a++;
			}
			
			System.out.println();
		}
		
		
	}
}
