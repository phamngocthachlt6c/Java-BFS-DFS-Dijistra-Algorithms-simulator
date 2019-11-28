import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class BackGround {
	int[] X = { 25, 70, 115, 160, 205, 250, 295, 340, 385, 430, 475};
	int[] Y = { 25, 70, 115, 160, 205, 250, 295, 340, 385};
	
	public void drawEdge(Graphics2D g,Point start,Point end){
		
		g.setStroke(new BasicStroke(3));
		g.setColor(Color.GREEN);
		g.drawLine(start.x, start.y, end.x, end.y);
	}
	
	public void drawQandS(Graphics2D g,int x,int y){
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 500, 30);
		
	}
	public void drawQ(Graphics2D g){
		g.setColor(Color.gray);
		g.fillRect(237, 511, 26, 29);
	}
	public void GridBackGr(Graphics2D g){
		
		g.setColor(Color.blue);
		for(int i=0;i<X.length;i++){
			g.drawLine(X[i], 0, X[i], 500);
		}
		for(int i=0;i<Y.length;i++){
			g.drawLine(0, Y[i], 500, Y[i]);
		}
		g.drawRect(0, 0, 500, 410);
		
	}
	
	public boolean enteredLine(Point xy1, Point xy2,Point mouse)        // DDA algorithm
	{           
	    int x_unit = 1, Dx = xy2.x - xy1.x, Dy = xy2.y - xy1.y; // Init first value
	    int x = xy1.x;
	    float y = xy1.y;
	    float y_unit = 1;
	     
	    if (Dx < 0)          
	        x_unit = -1;
	    if (Dy < 0)
	        y_unit = -1;
	         
	    if (xy1.x == xy2.x)   // duong thang dung
	    {
	        while (y != xy2.y)
	        {
	            
	            y += y_unit;
	            if(mouse.x>=x-4&&mouse.x<=x+4&&mouse.y>=y-4&&mouse.y<=y+4)return true;
	            
	        }   
	    }
	    else if (xy1.y == xy2.y)  // duong ngang
	    {
	        while (x != xy2.x)
	        {
	            
	            x += x_unit;
	            if(mouse.x>=x-4&&mouse.x<=x+4&&mouse.y>=y-4&&mouse.y<=y+4)return true;
	           
	        }
	    }
	    else if (xy1.x != xy2.x && xy1.y != xy2.y)// duong xien
	    {
	        float m = (float) Math.abs(Dy) / Math.abs(Dx);
	        x_unit = 1;
	        y_unit = m;
	        x = xy1.x;
	        y = xy1.y;
	         
	        if (Dx < 0)          
	            x_unit = -1;        // ve x giam
	        if (Dy < 0)
	            y_unit = -m;        // ve y giam
	         
	        if(mouse.x>=x-4&&mouse.x<=x+4&&mouse.y>=y-4&&mouse.y<=y+4)return true;
	        
	        while(x != xy2.x)
	        {
	            
	            x += x_unit;
	            y += y_unit;
	            if(mouse.x>=x-4&&mouse.x<=x+4&&mouse.y>=y-4&&mouse.y<=y+4)return true;
	            
	        }
	    }
	    return false;
	}
	
	public Point get_Point_put_Node(Point xy) {
		int min = 1000, x = 0, y = 0, i;
		int a;
		for (i = 0; i < X.length; i++)
			if ((a = Math.abs(X[i] - xy.x)) < min) {
				min = a;
				x = i;

			}
		min = 1000;
		for (i = 0; i < Y.length; i++)
			if ((a = Math.abs(Y[i] - xy.y)) < min) {
				min = a;
				y = i;
			}
		return new Point(X[x], Y[y]);
	}
}


class PopMenuEdge{
	
	public void Show(Graphics2D g,int x,int y){
		
		g.setColor(Color.decode("#a7acac"));
		g.fillRect(x, y, 100, 60);
		
		g.setColor(Color.decode("#cee4e4"));
		g.fillRect(x+2, y+1, 96, 58);
		g.setColor(Color.decode("#a7acac"));
		g.setStroke(new BasicStroke(2));
		g.drawLine(x+2, y+30, x+98, y+30);
		
		
		g.setColor(Color.red);
		g.drawString("XÃ³a cáº¡nh nÃ y", x+3, y+20);
		
		g.setColor(Color.blue);
		g.drawString("Ä�á»•i trá»�ng sá»‘", x+3, y+50);

	}
	public boolean ischoose(int x,int y,Point startDrag){
		
		if(x<startDrag.x&&x+100>startDrag.x&&y<startDrag.y&&y+60>startDrag.y) return true;
		return false;
	}
	public int optionIs(int x,int y,Point startDrag){
		if(x<startDrag.x&&x+100>startDrag.x&&y<startDrag.y&&y+30>startDrag.y) return 1;
		else if(x<startDrag.x&&x+100>startDrag.x&&y+30<startDrag.y&&y+60>startDrag.y) return 2;
		
			return 0;
	}
}

class PopMenuNode{
	
	
	
	public void Show(Graphics2D g,int x,int y){
		
		g.setColor(Color.decode("#a7acac"));
		
		g.fillRect(x, y, 100, 60);
		
		g.setColor(Color.decode("#cee4e4"));
		g.fillRect(x+2, y+1, 96, 58);
		g.setColor(Color.decode("#a7acac"));
		g.setStroke(new BasicStroke(2));
		g.drawLine(x+2, y+30, x+98, y+30);
		
		g.setColor(Color.orange);
		g.drawString("Ä�áº·t lÃ m gá»‘c", x+10, y+20);
		
		g.setColor(Color.red);
		g.drawString("XÃ³a nÃºt", x+10, y+50);
		
	}
	public boolean ischoose(int x,int y,Point startDrag){
		
		if(x>startDrag.x&&x<startDrag.x+100&&y>startDrag.y&&y<startDrag.y+60) return true;
		return false;
	}
	public int optionIs(int x,int y,Point startDrag){
		if(x>startDrag.x&&x<startDrag.x+100&&y>startDrag.y&&y<startDrag.y+30) return 1;
		else if(x>startDrag.x&&x<startDrag.x+100&&y>startDrag.y+30&&y<startDrag.y+60) return 2;
			return 0;
	}
}
