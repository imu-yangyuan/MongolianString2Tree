/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import static mongolianstring2tree.utils.Base64Encoder.aTOm;
import static mongolianstring2tree.utils.Base64Encoder.mTOa;

/**
 *
 * @author yangy
 */
public class EncryptionAndDecryptionUtil {

    public static String Encryption(String str) throws Exception {
        String temp = mTOa(str);
        EncryptionDecryption des = new EncryptionDecryption("plgy_y");// 自定义密钥
        return des.encrypt(temp);
    }

    public static String Decryption(String str) throws Exception {
        EncryptionDecryption des = new EncryptionDecryption("plgy_y");// 自定义密钥
        String string = des.decrypt(str);
        return aTOm(string);
    }

    public static void main(String[] args) {
        try {
            System.out.println( Encryption("safdsadfasf"));
            System.out.println(Decryption(Encryption("safdsadfasf"))); 
        } catch (Exception ex) {
            Logger.getLogger(EncryptionAndDecryptionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
