package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] str;
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName(line);// 이름으로 모든 ip를 가져옴
			
			for(int i=0; i<inetAddresses.length; i++) {
				System.out.println(inetAddresses[i].toString().split("/")[1]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 

	}
	

}
