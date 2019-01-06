/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *建立蒙文节点工具类
 * @author yangy
 */
public class MongolianUtil {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\蒙文.txt"));
            String text = null;

//                while (true) {
//                    text = bufferedReader.readLine();
//                    if(text!=null){
//                        break;
//                    }
//                    BuildTree(text);
//                    
//                }
            // text = bufferedReader.readLine();
            // BuildTree(text);
           // BuildTree("[NP-d [GP BATVLA/Ve1+HV/Ft12 TVHAI/Gt] T0D0RHAI/Ac+L/L+A/Zv2+LTA/LTA]");
            BuildTree("[s [VP-u [NP-d UILECILEGE/Ne2+N/Zx-U/Fc12 ARALJIY_A/Ne1] [VP-b TURGEN/Ac HOGJI/Ve2+BE/Fs14]] ./Wp1] ");
            // BuildTree("[s [VP-h [VP-s [VP-t [NP-d [VP-t [NP-d TVHAI/Gt-YIN/Fc11 HOMON/Ne1-DU/Fc21 ] [VP-b [GP HAVLI/Ne1 Y0S0GAR/Ga ] MEDE/Ve1+GDE/Fe21+HU/Ft12 ] ] EGURGE/Ne1-YI/Fc31 ] [VP-b CINGGADH_A/Ve1+N/Fn3 JIRVM/Ne1+JI/Fs12+GVL/Fe11+JV/Fn1 ]] ,/Wp1 ] [VP-b [NP-d [VP-x [VP-h [VP-h [VP-h [VP-s [VP-b [VP-b HEREG/Ne1 B0LG_A/Ve1+N/Fn3 ] DANGSALA/Ve1+GVL/Fe11+HV/Ft12 ] ,/Wp1 ] [VP-s [VP-h SIGU/Ve1+N/Fn3 TASVL/Ve1+HV/Ft12 ] ,/Wp1 ] ] [VP-s GUICEDHE/Ve1+HU/Ft12 ,/Wp1 ] ] [VP-b [NP-d SIGU/Ve1+N/Fn3 TASVLVLTA/Ne2-DV/Fc21 ] [VP-t HINALTA/Ne2 TALBI/Ve1+HV/Ft12 ]] ] JERGE/Gx ] JANGGILAG_A/Ne1-DV/Fc21 ] [VP-t [NP-d [NP-d [VP-t [NP-d [NP-d [VP-u [NP-d [NP-d TVHAI/Gt-YIN/Fc11 HOMON/Ne1-U/Fc12 ] [NP-d [VP-d SIGU/Ve1+N/Fn3 TASVL/Ve1+HV/Ft12 ] ERHE/Ne1-YIN/Fc11 ] ] [VP-s YABV/Ve2+GDA/Fe21+JV/Fn1 BAI/Vz2+G_A/Ft22 ] ] YABVCA/Ne1-DAHI/Fh3 ] BAIDAL/Ne2-I/Fc31 ] [VP-h 0ILG_A/Ve1+N/Fn3 MEDE/Ve1+HU/Ft12 ] ] [NP-d TVHAI/Gt-YIN/Fc11 HOMON/Ne1-U/Fc11 ] ] ERHE/Ne2-YI/Fc31 ] BATVLA/Ve1+BA/Fs14 ] ] ] ./Wp1 ] ");

        } catch (FileNotFoundException ex) {
        }
    }

    public static List<MongolianNode> BuildTree(String str) {
        Stack<Integer> myStack = new Stack<Integer>();
        List<MongolianNode> Nodes = new ArrayList<MongolianNode>();
        int nodeId = 0;
        if (str != null || "".equals(str)) {
            String strTempString=str;
            strTempString=strTempString.replace("]"," ");
            System.out.println(strTempString);
            char[] chars = strTempString.toCharArray();
            boolean haveGarbage = false;
            int startindex = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '[') {
                    if (i != 0) {
                        haveGarbage = true;
                        startindex = i;
                    }
                    break;
                }
            }
            int m = 0;
            if (haveGarbage) {
                m = startindex;
            }
            //生成节点并为每个节点赋一个ID号
            StringBuffer nodeName = new StringBuffer();
            for (; m < chars.length;) {
                if ('[' != chars[m] && ']' != chars[m]) {
                    if (' ' != chars[m]) {
                        nodeName.append(chars[m]);
                        m++;
                    } else if (!"".equals(nodeName.toString())) {
                        m++;
                        MongolianNode node = new MongolianNode();
                        node.setId(nodeId);
                        node.setNodeName(nodeName.toString());
                        nodeName = new StringBuffer("");
                        if (nodeId == 0) {
                            node.setParentId(-1);
                        }
                        Nodes.add(node);
                        nodeId++;
                    } else {
                        m++;
                    }
                } else {
                    m++;
                }
            }
            for (int i = 0; i < Nodes.size(); i++) {
                System.out.println(Nodes.get(i));
            }
            int nodeIndex = 0;
            boolean rootFlag = false;
            chars=str.toCharArray();
            //第二遍扫描字符串，为每个节点赋值ParentId
            StringBuffer stringBufferTestHave = new StringBuffer("");
            for (int i = startindex; i < chars.length; i++) {
                if ('[' == chars[i]) {
                    if (!rootFlag) {
                        myStack.add(Nodes.get(nodeIndex).getId());
                        nodeIndex++;
                        rootFlag = true;
                    } else {
                        Nodes.get(nodeIndex).setParentId(myStack.peek());
                        int parentChildNum = Nodes.get(myStack.peek()).getChildNum();
                        Nodes.get(myStack.peek()).setChildNum(++parentChildNum);
                        myStack.add(Nodes.get(nodeIndex).getId());
                        nodeIndex++;
                    }
                } else if (']' == chars[i]) {
                    if (' ' != chars[i - 1]&&']'!=chars[i-1]) {
                       if ("".equals(stringBufferTestHave.toString())) {
                        continue;
                    } else if (!Nodes.get(myStack.peek()).getNodeName().equals(stringBufferTestHave.toString())) {
                        System.out.println("stringBufferTestHave.toString()" + stringBufferTestHave.toString());
                        // System.out.println("Pid"+myStack.peek());
                        // System.out.println("test"+Nodes.get(nodeIndex-1));
                        int temp = myStack.peek();
                        Nodes.get(nodeIndex).setParentId(temp);
                        int parentChildNum = Nodes.get(myStack.peek()).getChildNum();
                        Nodes.get(myStack.peek()).setChildNum(++parentChildNum);
                        stringBufferTestHave = new StringBuffer("");
                        nodeIndex++;
                    } else {
                        stringBufferTestHave = new StringBuffer("");
                    }

                    }
                    myStack.pop();
                } else if (' ' == chars[i]) {
                    if ("".equals(stringBufferTestHave.toString())) {
                        continue;
                    } else if (!Nodes.get(myStack.peek()).getNodeName().equals(stringBufferTestHave.toString())) {
                        int temp = myStack.peek();
                        Nodes.get(nodeIndex).setParentId(temp);
                        int parentChildNum = Nodes.get(myStack.peek()).getChildNum();
                        Nodes.get(myStack.peek()).setChildNum(++parentChildNum);
                        stringBufferTestHave = new StringBuffer("");
                        nodeIndex++;
                    } else {
                        stringBufferTestHave = new StringBuffer("");
                    }

                } else {
                    stringBufferTestHave.append(chars[i]);
                }

            }

            int level = 0;
            /**
             * 计算节点在的层数
             */
            for (int i = 0; i < Nodes.size(); i++) {
                if (Nodes.get(i).getChildNum() == 0) {

                    MongolianNode parentNode = Nodes.get(Nodes.get(i).getParentId());
                    level = 0;
                    while (parentNode.getId() != 0) {
                        level++;
                        if (level > parentNode.getLevel()) {
                            parentNode.setLevel(level);
                        }
                        parentNode = Nodes.get(parentNode.getParentId());
                    }
                    level++;
                    if (level > parentNode.getLevel()) {
                        parentNode.setLevel(level);
                    }
                }
            }
            int baseX = 100;
            int baseY = 30;
            int addX = 225;
            int addY = 60;
            //计算每个节点的X,Y坐标
            for (int i = 0; i <= Nodes.get(0).getLevel(); i++) {
                int thisLevelNodeNum = 0;
                for (int j = 0; j < Nodes.size(); j++) {
                    if (i == Nodes.get(j).getLevel()) {
                        if (0 == i) {
                            Nodes.get(j).setX(baseX + thisLevelNodeNum * addX);
                            thisLevelNodeNum++;
                        } else {
                            int childNum = Nodes.get(j).getChildNum();
                            int x = 0;
                            for (int k = 0; k < Nodes.size(); k++) {
                                if (Nodes.get(j).getId() == Nodes.get(k).getParentId()) {
                                    x += Nodes.get(k).getX();
                                }
                            }
                            Nodes.get(j).setX(x / childNum);
                        }
                    }
                }
            }
            int level1 = Nodes.get(0).getLevel();
            for (int i = 0; i < Nodes.size(); i++) {
                Nodes.get(i).setY(baseY + addY * (level1 - Nodes.get(i).getLevel()));
            }
        }

//        for (int i = 0; i < Nodes.size(); i++) {
//            System.out.println(Nodes.get(i));
//        }
        return Nodes;
    }
    
}
