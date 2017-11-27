package org.jointheleague.mazegenerator.da;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testConstructor() {
		Node node = new Node(2,3);
	}
	
	@Test
	public void testGetRow() {
		int row = 3;
		int col = 2;
		Node node = new Node(row,col);
		assertEquals(row, node.getRow());
	}
	
	@Test
	public void testGetCol() {
		int row = 3;
		int col = 2;
		Node node = new Node(row,col);
		assertEquals(col, node.getCol());
	}
	
}
