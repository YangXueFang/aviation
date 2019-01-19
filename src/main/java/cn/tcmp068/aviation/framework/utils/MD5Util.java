package cn.tcmp068.aviation.framework.utils;

import java.security.MessageDigest;
public class MD5Util {
    public static void main(String[] args) {
        System.out.println(MD5Util.MD5("50"));
    }

    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd','e', 'f'};
    /**
     * MD5加密
     * @param str  要加密的字符
     * @return 加密后的字符
     */
    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return new String(encodeHex(messageDigest.digest()));
        } catch (Exception e) {
            return null;
        }
    }

    private static char[] encodeHex(final byte[] data) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return out;
    }
    /**
     * MD5方法,用于支付
     * @param text 明文
     * @param charset 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5ForPay(String text, String charset) throws Exception {
        if(charset == null || charset.length()==0)
            charset = "UTF-8";

        byte[] bytes = text.getBytes(charset);

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);
        bytes = messageDigest.digest();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bytes.length; i ++)
        {
            if((bytes[i] & 0xff) < 0x10)
            {
                sb.append("0");
            }

            sb.append(Long.toString(bytes[i] & 0xff, 16));
        }

        return sb.toString().toLowerCase();
    }
}
