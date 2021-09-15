package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		String line = "www.douzone.com";
		
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName(line);// 이름으로 모든 ip를 가져옴
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 

	}

}
