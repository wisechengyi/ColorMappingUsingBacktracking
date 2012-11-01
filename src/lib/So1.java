package lib;
import java.applet.Applet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.awt.*;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

public class So1 extends Applet{
	
//	Board square = new Board();
	static Board square;
    private static int dimension;
		
	public void paint (Graphics g)
    {
//		for (int i = 0; i < square.getPointSize(); i++) {
//				Queue<Node> q = square.getPoints();
//				Node x = new Node();
//				q.add(x);
				
				Object[] objectArray = square.getPoints().toArray();
				for (int j=0; j<objectArray.length;j++)
				{
					Node currNode = (Node) objectArray[j];
					
					int x = (int) (currNode.nodePosition.getX()*(float)dimension);
					int y = (int) (currNode.nodePosition.getY()*(float)dimension);
					g.fillArc( x,y, 10, 10, 0, 360);
					
					for (Node neighbor : currNode.neighbors)
					{
						drawline(currNode,neighbor,g);
					}
					
				}
				
//				Color c = square.getColor(i);
//		        g.setColor(c);
		      
//		}
//        g.drawString("hello",40,30);
//        Color c = new Color(255,255,255);
//        g.setColor(c);
//        g.fillArc(50, 50, 10, 10, 0, 360);
//    
//        Color d = new Color(255,0,0);
//        g.setColor(d);
//        g.fillArc(100, 100, 10, 10, 0, 360);
    }

    private void drawline(Node nodeOne, Node nodeTwo,Graphics g) {
		// TODO Auto-generated method stub
		int x1,x2,y1,y2;
		x1 = (int) (nodeOne.nodePosition.getX()*(float)dimension);
		y1 = (int) (nodeOne.nodePosition.getY()*(float)dimension);
		x2 = (int) (nodeTwo.nodePosition.getX()*(float)dimension);
		y2 = (int) (nodeTwo.nodePosition.getY()*(float)dimension);
		
		g.drawLine(x1,y1,x2,y2);
	}

	public static void main(String ad[])
    {
    	
   	dimension = 500;
   	square = new Board();
        JFrame jp1 = new JFrame();
        So1 a=new So1 ();
        jp1.getContentPane().add(a, BorderLayout.CENTER);
        jp1.setSize(new Dimension(dimension*2,dimension*2));
        jp1.setVisible(true);

    }
}