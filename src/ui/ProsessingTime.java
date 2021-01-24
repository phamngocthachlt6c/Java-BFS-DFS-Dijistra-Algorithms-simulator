package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import status_scenes.BfsStatusScene;
import status_scenes.DfsStatusScene;
import status_scenes.StatusScene;
import status_scenes.StatusScene2;
import status_scenes.StatusScene3;
import status_scenes.kichBanDJ;
public class ProsessingTime extends JPanel implements MouseListener, MouseMotionListener{
	
	private int w = 350;
	private int h = 30;
	private BfsStatusScene a;
	private DfsStatusScene b;
	private kichBanDJ c;
	
	private double doan;
	
	private int nStep;
	
	private double x=0;
	
	public boolean press = false;
	public boolean release = false;
	
	int n;
	MainFrame mf;
	
	public ProsessingTime(MainFrame mf){
		this.setPreferredSize(new Dimension(w,h));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.mf=mf;
		
	}
	public void setNumStep(BfsStatusScene a){
		int step = 0;
		this.a = a;
		StatusScene buoc = a.start;
		while(buoc!=null){
			step++;
			buoc=buoc.next;
		}
		if(step==0) nStep=1;
		else nStep = step;
		doan = (double) w/nStep;
		this.n = 1;
	}
	public void setNumStep(DfsStatusScene b){
		int step = 0;
		this.b = b;
		StatusScene2 buoc = b.start;
		while(buoc!=null){
			step++;
			buoc=buoc.next;
		}
		if(step==0) nStep=1;
		else nStep = step;
		doan = (double) w/nStep;
		
		this.n=2;
	}
	public void paint(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(0, 14, w, 4);
		g.setColor(Color.red);
		g.fillRect(0, 11, (int)x, 8);
	}
	public int getStep(){
		int step = 0;
		double s = 0;
		while(x>s){
			s+=doan;
			step++;
		}
		return step-1;
	}
	public void setNumStep(kichBanDJ c){
		int step = 0;
		this.c = c;
		StatusScene3 buoc = c.start;
		while(buoc!=null){
			step++;
			buoc=buoc.next;
		}
		if(step==0) nStep=1;
		else nStep = step;
		doan = (double) w/nStep;
		
		this.n=3;
	}
	public void paintScr(){
		Graphics g;
		try{
			
			g = this.getGraphics();
			g.setColor(Color.decode("#eeeeee"));
			g.fillRect(0, 0, w, h);
			g.setColor(Color.gray);
			g.fillRect(0, 14, w, 4);
			g.setColor(Color.red);
			g.fillRect(0, 11, (int)x, 8);
		}catch(Exception e){}
		
	}
	public void setStepForKB(int step){
		if(n==1){
			int i=0;
			mf.panelSoDoBFS.buoc=a.start;
			if(step == 0) mf.panelSoDoBFS.buoc=a.start;
			else if(step == nStep) mf.panelSoDoBFS.buoc= mf.panelSoDoBFS.kBan.end;
			else
			while(i<step) {
				mf.panelSoDoBFS.buoc=mf.panelSoDoBFS.buoc.next;
				i++;
			}
		}else if(n==2){
			int i=0;
			mf.panelSoDoDFS.buoc=b.start;
			if(step == 0) mf.panelSoDoDFS.buoc=b.start;
			else if(step == nStep) mf.panelSoDoDFS.buoc= mf.panelSoDoDFS.kBan.end;
			else
			while(i<step) {
				mf.panelSoDoDFS.buoc=mf.panelSoDoDFS.buoc.next;
				i++;
			}
		}else{
			int i=0;
			mf.panelDijstra.buoc=c.start;
			if(step == 0) mf.panelDijstra.buoc=c.start;
			else if(step == nStep) mf.panelDijstra.buoc=mf.panelDijstra.kBan.end;
			else
				while(i<step){
					mf.panelDijstra.buoc=mf.panelDijstra.buoc.next;
					i++;
				}
		}
	}
		
	public void setTienDo(StatusScene buoc){
		if(buoc==mf.panelSoDoBFS.kBan.start) x = 0;
		else if (buoc == mf.panelSoDoBFS.kBan.end) x = w;
		else {
			x=0;
			StatusScene p = mf.panelSoDoBFS.kBan.start;
			while(p!=buoc&&p!=null) {
				x+=doan;
				p=p.next;
			}
		}
		paintScr();
	}
	public void setTienDo(StatusScene2 buoc){
		if(buoc==mf.panelSoDoDFS.kBan.start) x = 0;
		else if (buoc == mf.panelSoDoDFS.kBan.end) x = w;
		else {
			x=0;
			StatusScene2 p = mf.panelSoDoDFS.kBan.start;
			while(p!=buoc&&p!=null) {
				x+=doan;
				p=p.next;
			}
		}
		paintScr();
	}
	public void setTienDo(StatusScene3 buoc){
		if(buoc==mf.panelDijstra.kBan.start) x = 0;
		else if (buoc == mf.panelDijstra.kBan.end) x = w;
		else {
			x=0;
			StatusScene3 p = mf.panelDijstra.kBan.start;
			while(p!=buoc&&p!=null) {
				x+=doan;
				p=p.next;
			}
		}
		paintScr();
	}
	public void mouseDragged(MouseEvent arg0) {
		if(arg0.getX()>=0 && arg0.getX()<=w) x = arg0.getX();
		else if (arg0.getX()<0) x =0;
		else if(arg0.getY()>w) x=w;
		paintScr();
		
		if(mf.wp.nodeLinkData.FirstNode!=null) {
			System.out.println(getStep());
			setStepForKB(getStep());
		}
	}
	public void mouseMoved(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {
		
		press = true;
		
		if(arg0.getX()>=0 && arg0.getX()<=w) x = arg0.getX();
		else if (arg0.getX()<0) x =0;
		else if(arg0.getY()>w) x=w;
		if(mf.wp.nodeLinkData.FirstNode!=null) {
			System.out.println(getStep());
			setStepForKB(getStep());
		}
		
		
		paintScr();
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {release=true;}
}
