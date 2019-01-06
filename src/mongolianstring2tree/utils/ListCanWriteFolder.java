/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree.utils;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author yangy
 */
public class ListCanWriteFolder {

    public static ArrayList<File> getListCanWriteFolder(String rootPath) {
        File file = new File(rootPath);
        File[] files = file.listFiles();
        ArrayList<File> finaFileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() && !files[i].isHidden() && files[i].canWrite()) {
                finaFileList.add(files[i]);
            }
        }
        if (finaFileList.size()==0) {
           return null;
        }
        return finaFileList;
    }
    public static void main(String[] args) {
       ArrayList<File> files= getListCanWriteFolder("D:");
        System.out.println(files.size());
        for (int i = 0; i < files.size(); i++) {
            System.out.println(files.get(i));
        }
    }
}
