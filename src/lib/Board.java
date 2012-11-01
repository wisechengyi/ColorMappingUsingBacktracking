package lib;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Board {
	
	private int numOfPoints;
	
	private static Queue<Node> points;
	
	public Board() {
		
//		colorSelection = new Color[4];
//		
//		Color red = new Color(255,0,0);
//		Color green = new Color(0,255,0);
//		Color blue  = new Color(0,0,255);
//		Color yellow = new Color(255,215,0);
//		
//		colorSelection[R]=red;
//		colorSelection[G]=green;
//		colorSelection[B]=blue;
//		colorSelection[Y]=yellow;
//		
		
		points = new LinkedList<Node>();
		
		Random generator = new Random();
		numOfPoints = generator.nextInt(5)+5; //make numOfPoints 5-10
		
		
		
		
	    for (int i = 0; i < numOfPoints; i++) {
	    	Node newPoint = new Node();
	    	points.add(newPoint);
		}
	    
	    ListIterator<Node> it = (ListIterator<Node>) points.iterator();	    
	    System.out.println(numOfPoints);
	    while(it.hasNext())
	    {
	    	Node temp = it.next();
	    	System.out.format("%.2f %.2f\n",temp.nodePosition.getX(),temp.nodePosition.getY());
	    }
	    
	    connectNodes();

	}

	private void connectNodes()
	{
		boolean possibleConnectionExists = true;
		while (possibleConnectionExists) {
			
			possibleConnectionExists = false;
			ListIterator<Node> it = (ListIterator<Node>) points.iterator();
			while (it.hasNext()) {
				Node currNode = it.next();
				Node nearestNode = nearestUnconnectedNode(currNode); // find nearest unconnected node called nearestNode
				if (nearestNode==null)
				{
					continue;
				}
				
				// check intersection  if no intersection with other line, connect curr with temp,
				if (checkIntersection(currNode, nearestNode))
				{
					continue;
				}
				
				currNode.connect(nearestNode);
				possibleConnectionExists=true;

				// if a connection is made, mark go for a second run
//				System.out.format("%.2f %.2f\n", temp.nodePosition.getX(),
//						nearestNode.nodePosition.getY());
			}
		}
	
	}
	private boolean checkIntersection(Node nodeOne, Node nodeTwo)
	{
		if (nodeOne == nodeTwo) {
			return false;
		}
		Point2D p1 = nodeOne.nodePosition;
		Point2D p2 = nodeTwo.nodePosition;
		
		Line2D testLine = new Line2D.Float(p1,p2);
		
		ListIterator<Node> it = (ListIterator<Node>) points.iterator();
		while (it.hasNext()) {
			Node currNode = it.next();
			if (currNode==nodeOne || currNode ==nodeTwo)
			{
				continue;
			}
			
			Point2D p3 = currNode.nodePosition;
			
			for (Node otherNode : currNode.neighbors)
			{
				if (otherNode == nodeOne || otherNode == nodeTwo)
				{
					continue;
				}
				Point2D p4 = otherNode.nodePosition;
				Line2D newLine = new Line2D.Float(p4,p3);
				if (testLine.intersectsLine(newLine))
				{
					return true;
				}
			}

			// if a connection is made, mark go for a second run
//			System.out.format("%.2f %.2f\n", temp.nodePosition.getX(),
//					nearestNode.nodePosition.getY());
		}
		
		return false;
	}
	
	

	private Node nearestUnconnectedNode(Node currNode)
	{
		Node currBestChoice = null;
		float currBestDistance = Float.MAX_VALUE;
		
	    ListIterator<Node> it1 = (ListIterator<Node>) points.iterator();	    
	    while(it1.hasNext())
	    {
	    	Node temp = it1.next();
	    	float tempDistance = currNode.getDistance(temp);
	    	
	    	if (temp==currNode || currNode.isConnected(temp))
	    	{
	    		continue;
	    	}
	    	
	    	if (tempDistance<currBestDistance)
	    	{
	    		currBestDistance=tempDistance;
	    		currBestChoice = temp;
	    	}
	    	
	    	
	    }
	    
	    return currBestChoice;
	}
	
	int getPointSize()
	{
		return numOfPoints;
	}
	
	public Queue<Node> getPoints()
	{	final Queue<Node> q = points;
		return q; 
	}
	
//	Color getColor(int i)
//	{
//		return pointColors[i];
//	}

}
