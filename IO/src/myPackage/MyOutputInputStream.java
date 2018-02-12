package myPackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyOutputInputStream {

	public static void main(String[] args) throws IOException {
		
		//--------FileOutputStream-------
		FileOutputStream fos1 = new FileOutputStream(".txt");//write byte oriented data to file
		fos1.write(65);
		fos1.write("THis is String".getBytes());
		//--------BufferedOutputStream-------
		BufferedOutputStream bos1 = new BufferedOutputStream(fos1);//store in buffer
		bos1.write(65);
		bos1.write("This is Buffered String".getBytes());
		bos1.flush();
		fos1.close();
		//--------ByteArrayOutputStream-------
		ByteArrayOutputStream baos1 = new ByteArrayOutputStream();//write common data into byte array
		//which can be forwarded to multiple streams later.
		FileOutputStream fos2 = new FileOutputStream(".txt");
		FileOutputStream fos3 = new FileOutputStream(".txt");
		baos1.write(65);
		baos1.writeTo(fos2);
		baos1.writeTo(fos3);
		baos1.flush();
		baos1.close();
		
		//--------FileInputStream-------
		FileInputStream fis1 = new FileInputStream(".txt");//read byte oriented data from file
		System.out.println(fis1.read());
		int charInt = 0;
		while((charInt=fis1.read())!=-1) {
			System.out.println((char)charInt);
		}
		//--------BufferedInputStream-------
		BufferedInputStream bis1 = new BufferedInputStream(fis1);
		System.out.println(bis1.read());
		int charInt2 = 0;
		while((charInt2=bis1.read())!=-1) {
			System.out.println((char)charInt2);
		}
		fis1.close();
		//--------ByteArrayInputStream-------
		byte[] bArray1 = "This is String".getBytes();
		ByteArrayInputStream bais1 = new ByteArrayInputStream(bArray1);//read the data from byte array
		int charInt3 = 0;
		while((charInt3=bais1.read())!=-1) {
			System.out.println((char)charInt3);
		}
		bais1.close();
	}

}
