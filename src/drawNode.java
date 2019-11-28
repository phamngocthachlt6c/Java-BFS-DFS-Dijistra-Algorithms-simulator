import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class drawNode{
	
	Font fb = new Font("TimesRoman", Font.BOLD, 15);
	
	RenderingHints rhints;
	
	
	public void drawNodeMouseEntered(Graphics2D g2,Node p){
		
		
		g2.setColor(Color.gray);
		g2.drawOval(p.x-12, p.y-12, 24, 24);
		
		g2.setPaint(Color.white);
		g2.setFont(fb);
		if (p.cost+1 > 9)
			g2.drawString("" + (p.cost+1), p.x - 7, p.y + 5);
		else
			g2.drawString("" +(p.cost+1), p.x - 3, p.y + 5);
	}
	
	public void nodeRoot(Graphics2D g2,Node p,boolean mophong){
		
		
		g2.setColor(Color.decode("#508006"));
		g2.fillOval(p.x-11, p.y-11, 23, 23);
		
		g2.setPaint(Color.white);
		g2.setFont(fb);
		if (p.cost+1 > 9)
			g2.drawString("" + (p.cost+1), p.x - 7, p.y + 5);
		else
			g2.drawString("" + (p.cost+1), p.x - 3, p.y + 5);
		if(p.isCheck&&mophong)drawIsChecked(g2,p);
	}
	public void nodeKeDangXet(Graphics2D g2,Node p,boolean mophong, boolean isNotDangXet){
		
		if(!isNotDangXet){
			g2.setColor(Color.decode("#a536f2"));
			g2.fillOval(p.x-11, p.y-11, 23, 23);
		}else{
			g2.setColor(Color.decode("#a536f2"));
			g2.fillOval(p.x-9, p.y-9, 19, 19);
		}
		
		
		g2.setPaint(Color.white);
		g2.setFont(fb);
		if (p.cost+1 > 9)
			g2.drawString("" + (p.cost+1), p.x - 7, p.y + 5);
		else
			g2.drawString("" + (p.cost+1), p.x - 3, p.y + 5);
		if(p.isCheck&&mophong)drawIsChecked(g2,p);
	}
	public void node(Graphics2D g2,Node p,boolean mophong){
		
		
		g2.setColor(Color.blue);
		g2.fillOval(p.x-11, p.y-11, 23, 23);
		
		g2.setPaint(Color.white);
		g2.setFont(fb);
		if (p.cost+1 > 9)
			g2.drawString("" + (p.cost+1), p.x - 7, p.y + 5);
		else
			g2.drawString("" + (p.cost+1), p.x - 3, p.y + 5);
		if(p.isCheck&&mophong)drawIsChecked(g2,p);
		
	}
	public void nodeHide(Graphics g,Node p){
		
		Graphics2D g2=(Graphics2D)g;
		rhints = g2.getRenderingHints();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.GRAY);
		g2.fillOval(p.x-11, p.y-11, 23, 23);
		
		g2.setPaint(Color.white);
		g2.setFont(fb);
		if (p.cost+1 > 9)
			g2.drawString("" + (p.cost+1), p.x - 7, p.y + 5);
		else
			g2.drawString("" + (p.cost+1), p.x - 3, p.y + 5);
		
	}
	public void drawEdge(Graphics2D g2,Node p,Node q,String color){
		
		
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.decode(color));
		g2.drawLine(p.x, p.y, q.x, q.y);
	}
	public void drawNodeEdNode(Graphics2D g2,Node p,Node q,Node_Link ds,boolean check,String color){
		drawEdge(g2,p,q,color);
		if(p==ds.FirstNode)
			nodeRoot(g2, p,check);
			else node(g2, p,check);
		if(q==ds.FirstNode)
			nodeRoot(g2, q,check);
			else node(g2, q,check);
	}
	public void nodeStart(Graphics2D g2,Node p, boolean mophong){
		
		
		g2.setColor(Color.red);
		g2.fillOval(p.x-11, p.y-11, 23, 23);
		
		g2.setPaint(Color.white);
		g2.setFont(fb);
		if (p.cost+1 > 9)
			g2.drawString("" + (p.cost+1), p.x - 7, p.y + 5);
		else
			g2.drawString("" + (p.cost+1), p.x - 3, p.y + 5);
		if(p.isCheck&&mophong)drawIsChecked(g2,p);
	}
	public void drawIsChecked(Graphics2D g2,Node p){
		
		g2.setColor(Color.black);
		g2.fillRect(p.x-4, p.y+7, 10, 2);
	}
	public void nodeRoot(Graphics2D g2,int x,int y,int cost){
		
		
		g2.setColor(Color.decode("#508006"));
		g2.fillOval(x-11, y-11, 23, 23);
		
		g2.setPaint(Color.white);
		g2.setFont(fb);
		if (cost+1 > 9)
			g2.drawString("" + (cost+1), x - 7, y + 5);
		else
			g2.drawString("" + (cost+1), x - 3,y + 5);
		
	}
	public void nodeSapDuyet(Graphics2D g2,int x,int y,int cost){
		
		
		g2.setColor(Color.decode("#fa8b39"));
		g2.fillOval(x-11, y-11, 23, 23);
		
		g2.setPaint(Color.white);
		g2.setFont(fb);
		if (cost+1 > 9)
			g2.drawString("" + (cost+1), x - 7, y + 5);
		else
			g2.drawString("" + (cost+1), x - 3,y + 5);
		
	}
	public void drawNodeEdNode2(Graphics2D g2,Node p,Node q,Node_Link ds,boolean check,String color){
		drawEdge(g2,p,q,color);
		if(p==ds.FirstNode)
			nodeRoot(g2, p,check);
			else node(g2, p,check);
		if(q==ds.FirstNode)
			nodeRoot(g2, q,check);
			else node(g2, q,check);
	}
}
