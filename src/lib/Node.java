package lib;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Node {
	
	public static final int RED = 1;
	public static final int GREEN = 2;
	public static final int BLUE = 3;
	public static final int YELLOW = 4;
	public static final int UNASSIGNED = 0;
	
	public int color;
	
	Point2D.Float nodePosition;
	Set<Node> neighbors;

	public Node() {
		Random generator = new Random();
    	nodePosition = new Point2D.Float();
    	nodePosition.setLocation(generator.nextFloat(), generator.nextFloat());
    	color = UNASSIGNED;
    	neighbors = new HashSet<Node>();
	}
	
	public boolean isConnected(Node otherNode)
	{
		if (neighbors.contains(otherNode))
		{
			return true;
		}
		return false;
	}
	
	public float getDistance(Node otherNode)
	{
		float xDiff = (float) (nodePosition.getX() - otherNode.nodePosition.getX());
		float yDiff = (float) (nodePosition.getY() - otherNode.nodePosition.getY());
		return (float) Math.sqrt( xDiff*xDiff + yDiff*yDiff);
	}
	
	public void connect(Node otherNode)
	{
		if (!neighbors.contains(otherNode))
		{
			neighbors.add(otherNode);
			otherNode.neighbors.add(this);
		}
	}

}
