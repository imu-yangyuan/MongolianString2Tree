/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 *
 * @author yangy
 */
public class MacAddressUtil {
     public static String getMac() {
        // TODO Auto-generated method stub
        //获取网卡，获取地址
        StringBuffer sb = new StringBuffer("");
        InetAddress ia;
        try {
            ia = InetAddress.getLocalHost();

            byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                int temp = mac[i] & 0xff;
                String str = Integer.toHexString(temp);
                if (str.length() == 1) {
                    sb.append("0" + str);
                } else {
                    sb.append(str);
                }
            }
        } catch (Exception ex) {
        }
        return sb.toString().toUpperCase();
    }
}
