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
import java.io.IOException;
import java.util.Scanner;

public class CpuUtil {

    public static void main(String[] args) throws IOException {
        try {  
        long start = System.currentTimeMillis();  
        Process process = Runtime.getRuntime().exec(  
        new String[] { "wmic", "cpu", "get", "ProcessorId" });  
        process.getOutputStream().close();  
        Scanner sc = new Scanner(process.getInputStream());  
        String property = sc.next();  
        String serial = sc.next();  
        System.out.println(property + ": " + serial);  
        System.out.println("time:" + (System.currentTimeMillis() - start));  
    } catch (IOException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    }  
       // System.out.println( "cpu: " + getCpu());

    }

    public static String getCpu() throws IOException {
        long start = System.currentTimeMillis();

        Process process = Runtime.getRuntime().exec(
                new String[]{"wmic", "cpu", "get", "ProcessorId"});

        process.getOutputStream().close();

        Scanner sc = new Scanner(process.getInputStream());

        String property = sc.next();

        String serial = sc.next();
        return serial;
    }
}
