package lib;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Random;

public class Board {
	
	private int numOfPoints;
	Point2D.Float [] points;
	Color[] pointColors;
	
	
	private static final int R =0;
	private static final int G =1;
	private static final int B =2;
	private static final int Y =3;
	
	
	
	private static Color[] colorSelection;
	
	public Board() {
		
		colorSelection = new Color[4];
		
		Color red = new Color(255,0,0);
		Color green = new Color(0,255,0);
		Color blue  = new Color(0,0,255);
		Color yellow = new Color(255,215,0);
		
		colorSelection[R]=red;
		colorSelection[G]=green;
		colorSelection[B]=blue;
		colorSelection[Y]=yellow;
		
		
		Random generator = new Random();
		numOfPoints = generator.nextInt(5)+5;
		pointColors = new Color[numOfPoints];
		
//		System.out.println(numOfPoints);
		
		points = new Point2D.Float[numOfPoints];
		
	    for (int i = 0; i < numOfPoints; i++) {
	    	points[i] = new Point2D.Float();
			points[i].setLocation(generator.nextFloat(), generator.nextFloat());
			pointColors[i] = colorSelection[generator.nextInt(4)];
		}
	    
	    for (int i = 0; i < numOfPoints; i++) {
			System.out.format("%.2f %.2f\n",points[i].getX(),points[i].getY());
		}
		
	}
	
	int getPointSize()
	{
		return numOfPoints;
	}
	
	Color getColor(int i)
	{
		return pointColors[i];
	}

}
