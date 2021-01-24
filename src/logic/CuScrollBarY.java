package logic;
import java.awt.Color;
import java.awt.Graphics2D;


public class CuScrollBarY {
	private int x;
	private int pointY=0;
	private int y2;
	public CuScrollBarY(int x,int y2){
		this.x=x;
		this.y2=y2;
	}
	public void show(Graphics2D g2){
		
		g2.setColor(Color.white);
		g2.fillRect(x, 0, x+15, y2);
		g2.setColor(Color.gray);
		g2.fillRect(x, pointY, 15, 20);
	}
	public boolean areaIsScrBar(int x,int y){
		if(x<this.x+15&&x>this.x)return true;
		return false;
	}
	public void setPointY(int y){
		if(y>7&&y<y2-13)
		pointY=y-7;
	}
	public int getPointY(){
		return pointY;
	}
}
