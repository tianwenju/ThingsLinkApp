package com.delta.thingslinkapp;

import com.delta.thingslinkapp.sockt.ByteUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * description :
 *
 * @author :  Wenju.Tian
 * @version date : 2017/9/22 10:54
 */


public class SocketUtils {



    public static final String ip="";
    public static final int port=0;



     public String init(String ip,int port,String userID,String password,String appKey,String appSec ){


         try {
             Socket mSocket=new Socket(ip,port);
             OutputStream mOutputStream = mSocket.getOutputStream();





         } catch (IOException mE) {
             mE.printStackTrace();
         }
     }
}


public String receiveMessage(Socket mSocket){


    try {
        InputStream mInputStream = mSocket.getInputStream();
        BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(mInputStream));
        String line =null;
        String text
        while((line=mBufferedReader.readLine())!=null){

            return
        }

    } catch (IOException mE) {
        mE.printStackTrace();
    }
}

    public boolean sendMessage(String msg,Socket mSocket) {

        try {
            InputStream mInputStream = mSocket.getInputStream();
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
                PrintWriter mPrintWriter;
                mPrintWriter.write(arr, 0, blen);
                write.flush();
                return true;
        } catch (IOException mE) {
            mE.printStackTrace();
        }

    }