package com.delta.thingslinkapp.sockt;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @team Thingslink
 * @author Zack.Xu -- 2017-9-2
 * @description
 * 
 */
public class ThingslinkUserControl {

	static PrintWriter write;
	static BufferedReader in;
	private static List<String> m_names;
	public List<String> Names;// { get { return m_names; } }
	private static List<String> m_values;
	public List<String> Values;// { get { return m_values; } }
	private static Socket mSocket;

	public static Socket getSocket() {
		return mSocket;
	}

	/**
	 * @team Thingslink
	 * @author Zack.Xu -- 2017-8-31
	 * @description
	 * 
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		m_names = new ArrayList();
		m_values = new ArrayList();
		// TODO �Զ����ɵķ������
		initSocket();

	}

//	/**
//	 *
//	 * @team Thingslink
//	 * @author Zack.Xu -- 2017-9-2
//	 * @description
//	 *
//	 */
//	public static void initSocket() {
//		try {
//			// 1�������ͻ���Socket��ָ����������ַ�Ͷ˿�
//			// Socket socket = new Socket("127.0.0.1", 5080);
//			mSocket = new Socket("123.57.38.163", 5080);
//			System.out.println("�ͻ��������ɹ�");
//			// 2����ȡ���������������˷�����Ϣ
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
//			// ��ϵͳ��׼�����豸����BufferedReader����
//			write = new PrintWriter(mSocket.getOutputStream());
//			// ��Socket����õ��������������PrintWriter����
//			// 3����ȡ������������ȡ�������˵���Ӧ��Ϣ
//			in = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "UTF-8"));
//			char[] buf = new char[1];
//			buf[0] = (char) 2;
//			write.write(buf);
//			write.flush();
//			// ��Socket����õ�����������������Ӧ��BufferedReader����
//			boolean isLogin = false;
//			while (!isLogin) {
//				String appKey, appSec, userID, password;
//				CommonFunction.printInfo("init");
//				appKey=CommonFunction.readInfo("AppKey", br);
//				appSec=CommonFunction.readInfo("AppKey", br);
//				userID=CommonFunction.readInfo("UserID", br);
//				password=CommonFunction.readInfo("Password", br);
//				String str =
//						"Command=Login\r\nAppSec=" + appSec + "\r\nAppKey=" + appKey + "\r\nUserName=" + userID
//							+ "\r\nPassword=" + password + "\r\n";
//				sendMessage(str);
//				if (recvContext()) {
//					if (m_values.get(m_names.indexOf("code")).equals("0")) {
//						System.out.println("��¼�ɹ���");
//						isLogin = true;
//					} else {
//						System.err.println("��¼ʧ�ܣ�");
//					}
//				}
//			}
//			String clientID = null, commandText;
//			while (true) {
//				if (clientID == null) {
//					CommonFunction.printInfo("init");
//					clientID=CommonFunction.readInfo("ClientID", br);
//				}
//				CommonFunction.printInfo("commandShow");
//				commandText=CommonFunction.readInfo("Command", br);
//				if (commandText.equals("exit")) {
//					break;
//				}
//				String command = "Command=Route\r\nClientID=" + clientID + "\r\nItem=" + commandText;
//				sendMessage(command);
//				recvContext();
//				System.out.println(m_values.get(m_names.indexOf("item")));
//			}
//			in.close();
//			write.close();
//			mSocket.close();
//			br.close();
//		} catch (Exception e) {
//			System.out.println("can not listen to:" + e);// ������ӡ������Ϣ
//		}
//	}
	public static void initSocket(String ip,int port,String userID,String password,String appKey,String appSec ) {
		{
			try {
				// 1�������ͻ���Socket��ָ����������ַ�Ͷ˿�
				// Socket socket = new Socket("127.0.0.1", 5080);

				Socket socket = new Socket(ip, port);

				System.out.println("�ͻ��������ɹ�");
			//
				write = new PrintWriter(socket.getOutputStream());
				// ��Socket����õ��������������PrintWriter����
				// 3����ȡ������������ȡ�������˵���Ӧ��Ϣ
				in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

				char[] buf = new char[1];
				buf[0] = (char) 2;
				write.write(buf);
				write.flush();
				// ��Socket����õ�����������������Ӧ��BufferedReader����
				boolean isLogin = false;

					String str =
							"Command=Login\r\nAppSec=" + appSec + "\r\nAppKey=" + appKey + "\r\nUserName=" + userID
									+ "\r\nPassword=" + password + "\r\n";
					sendMessage(str);
					if (recvContext()) {
						if (m_values.get(m_names.indexOf("code")).equals("0")) {
							System.out.println("��¼�ɹ���");
							isLogin = true;
						} else {
							System.err.println("��¼ʧ�ܣ�");
						}
					}
//				in.close();
//				write.close();
//				socket.close();
			} catch (Exception e) {
				System.out.println("can not listen to:" + e);// ������ӡ������Ϣ
			}
		}

	}

//	void sendMessage(final Handler mHandler){
//
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				mHandler.sendMessage()
//			}
//		})
//
//	}
//	public void sendMessage(){
//		if (clientID == null) {
//			CommonFunction.printInfo("init");
//			clientID=CommonFunction.readInfo("ClientID", br);
//		}
//		CommonFunction.printInfo("commandShow");
//		commandText=CommonFunction.readInfo("Command", br);
//		if (commandText.equals("exit")) {
//			break;
//		}
//		String command = "Command=Route\r\nClientID=" + clientID + "\r\nItem=" + commandText;
//		sendMessage(command);
//		recvContext();
//		System.out.println(m_values.get(m_names.indexOf("item")));
//	}

