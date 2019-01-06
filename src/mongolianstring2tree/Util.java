/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 *建立中文节点工具类
 * @author yangy
 */
public class Util {
    public static List<Node> BuildTree(String str){
            // TODO code application logic here
            Stack<Integer> myStack = new Stack<Integer>();
            List<Node> Nodes = new ArrayList<Node>();
            int nodeId = 0;
             if (str != null || "".equals(str)) {
                    char[] chars = str.toCharArray();
                    /**
                     * 扫描第一遍建立节点
                     */
                    for (int i = 0; i < chars.length;) {
                        if ('(' == chars[i]) {
                            i++;
                            boolean flag = false;
                            StringBuffer nodeName = new StringBuffer();
                            StringBuffer nodeText = new StringBuffer();
                            while (true) {
                                //System.out.println(chars[i]);
                                if ('(' != chars[i] && ')' != chars[i]) {
                                    if (!flag) {
                                        if (' ' != chars[i]) {
                                            nodeName.append(chars[i]);
                                            i++;
                                        } else {
                                            i++;
                                            flag = true;
                                        }
                                    } else {
                                        //System.out.println(chars[i]);
                                        nodeText.append(chars[i]);
                                        i++;
                                    }
                                } else {
                                    Node node = new Node();
                                    node.setId(nodeId);
                                    node.setNodeName(nodeName.toString());
                                    node.setText(nodeText.toString());
                                    if (nodeId == 0) {
                                        node.setParentId(-1);
                                    }
                                    Nodes.add(node);
                                    nodeId++;
                                    break;
                                }
                            }
                        } else if (')' == chars[i]) {
                            i++;
                        } else if ('(' != chars[i]) {
                            i++;
                        }

                    }

                    int nodeIndex = 0;
                    boolean rootFlag = false;
                    /**
                     *扫描第二遍为每个节点指定ParentId
                     */
                    for (int i = 0; i < chars.length; i++) {
                        if ('(' == chars[i]) {
                            if (!rootFlag) {
                                myStack.add(Nodes.get(nodeIndex).getId());
                                nodeIndex++;
                                rootFlag=true;
                            } else {
                                Nodes.get(nodeIndex).setParentId(myStack.peek());
                                 int parentChildNum=Nodes.get(myStack.peek()).getChildNum();
                                Nodes.get(myStack.peek()).setChildNum(++parentChildNum);
                                myStack.add(Nodes.get(nodeIndex).getId());
                                nodeIndex++;
                            }

                        } else if (')' == chars[i]) {
                            myStack.pop();
                        }
                    }
                    
                     int level=0;
                     /**
                      * 计算每个节点所在的层数
                      */
                    for (int i = 0; i < Nodes.size(); i++) {
                       if(Nodes.get(i).getChildNum()==0){
                           Node parentNode=Nodes.get(Nodes.get(i).getParentId());
                           level=0;
                           while (parentNode.getId()!=0) {
                               level++;
                               if(level>parentNode.getLevel()){
                                   parentNode.setLevel(level);
                               }
                               parentNode=Nodes.get(parentNode.getParentId());
                           }
                           level++;
                            if(level>parentNode.getLevel()){
                                parentNode.setLevel(level);
                               }
                       } 
                    }
                    int baseX=100;
                    int baseY=50;
                    int addX=100;
                    int addY=50;
                    /**
                     * 计算每个节点的X,Y坐标
                     */
                    for (int i = 0; i <= Nodes.get(0).getLevel(); i++) {
                        int thisLevelNodeNum=0;
                        for (int j = 0; j < Nodes.size(); j++) {
                            if(i==Nodes.get(j).getLevel()){
                                if(0==i){
                                     Nodes.get(j).setX(baseX+thisLevelNodeNum*addX);
                                      thisLevelNodeNum++;
                                }else{
                                    int childNum=Nodes.get(j).getChildNum();
                                    int x=0;
                                    for (int k = 0; k < Nodes.size(); k++) {
                                        if (Nodes.get(j).getId()==Nodes.get(k).getParentId()) {
                                            x+=Nodes.get(k).getX();
                                        }
                                    }
                                    Nodes.get(j).setX(x/childNum);
                                }
                            }
                        }
                    }
//                    for (int i = Nodes.get(0).getLevel(); i >=0; i--) {
//                        int thisLevelNodeNum=0;
//                        for (int j = 0; j < Nodes.size(); j++) {
//                            if(i==Nodes.get(j).getLevel()){
//                                
//                               
//                            }
//                        }
//                    }
                    int level1=Nodes.get(0).getLevel();
                    for (int i = 0; i < Nodes.size(); i++) {
                        Nodes.get(i).setY(baseY+addY*(level1-Nodes.get(i).getLevel()));
                    }
                    
                }
                
            

            // System.out.println(str);
//            for (int i = 0; i < Nodes.size(); i++) {
//                System.out.println(Nodes.get(i));
//            }
    return Nodes;
    }
}
