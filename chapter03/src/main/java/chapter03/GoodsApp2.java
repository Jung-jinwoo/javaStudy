package chapter03;

import mypackage.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		Goods2 g= new Goods2();
		
		// public은 접근 제한이 없다
		g.name = "camara";
		
		// protected는 같은 패키지에서 접근 가능
		// + 자식에서도 접근이 가능하다
		//g.price = 100;
		
		// 디폴트는 같은패키지에서만 접근 가능
		//g.countStock = 10;
		
		// private는 클래스내부에서만 접근 가능
		//g.countSold = 10;
	}

}
