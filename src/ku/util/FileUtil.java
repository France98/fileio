package ku.util;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;

public class FileUtil {

	/**
	 * Copy the InputStream to the OutputStream one byte at a time.
	 * @param in is the InputStream to read.
	 * @param out the OutputStream to write.
	 */
	static void copy(InputStream in,OutputStream out){
		try {
			int b;
			while((b = in.read()) >= 0){
				out.write(b);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * Copy the InputStream to the OutputStream using a byte array of size blocksize.
	 * @param in is the InputStream to read.
	 * @param out is the OutputStream to write.
	 * @param blocksize is a size of array.
	 */
	static void copy(InputStream in,OutputStream out , int blocksize){
		try {
			byte[] buffer = new byte[blocksize];
			int size;
			while((size = in.read(buffer) ) > 0){
				out.write(buffer, 0, size);				
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * Copy the InputStream to the OutputStream using BufferedReader to read the InputStream and Printwriter to write the OutputStream.
	 * Read and write one line at a time.
	 * @param in is the InputStream to read.
	 * @param out the OutputStream to write.
	 */
	static void bcopy(InputStream in,OutputStream out){
		Reader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader (reader);
		String line;
		PrintWriter writer = new PrintWriter(out);
		try {
			while((line = br.readLine()) != null){
				writer.println(line);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
	}
}
