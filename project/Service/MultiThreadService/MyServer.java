import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/** 
 * Copyright 2014 Tan_ZhenQi's Studio
 * All right reserved.
 * Create on 2014-12-26
 *
 * @author author E-mail:tan_zhenqi@163.com 
 * @version create time : 2014-12-26 time 1:11:22
 * @class MyServer.java
 */

/**
 * @author free
 *
 */
public class MyServer {
	
	public static ArrayList<Socket> mSocketList = new ArrayList<Socket>();
	
	public static void main(String [] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(30001);
		while(true)
		{
			Socket s = ss.accept();
			mSocketList.add(s);
			System.out.println("current number is : " + mSocketList.size());
			new Thread(new ServerThread(s)).start();
		}
	}
	
}
