/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author yangy
 */
public class MiddleShowUtil {
    public static void middleShow(Container container ) {
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize(); // 获得显示器大小对象 
        Dimension frameSize = container.getSize();             // 获得窗口大小对象  
        if (frameSize.width > displaySize.width) {
            frameSize.width = displaySize.width;           // 窗口的宽度不能大于显示器的宽度  
        }
        container.setLocation((displaySize.width - frameSize.width) / 2,
                (displaySize.height - frameSize.height) / 2); // 设置窗口居中显示器显示  
        // 设置窗口为可见的，默认为不可见  
    }
}
