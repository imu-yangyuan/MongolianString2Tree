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
public class JPanel_ShowMongolianTreeItem extends JPanel {

    private List<MongolianNode> nodes;

    public JPanel_ShowMongolianTreeItem(List<MongolianNode> nodes) {
        setLayout(null);
        this.nodes = nodes;
        showStaticText();
    }

    public JPanel_ShowMongolianTreeItem() {
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
                if (i == nodes.get(j).getLevel()) {
                    int startx, starty, endx, endy;
                    startx = nodes.get(j).getX();
                    starty = nodes.get(j).getY();
                    endx = nodes.get(nodes.get(j).getParentId()).getX();
                    endy = nodes.get(nodes.get(j).getParentId()).getY();
                    // Color color=new Color(j, j, j);
                    g2.setColor(Color.MAGENTA);
                    g2.setStroke(new BasicStroke(3f));
                    g2.draw(new Line2D.Double(startx, starty, endx, endy));
                }
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getChildNum() != 0) {
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke(1f));
                Rectangle2D rect = new Rectangle2D.Double(nodes.get(i).getX() - 25, nodes.get(i).getY() - 10, 50, 20);
                g2.draw(rect);
            } else {
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke(1f));
                Rectangle2D rect = new Rectangle2D.Double(nodes.get(i).getX() - 40, nodes.get(i).getY() - 10, 205, 40);
                g2.draw(rect);
            }

        }
    }

    private void showStaticText() {

        for (int i = 0; i < nodes.size(); i++) {

            String nodeName = nodes.get(i).getNodeName();
            if (nodes.get(i).getChildNum() == 0) {
                if (nodeName.length() > 22) {
                    String str1 = nodeName.substring(0, 22);
                    String str2 = nodeName.substring(22, nodeName.length());
                    JLabel jLabel = new JLabel(str1);
                    JLabel jLabe2 = new JLabel(str2);
                    jLabel.setBounds(nodes.get(i).getX() - 36, nodes.get(i).getY() - 10, 200, 20);
                    jLabe2.setBounds(nodes.get(i).getX() - 36, nodes.get(i).getY()+10, 200, 20);
                    this.add(jLabel);
                    this.add(jLabe2);
                } else {
                    JLabel jLabel = new JLabel(nodes.get(i).getNodeName());
                    jLabel.setBounds(nodes.get(i).getX() - 36, nodes.get(i).getY() - 10, 200, 20);
                    this.add(jLabel);
                }
            } else {
                JLabel jLabel = new JLabel(nodes.get(i).getNodeName());
                jLabel.setBounds(nodes.get(i).getX() - 23, nodes.get(i).getY() - 10, 200, 20);
                this.add(jLabel);
            }

        }
    }
}
