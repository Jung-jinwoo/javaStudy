package exception;

public class MyClassTest {

	public static void main(String[] args) {
		
		try {
			MyClass myclass = new MyClass();
			myclass.danger();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
