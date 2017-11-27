package org.jointheleague.mazegenerator.da;

import java.util.ArrayList;

public class Node {
	
	private boolean connected;
	private ArrayList<Edge> edges;
	
	private final int row;
	private final int col;
	
	public Node(int row, int col) {
		edges = new ArrayList<Edge>();
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public ArrayList<Edge> getAdjacentEdges() {
		return edges;
	}
	
	public void setConnected(boolean b) {
		connected = b;
	}
	
	public boolean isConnected() {
		return connected;
	}
}
