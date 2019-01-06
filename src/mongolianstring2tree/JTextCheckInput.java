/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author yangy
 */
public class JTextCheckInput extends JFrame{  
    private JTextField textField1;
    public JTextCheckInput(){  
        this.setTitle("激活码输入");  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setBounds(100, 100, 600, 250);  
        JPanel contentPane=new JPanel();  
        contentPane.setBorder(new EmptyBorder(80,5,5,5));  
        this.setContentPane(contentPane);  
        contentPane.setLayout(new GridLayout(3,1,5,5));  
        JPanel pane1=new JPanel();  
        contentPane.add(pane1);  
        
        JLabel label1=new JLabel("激活码：");  
          
        textField1=new JTextField();  
        textField1.setColumns(40);  
        pane1.add(label1);  
        pane1.add(textField1);  
       MiddleShowUtil.middleShow(this);
        this.setVisible(true);  
    }  
    public static void main(String[]args){  
        JTextCheckInput example=new JTextCheckInput();  
    }  
}  
