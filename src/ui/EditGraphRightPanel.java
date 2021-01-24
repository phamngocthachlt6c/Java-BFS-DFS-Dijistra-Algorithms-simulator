package ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;


public class EditGraphRightPanel extends JPanel{
	
	public EditGraphRightPanel() {
		
	}
	
	public void paint(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.decode("#eeeeee"));
		g2.fillRect(0, 0, 500, 800);
		drawHD(g2, Color.decode("#508006"), "Root node", 30,100);
		drawHD(g2, Color.blue, "Normal nodes", 30, 140);
		
		g2.drawString("Version 1.0", 190, 600);
		g2.drawString("Copyright PhamNgocThach @2015 - Phamngocthachlt6c@gmail.com", 45, 620);
	}
	private void drawHD(Graphics2D g2, Color color, String str, int x, int y){
		g2.setColor(color);
		g2.fillOval(x, y, 26, 26);
		g2.setColor(Color.black);
		g2.drawString(str, x+35, y+18);
	}
}
