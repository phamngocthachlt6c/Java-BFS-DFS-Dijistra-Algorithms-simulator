package logic;
import java.awt.Color;
import java.awt.Graphics2D;


public class CuScrollBarX {
	private int y;
	private int pointX=0;
	private int x2;
	public CuScrollBarX(int y,int x2){
		this.y=y;
		this.x2=x2;
	}
	public void show(Graphics2D g2){
		g2.setColor(Color.white);
		g2.fillRect(0, y, x2, y+15);
		
		g2.setColor(Color.gray);
		g2.fillRect(pointX, y, 20, 15);
	}
	public boolean areaIsScrBar(int x,int y){
		if(y<this.y+15&&y>this.y)return true;
		return false;
	}
	public void setPointX(int x){
		if(x>7&&x<x2-13)
		pointX=x-7;
	}
	public int getPointX(){
		return pointX;
	}
}
