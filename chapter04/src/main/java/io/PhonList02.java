package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhonList02 {

	public static void main(String[] args) {
		
		Scanner scanner = null;
		try {
			File file = new File("phone.txt");
			
			System.out.println("========= 파일 정보 =========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			System.out.println("========= 전화번호 =========");
			scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String name = scanner.next();
				String phone01 = scanner.next();
				String phone02 = scanner.next();
				String phone03 = scanner.next();
				
				System.out.println(name + ":" + phone01 + "-" + phone02 + "-" + phone03);
			}
		} catch (IOException e) {
			System.out.println("File Not Found: " + e);
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
	}

}
