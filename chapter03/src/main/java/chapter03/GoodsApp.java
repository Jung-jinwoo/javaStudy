package chapter03;

public class GoodsApp extends Goods{

	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(10000);
		goods.setCountStock(7);
		goods.setCountSold(3);
		goods.showInfo();
		
	}

}
