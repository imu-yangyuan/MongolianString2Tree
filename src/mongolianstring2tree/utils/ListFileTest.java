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
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListFileTest {

    public static void main(String[] args) {
        File file = new File("C:");
        File[] files = file.listFiles();
        ArrayList<File> finaFileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() && !files[i].isHidden() && files[i].canWrite()) {
                finaFileList.add(files[i]);
            }
        }
//         for (int i = 0; i < finaFileList.size(); i++) {
//             if (i==0) {
//                 File buildFile=new File(finaFileList.get(i).getAbsolutePath()+"\\test.txt");
//                 if (!buildFile.exists()) {
//                     try {
//                         System.out.println("asdf");
//                         buildFile.createNewFile();
//                         
//                     } catch (IOException ex) {
//                     }
//                 }
//
//             }
//            System.out.println(finaFileList.get(i));
//        }
        for (int i = 0; i < finaFileList.size(); i++) {
            Random rand = new Random();
            int randNum = rand.nextInt(finaFileList.size());
            System.out.println(randNum);
        }

    }

    public ListFileTest() {
        String s = new String("(VP (ADVP (AD 大力))(VP (VV 加强)(NP (NN 文化)(NN 建设)))))");
    }

}
