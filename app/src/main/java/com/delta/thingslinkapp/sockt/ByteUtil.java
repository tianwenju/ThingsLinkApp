package com.delta.thingslinkapp.sockt;


public class ByteUtil {
    /**
     * ����ת��Ϊ4λ�ֽ�����
     * @param intValue
     * @return
     */
    public static byte[] int2Byte(int intValue) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
        	b[i] = (byte) (intValue >> 8 * (i) & 0xFF);//С�ֽ�
           // b[i] = (byte) (intValue >> 8 * (3 - i) & 0xFF);// ��ͷ�ֽ�
            //System.out.print(Integer.toBinaryString(b[i])+" ");
            //System.out.print((b[i] & 0xFF) + " ");
        }
        return b;
    }

    /**
     * 4λ�ֽ�����ת��Ϊ����
     * @param b
     * @return
     */
    public static int byte2Int(byte[] b) {
        int intValue = 0;
        for (int i = 0; i < b.length; i++) {
            intValue += (b[i] & 0xFF) << (8 * (3 - i));// Сͷ�ֽڶ�
            //intValue += (b[i] & 0xFF) << (8 * (i));// ��ͷ���ֽ�
        }
        return intValue;
    }

    public static int byteArrayToInt(byte[] b, int offset) {
	       int value= 0;
	       for (int i = 0; i < 4; i++) {
	           int shift= (4 - 1 - i) * 8;
	           value +=(b[i + offset] & 0x000000FF) << shift;
	       }
	       return value;
	 }
    
	public static byte[] intToByteArray(final int integer) {
		int byteNum = (40 - Integer.numberOfLeadingZeros(integer < 0 ? ~integer : integer)) / 8;
		byte[] byteArray = new byte[4];
		for (int n = 0; n < byteNum; n++)
			byteArray[n] = (byte) (integer >>> (n * 8));
		return (byteArray);
	}  
    
    
}
