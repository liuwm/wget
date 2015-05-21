package wget;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public class Util {

	public static void copy(FileOutputStream out, BufferedInputStream in) throws IOException {
		// TODO Auto-generated method stub
		byte[] b = new byte[4096];
		int n = 0;
		while ((n = in.read(b)) != -1) {
			out.write(b, 0, n);
		}
	}

	public static void close(BufferedInputStream in) {
		// TODO Auto-generated method stub
		try {
			if(in != null)
			in.close();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void close(FileOutputStream out) {
		// TODO Auto-generated method stub
		try{
			if(out != null){
				out.close();
			}
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void disconnect(HttpURLConnection connection) {
		// TODO Auto-generated method stub
		if(connection != null){
			connection.disconnect();
		}
	}

}
