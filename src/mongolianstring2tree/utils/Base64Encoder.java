/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree.utils;

/**
 *
 * @author yangy
 */
public class Base64Encoder {  
    public static String getBASE64(String s) {    
        if (s == null)    
            return null;    
        return (new sun.misc.BASE64Encoder()).encode(s.getBytes());    
    }    
    // 将 BASE64 编码的字符串 s 进行解码   解密  
    public static String getFromBASE64(String s) {    
        if (s == null)    
            return null;    
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();    
        try {    
            byte[] b = decoder.decodeBuffer(s);    
            return new String(b);    
        } catch (Exception e) {    
            return null;    
        }    
    }    
    public static String mTOa(Object ming){  
        return Base64Encoder.getBASE64(Base64Encoder.getBASE64(Base64Encoder.getBASE64((String)ming)));  
    }  
    public static String aTOm(String an){  
        return Base64Encoder.getFromBASE64(Base64Encoder.getFromBASE64(Base64Encoder.getFromBASE64(an)));  
    }  
    public static void main(String[] args) {  
        String a = mTOa("1000十大法师打发斯蒂芬00.89".toString());  
          System.out.println(a);//加密  
          System.out.println(aTOm(a));//解密  
    }  
}  