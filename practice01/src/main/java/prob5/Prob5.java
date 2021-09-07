package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		int p;
		int q;
		
		for(int i=1; i<100; i++) {
			p = i/10;
			q = i%10;
			if(p == 0 && q%3 == 0) {
				System.out.println(i + " 짝");
			}else if(p !=0 && q != 0 && p%3 ==0 && q%3 ==0) {
				System.out.println(i + " 짝짝");
			}else if(q != 0 && q%3 == 0) {
				System.out.println(i + " 짝");
			}else if(p != 0 && p%3 == 0) {
				System.out.println(i + " 짝");
			}
		}
	}
}
