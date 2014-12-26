/** 
* Copyright 2014 Tan_ZhenQi's Studio
* All right reserved.
* Create on 2014-12-26
*
* @author author E-mail:tan_zhenqi@163.com 
* @version create time : 2014-12-26 10:23:11
* @class SimpleService.java
*/ 

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author free
 *
 */
public class SimpleService {
	
	public static void main(String[] args) throws IOException
	{

		ServerSocket ss = new ServerSocket(30000);
		while (true) 
		{
			Socket s = ss.accept();
			System.out.print("accept connect:" + s.getLocalSocketAddress().toString());
			OutputStream os = s.getOutputStream();
			os.write("Hello,happy new year!!!!\n ".getBytes());
			os.close();
			s.close();
		}
		
	}

}
