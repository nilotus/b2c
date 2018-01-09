package cn.edu.jit.b2c.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ChenQF on 2018/1/7.
 */

/**
 * author : Mr.Chen
 *
 * 实现对字符串的MD5加密
 *
 */
public class MD5Util {
    public static String getMD5(String str) {
        StringBuffer strbuf = new StringBuffer();
        char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        byte[] b = str.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] md5 = md.digest(b);
        for (byte m : md5) {
            strbuf.append(chars[(m >> 4) & 0x0f]);
            strbuf.append(chars[m & 0x0f]);
        }
        return strbuf.toString();
    }
    public static void main(String[] args) {
        System.out.println(getMD5("admin"));
        System.out.println(getMD5(getMD5("admin")));
    }
}
