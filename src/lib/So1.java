package lib;
import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

public class So1 extends Applet{
	
	Board square = new Board();

    private static int dimension;
		
	public void paint (Graphics g)
    {
		for (int i = 0; i < square.getPointSize(); i++) {
				Point2D p = square.points[i];
				Color c = square.getColor(i);
		        g.setColor(c);
		        g.fillArc( (int)( p.getX()*dimension), (int) (p.getY()*dimension), 10, 10, 0, 360);
		}
//        g.drawString("hello",40,30);
//        Color c = new Color(255,255,255);
//        g.setColor(c);
//        g.fillArc(50, 50, 10, 10, 0, 360);
//    
//        Color d = new Color(255,0,0);
//        g.setColor(d);
//        g.fillArc(100, 100, 10, 10, 0, 360);
    }

    public static void main(String ad[])
    {
    	
    	dimension = 500;
        JFrame jp1 = new JFrame();
        So1 a=new So1 ();
        jp1.getContentPane().add(a, BorderLayout.CENTER);
        jp1.setSize(new Dimension(dimension*2,dimension*2));
        jp1.setVisible(true);

    }
}