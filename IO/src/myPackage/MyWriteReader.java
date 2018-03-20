package myPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyWriteReader {

	public static void main(String[] args) throws IOException {

		//--------FileWriter-------
		FileWriter fw1 = new FileWriter(".txt");//write character oriented data into file
		fw1.write("This is String");
		fw1.flush();
		fw1.close();
		//--------BufferedWriter-------
		BufferedWriter bw1 = new BufferedWriter(fw1);
		bw1.newLine();
		bw1.write("This is String");
		bw1.flush();
		bw1.close();
		//--------CharArrayWriter-------
		CharArrayWriter caw1 = new CharArrayWriter();//write common data into char array
		FileWriter fw2 = new FileWriter(".txt");
		FileWriter fw3 = new FileWriter(".txt");
		caw1.write("This is String");
		caw1.writeTo(fw2);
		caw1.writeTo(fw3);
		//caw1.flush();
		caw1.close();
		//--------FileReader-------
		FileReader fr1 = new FileReader(".txt");//reads character oriented data from file
		int charInt1 = 0;
		if(fr1.ready()) {
			while((charInt1=fr1.read())!=-1) {
				System.out.println((char) charInt1);
			}
		}
		//--------BufferedReader-------
		BufferedReader br1 = new BufferedReader(fr1);
		String str1 = null;
		if(br1.ready()) {
			while((str1 = br1.readLine())!=null) {
				System.out.println(str1);
			}
		}
		//--------CharArrayReader-------
		char[] cArray1 = "This is String".toCharArray();
		CharArrayReader car1 = new CharArrayReader(cArray1);//read the data from char array
		int charInt2 = 0;
		if(car1.ready()) {
			while((charInt2=car1.read())!=-1) {
				System.out.println((char) charInt2);
			}
		}
		
		//---------------------InterConversion--------------------
		FileInputStream fisX = new FileInputStream(".txt");
		InputStreamReader isrX = new InputStreamReader(fisX);
		BufferedReader brX = new BufferedReader(isrX);
		brX.readLine();
		
	}

}
