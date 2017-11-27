package org.jointheleague.mazegenerator.da;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MazeGUI extends JPanel implements Runnable, ActionListener{

	private static final int ROWS = 100;
	private static final int COLUMNS = 100;
	private static final int CELL_SIZE = 10;
	private List<Edge> edges; 
	private Timer ticker = new Timer(10,this);
	private int numEdges = 0;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new MazeGUI());
	}
	
	@Override
	public void run() {
		edges = new Maze(ROWS, COLUMNS).generateMST();
		
		JFrame frame = new JFrame();
		frame.add(this);
		Dimension d = new Dimension(CELL_SIZE * COLUMNS + 2, CELL_SIZE * ROWS + 2);
		this.setPreferredSize(d);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ticker.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Stroke stroke = new BasicStroke(CELL_SIZE - 2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2.setStroke(stroke);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.WHITE);
		Node n1;
		Node n2;
		int offset = CELL_SIZE/2 + 1;
		for (int i = 0; i < numEdges; i++) {
			Edge e = edges.get(i);
			n1 = e.getNode1();
			n2 = e.getNode2();
			g2.drawLine(n1.getCol() * CELL_SIZE + offset, n1.getRow() * CELL_SIZE + offset,
					n2.getCol() * CELL_SIZE + offset, n2.getRow() * CELL_SIZE + offset);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (numEdges < edges.size()){
			numEdges++;
			repaint();
		} else {
			ticker.stop();
		}
	}

}
