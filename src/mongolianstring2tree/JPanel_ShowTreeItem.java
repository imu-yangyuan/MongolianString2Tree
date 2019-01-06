/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yangy
 */
public class JPanel_ShowTreeItem  extends JPanel {
private List<Node> nodes;
    public JPanel_ShowTreeItem(List<Node> nodes) {
        this();setLayout(null);
        this.nodes=nodes;
      showStaticText();
    }

    public JPanel_ShowTreeItem() {
    }

    @Override
    public void paint(Graphics g) {
       super.paint(g);
    
    }
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		    Graphics2D g2 = (Graphics2D) g;
            for (int i = 0; i < nodes.get(0).getLevel(); i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    if (i==nodes.get(j).getLevel()) {
                        int startx,starty,endx,endy;
                        startx=nodes.get(j).getX();
                        starty=nodes.get(j).getY();
                      endx= nodes.get(nodes.get(j).getParentId()).getX();
                      endy=nodes.get(nodes.get(j).getParentId()).getY();
                       // Color color=new Color(j, j, j);
                       g2.setColor(Color.MAGENTA);
                      g2.setStroke(new BasicStroke(3f));
                      g2.draw(new Line2D.Double(startx, starty, endx, endy));
                    }
                }
            }
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i).getChildNum()!=0) {
                    g2.setColor(Color.black);
                      g2.setStroke(new BasicStroke(1f));
              Rectangle2D rect = new Rectangle2D.Double(nodes.get(i).getX()-25,nodes.get(i).getY()-10,50,20);
              g2.draw(rect);
                }else{
                g2.setColor(Color.black);
                      g2.setStroke(new BasicStroke(1f));
              Rectangle2D rect = new Rectangle2D.Double(nodes.get(i).getX()-40,nodes.get(i).getY()-10,80,20);
              g2.draw(rect);
                }
                 
            }
	}
        private void showStaticText(){
         for (int i = 0; i < nodes.size(); i++) {
              JLabel jLabel=new JLabel(nodes.get(i).getNodeName()+"   "+nodes.get(i).getText());
              if (nodes.get(i).getChildNum()==0){
                  jLabel.setBounds(nodes.get(i).getX()-36,nodes.get(i).getY()-10,100,20);
              this.add(jLabel);
              }else{
              jLabel.setBounds(nodes.get(i).getX()-23,nodes.get(i).getY()-10,100,20);
              this.add(jLabel);
              }
            }
        }
} 