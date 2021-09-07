package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			int small = 1;
			int big = 100;
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			
			/* 게임 작성 */
			System.out.println(small + "-" + big);
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);

			for(int i=1; i>0; i++) {
				System.out.print(i + ">>");
				int check = scanner.nextInt();
				if(correctNumber > check) {
					System.out.println("더 높게");
					small = check;
					continue;
				}else if(correctNumber < check) {
					System.out.println("더 낮게");
					big = check;
					continue;
				}else if(correctNumber == check){
					System.out.println("맞았습니다");
					break;
				}
			}
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		//새 게임 여부 확인하기
		System.out.println("게임이 종료되었습니다.");
		scanner.close();
		
	}

}