	/**
	 * 
	 * @team Thingslink
	 * @author Zack.Xu -- 2017-9-2
	 * @description
	 * 
	 * @return
	 */
	private static Boolean recvContext() {

		char[] buffer = new char[1024];
		try {
			in.read(buffer, 0, 4);
			byte[] len = new byte[4];
			for (int ii = 0; ii < 4; ii++) {
				len[3 - ii] = (byte) buffer[ii];// �ߵ�Ϊת��
			}
			int packetLength = ByteUtil.byte2Int(len);
			in.read(buffer, 0, packetLength + 4);
			for (int ii = 0; ii < 4; ii++) {
				len[3 - ii] = (byte) buffer[ii];// �ߵ�Ϊת��
			}
			String tmpStr = String.valueOf(buffer, 4, packetLength);
			DecodeProtocolText(tmpStr);
		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * @team Thingslink
	 * @author Zack.Xu -- 2017-9-2
	 * @description
	 * 
	 * @param protocolText
	 * @return
	 */
	public static Boolean DecodeProtocolText(String protocolText) {

		m_names.clear();
		m_values.clear();
		int speIndex = protocolText.indexOf("\r\n");
		if (speIndex < 0) {
			String[] tmpStr1 = protocolText.split("=");
			if (tmpStr1.length > 1) // ���ڵȺ�
			{
				if (tmpStr1.length > 2) // ���������Ⱥţ�����ʧ��
					return false;
				if (tmpStr1[0].equals("Command")) {
				} else {
					m_names.add(tmpStr1[0].toLowerCase());
					m_values.add(tmpStr1[1].toString());
				}
			}
			return true;
		} else {
			String[] tmpNameValues = protocolText.split("\r\n");
			if (tmpNameValues.length < 2) // ÿ���������ٰ�������
				return false;
			for (int i = 0; i < tmpNameValues.length; i++) {
				String[] tmpStr = tmpNameValues[i].split("=");
				if (tmpStr.length > 1) // ���ڵȺ�
				{
					if (tmpStr.length > 2) // ���������Ⱥţ�����ʧ��
						return false;
					if (tmpStr[0].equals("Command")) {
					} else {
						m_names.add(tmpStr[0].toLowerCase());
						m_values.add(tmpStr[1]);
					}
				} else {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * 
	 * @team Thingslink
	 * @author Zack.Xu -- 2017-9-2
	 * @description
	 * 
	 * @param msg
	 * @return
	 */
	private static Boolean sendMessage(String msg) {

		byte[] Buffer = new byte[1024];
		byte[] len = new byte[4];
		int blen = 0;
		byte[] bufferUTF8;
		try {
			bufferUTF8 = msg.getBytes("UTF8");
			int i = bufferUTF8.length + 4;
			len = ByteUtil.intToByteArray(i);
			System.arraycopy(len, 0, Buffer, 0, len.length);
			blen = len.length;
			len = ByteUtil.int2Byte(i - 4);// intToByteArray(i - 4);
			System.arraycopy(len, 0, Buffer, blen, len.length);
			blen = blen + len.length;
			System.arraycopy(bufferUTF8, 0, Buffer, blen, bufferUTF8.length);
			blen = blen + bufferUTF8.length;
			int len2 = Buffer.length;
			char[] arr = new char[len2];
			for (int ii = 0; ii < len2; ii++) {
				arr[ii] = (char) Buffer[ii];
			}
			write.write(arr, 0, blen);
			write.flush();
			return true;
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
			return false;
		}
	}
}
