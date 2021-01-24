package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class panelQuanCao extends JPanel implements ActionListener{
	private int width = 400;
	private int height = 25;
	
	private int x = 0;
	private int y = -5;
	
	Timer tm;
	Image dbImage=null;
	Graphics dbg;
	boolean a=true;
	
	private long beforeTime = 0L;
	
	
	private int Y = 15;
	
	String qc = "Click left mouse to create node, drag with left mouse to create edge";
	String GVHD = "drag with right mouse to change node position";
	String showStr = qc;
	
	public panelQuanCao(int x,int y){
		this.setBounds(x,y,width,height);
		
		tm = new Timer(20, this);
	}
	public void addNotify(){
		super.addNotify();
		tm.start();
	}
	public void setRun(boolean b){
		if(b) tm.start();
		else tm.stop();
	}
	private void update(){
		if(System.currentTimeMillis()-beforeTime>4000){
			beforeTime = System.currentTimeMillis();
			y=-5;
			if(a) {
				showStr = qc;
				a=false;
			}
			else {
				showStr = GVHD;
				a=true;
			}
		}
		if(y<Y)
		y++;
		
		
	}
	
	private void render(){
		
			dbImage = this.createImage(width,height);
			if(dbImage!=null)
			dbg = dbImage.getGraphics();
			if(dbg!=null){
				dbg.drawString(showStr, x, y);
				
			}
		
		
	}
	private void paint(){
		Graphics g;
		try{
			g = this.getGraphics();
			if(g!=null) g.drawImage(dbImage, 0, 0, null);
		}catch(Exception e){}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		update();
		render();
		paint();
	}
}
