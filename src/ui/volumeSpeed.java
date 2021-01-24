package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

class levels {
	int lim1,lim2;
	String colorCode;
	int speed;
	public levels(int lim1,int lim2,String colorCode,int speed){
		this.lim1=lim1;
		this.lim2=lim2;
		this.colorCode=colorCode;
		this.speed=speed;
	}
}
public class volumeSpeed extends JPanel implements MouseListener,MouseMotionListener{
	private int i;
	private levels[] level={
			new levels(0,10,"#94f6b2",8000),new levels(10,20,"#81f7c4",7000),new levels(20,30,"#2ef6c0",6000),new levels(30,40,"#09dff2",5000)
			,new levels(40,50,"#09c9f2",4000), new levels(50,60,"#099df2",3000),new levels(60,70,"#094bf2",2000),new levels(70,80,"#091ff2",1700)
			,new levels(80,90,"#2509f2",1600),new levels(90,100,"#3b09f2",1500), new levels(100,110,"#5109f2",1400),new levels(110,120,"#6c09f2",1300)
			,new levels(120,130,"#8209f2",1200),new levels(130,140,"#a309f2",1100),new levels(140,150,"#c309f2",1000),new levels(150,160,"#d909f2",900),
			new levels(160,170,"#ef09f2",800),new levels(170,180,"#f209d9",700),new levels(180,190,"#f20987",600),new levels(190,200,"#f2096c",500),
			new levels(200,210,"#f20930",400),new levels(210,220,"#f20930",300)};
	
	private static final int w = 220;
	private static final int h = 20;
	private panelSoDoBFS soDo;
	private panelSoDoDFS soDo2;
	private panelDijstra soDo3;
	
	private int levelPoint=14;
	
	private Image dbImage;
	private Graphics dbg;
	
	public volumeSpeed(panelSoDoBFS soDo,panelSoDoDFS soDo2,panelDijstra soDo3,int i){
		this.setPreferredSize(new Dimension(w,h));
		this.soDo=soDo;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.i=i;
		this.soDo2=soDo2;
		this.soDo3=soDo3;
	}
	private void render(){
		dbImage = createImage(w,h);
		if(dbImage!=null){
			dbg=dbImage.getGraphics();
			if(dbg!=null){
				dbg.setColor(Color.gray);
				dbg.fillRect(0, 0, w, h);
				
				dbg.setColor(Color.decode("#615b5c"));
				for(int i=0;i<220;i+=10){
					dbg.fillRect(i+2, 2, 7, 16);
				}
				for(int i=0;i<=levelPoint;i++){
					dbg.setColor(Color.decode(level[i].colorCode));
					dbg.fillRect(10*i+2, 2, 7, 16);
				}
			}
		}
	}
	private void paintScr(){
		Graphics g;
		try{
			g=this.getGraphics();
			if(g!=null) g.drawImage(dbImage,0,0,null);
		}catch(Exception e){}
	}
	private void repainT(){
		render();
		paintScr();
	}
	private int getPoint(int x){
		
		for(int i=0;i<level.length;i++) if(x>=level[i].lim1&&x<=level[i].lim2) return i;
		return -1;
	}
	public void paint(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(0, 0, w, h);
		
		g.setColor(Color.decode("#615b5c"));
		for(int i=0;i<220;i+=10){
			g.fillRect(i+2, 2, 7, 16);
		}
		for(int i=0;i<=levelPoint;i++){
			g.setColor(Color.decode(level[i].colorCode));
			g.fillRect(10*i+2, 2, 7, 16);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int point;
		if((point=getPoint(arg0.getX()))!=-1){
			this.levelPoint=point;
			repainT();
			if(i==1)soDo.setSpeedForAuto(level[levelPoint].speed);
			else if (i==2)soDo2.setSpeedForAuto(level[levelPoint].speed);
			else if(i==3)soDo3.setSpeedForAuto(level[levelPoint].speed);
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int point;
		if((point=getPoint(arg0.getX()))!=-1){
			this.levelPoint=point;
			repainT();
			soDo.setSpeedForAuto(level[levelPoint].speed);
		}
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
