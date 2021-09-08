package prob04;

public class StringUtil {
	
	public static String concatenate(String[] strArr) {
		
		String test = "";
		
		for(int i=0; i<strArr.length; i++) {
			test += strArr[i];
		}
		return test;
	}
}
