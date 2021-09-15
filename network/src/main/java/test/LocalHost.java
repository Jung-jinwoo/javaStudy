package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			
			String hostName = ia.getHostName();
			String hostAddress = ia.getHostAddress();
			System.out.println(hostName);
			System.out.println(hostAddress);
			
			byte[] addresses = ia.getAddress();
			for(byte address : addresses) {
				System.out.print(address & 0x000000ff);
				System.out.print('.');
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
