package mypackage;

public class Goods2 {

	public String name; // 모든 접근 허용
	protected int price; // 패키지 안에서만 접근 허용 + *자식접근 가능
	int countStock; // (기본) 같은 패키지 내에서만 접근 허용
	private int countSold; // 클래스 내부에서만 접근 허용
}
