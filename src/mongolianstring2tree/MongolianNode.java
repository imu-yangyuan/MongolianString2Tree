/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree;

/**
 *蒙文节点类
 * @author yangy
 */
public class MongolianNode {
     private int id;//该节点的id号
    private int parentId;//父亲节点的id号
    private String nodeName;//节点名称
    private int ChildNum;//孩子数
    private int level;//层数
    private int x;
    private int y;
    public MongolianNode() {
        ChildNum = 0;
        id = -1;
        parentId=-99;
        level=0;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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
        return "Node{" + "id=" + id + ", parentId=" + parentId + ", nodeName=" + nodeName + ", ChildNum=" + ChildNum + ", level=" + level + ", x=" + x + ", y=" + y + '}';
    }

}
