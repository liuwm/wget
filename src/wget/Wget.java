package wget;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Wget {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = args[0];
		Wget wget = new Wget();
		//String url = "http://www.baidu.com";
		boolean bool = wget.saveFile(url);
		System.out.println(bool);
	}
	
	/**
	 * 获取指定url的内容
	 * @param url
	 */
	public boolean saveFile(String url){
		URL strUrl = null;
		HttpURLConnection connection = null;
		BufferedInputStream in = null;
		FileOutputStream out = null;
		try{
			strUrl = new URL(url);
			connection = (HttpURLConnection) strUrl.openConnection();
			connection.setConnectTimeout(2*1000);
            connection.setReadTimeout(2*1000); 
            try{
            	connection.connect();

				in = new BufferedInputStream(connection.getInputStream());
				String str = HttpURLConnection.guessContentTypeFromStream(in);
				if(str == null){
					str = HttpURLConnection.guessContentTypeFromName(url);
				}
				//connection.setInstanceFollowRedirects(false);
				//String filenameString = connection.getHeaderField("location");
				String filenameString  = strUrl.getFile();
				String filename;
				if(filenameString == ""){
					String postfix = str.split("/")[1];
					filename = url.split("//")[1] + "." + postfix; 
				}else{
					String[] strings = filenameString.split("/");
					filename = strings[strings.length-1];
				}
				//System.out.println(filename);
				//System.out.println(postfix);
	            
	            File dir = new File("d:/wget/");
	            File file = new File(dir,filename);
	            out = new FileOutputStream(file);
	            
	            Util.copy(out, in); 
            }catch (Exception e) {
            	System.out.println("Error getURL:" + url);
            	return false;
			}
		}catch (IOException e) {  
            System.out.println("Error getURL:" + url);
            return false;
        }finally  
        {  
            Util.close(in);
            Util.close(out);
            Util.disconnect(connection); 
        }
		return true;
	}

}
