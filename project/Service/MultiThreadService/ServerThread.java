import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/** 
 * Copyright 2014 Tan_ZhenQi's Studio
 * All right reserved.
 * Create on 2014-12-26
 *
 * @author author E-mail:tan_zhenqi@163.com 
 * @version create time : 2014-12-26 1:11:37
 * @class ServerThread.java
 */

/**
 * @author free
 *
 */
public class ServerThread implements Runnable{

	private Socket mSocket = null;
	private BufferedReader mBufferReader = null;
	public ServerThread(Socket sock) throws IOException
	{
		System.out.println("ServerThread");
		mSocket = sock;
		mBufferReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream(),"utf-8"));
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String content = null;
		System.out.println("ServerThread run()");
		while ((content = readFromClient()) != null)
		{
			
			System.out.println("ServerThread receiver msg = "+ content);
			for (Socket sock : MyServer.mSocketList)
			{
				OutputStream os;
				try {
					os = sock.getOutputStream();
					os.write((content + "\n").getBytes("utf-8"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private String readFromClient()
	{
		try {
			return mBufferReader.readLine();
		} catch (IOException e) {
			System.out.println("socket is disconnected:");
			try {
				mSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();				
			}

			MyServer.mSocketList.remove(mSocket);
			e.printStackTrace();
		}
		
		return null;
	}

}
