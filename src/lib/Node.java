package lib;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Random;
import java.util.Set;

public class Node {
	
	public static final int RED = 1;
	public static final int GREEN = 2;
	public static final int BLUE = 3;
	public static final int YELLOW = 4;
	public static final int UNASSIGNED = 0;
	
	public static Color c;
	
	Point2D.Float nodePosition;
	Set<Point2D.Float> neighbors;

	public Node() {
		Random generator = new Random();
    	nodePosition = new Point2D.Float();
    	nodePosition.setLocation(generator.nextFloat(), generator.nextFloat());
	}

}
