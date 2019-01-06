/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree.utils;

/**
 *中文不行
 * @author yangy
 */
public class MD5Test {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
      //  System.out.println(decrypt("137%128%143%145%124%144%135%143%76%"));  
          
        System.out.println(encrypt("sdafsfasdyangj21424")); 
        System.out.println(decrypt(encrypt("sdafsfasdyangj21424")));  
    }  
      
    /** 
       *用户名解密 
       *@param ssoToken 字符串 
       *@return String 返回加密字符串 
      */  
      public static String decrypt(String ssoToken)  
      {  
        try  
        {  
          String name = new String();  
          java.util.StringTokenizer st=new java.util.StringTokenizer(ssoToken,"%");  
          while (st.hasMoreElements()) {  
            int asc =  Integer.parseInt((String)st.nextElement()) - 27;  
            name = name + (char)asc;  
          }  
  
          return name;  
        }catch(Exception e)  
        {  
          e.printStackTrace() ;  
          return null;  
        }  
      }  
  
      /** 
       *用户名加密 
       *@param ssoToken 字符串 
       *@return String 返回加密字符串 
      */  
      public static String encrypt(String ssoToken)  
      {  
        try  
        {  
         // byte[] _ssoToken = ssoToken.getBytes("ISO-8859-1");  
          byte[] _ssoToken = ssoToken.getBytes("UTF-8");  
          String name = new String();  
         // char[] _ssoToken = ssoToken.toCharArray();  
          for (int i = 0; i < _ssoToken.length; i++) {  
              int asc = _ssoToken[i];  
              _ssoToken[i] = (byte) (asc + 27);  
              name = name + (asc + 27) + "%";  
          }  
          return name;  
        }catch(Exception e)  
        {  
          e.printStackTrace() ;  
          return null;  
        }  
      }  
}  