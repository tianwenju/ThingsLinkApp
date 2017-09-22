package com.delta.thingslinkapp.sockt;

import java.io.BufferedReader;
import java.io.IOException;

	/**
	 * 
	 * @team Thingslink
	 * @author Zhanqiang.Xu -- 2017-9-5
	 * @description 
	 *
	 */
public class CommonFunction {
	/**
	 * 
	 * @team Thingslink
	 * @author Zhanqiang.Xu -- 2017-9-5
	 * @description 
	 *
	 * @param str
	 */
	public static void printInfo(String str)
	{
		if(str.equals("init"))
		{
			System.err.println("***************************************");
			System.err.println("Thanks for used Thingslink.wulian.cn."); // ��ϵͳ��׼�������һ�ַ���
			System.err.println("@Author Zack.xu QQȺ��412040577 ");
			System.err.println("1�� ƽ̨ע���û�");
			System.err.println("2��ƽ̨��������AppKey��AppSec");
			System.err.println("3����������ClientID");
			System.err.println("4����¼���û��ͻ��ˣ���Ҫ���Client ģ���ʹ��");
			System.err.println("***************************************");
		}else if(str.equals("commandShow"))
		{
			System.out.println("***************************************");
			System.err.println("Thanks for used Thingslink.wulian.cn."); // ��ϵͳ��׼�������һ�ַ���
			System.err.println("@Author Zack.xu QQȺ��412040577 ");
			System.err.println("Command ˵����1��1��2��3��4�����ذ�ť��light:���صȣ�getTemp����ȡ�¶ȣ� exit���˳�");
			System.out.println("***************************************");
		}
	}
	public static String readInfo(String key,BufferedReader br)
	{
		String content="";
		System.out.println(key+":"); // ��ϵͳ��׼�������һ�ַ���
		try {
			content = br.readLine();
		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		System.out.println(key+"=" + content);
		return content;
	}
}
