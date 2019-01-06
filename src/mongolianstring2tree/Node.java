/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree;

/**
 *中文节点类
 * 
 * @author yangy
 */
public class Node {

    private int id;//节点ID号
    private int parentId;//父亲节点ID号
    private String nodeName;//节点名称
    private String text;
    private int ChildNum;//孩子数
    private int level;//节点所在的层数
    private int x;
    private int y;
    public Node() {
        ChildNum = 0;
        id = -1;
        level=0;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getChildNum() {
        return ChildNum;
    }

    public void setChildNum(int ChildNum) {
        this.ChildNum = ChildNum;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + ", parentId=" + parentId + ", nodeName=" + nodeName + ", text=" + text + ", ChildNum=" + ChildNum + ", level=" + level + ", x=" + x + ", y=" + y + '}';
    }

    
   

}
