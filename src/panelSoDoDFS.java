import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * 
 * @author Thach Shichibukai
 *
 */
public class panelSoDoDFS extends JPanel implements ActionListener{
	public int w = 455;
	public int h = 500;
	MainFrame mf;

	private SoDoDFS sodo;
	
	private int[][] a = new int[31][31];
	private int xuatphat,n;
	
	private int speed = 1000;


	boolean run = false;
	public KichBanDFS kBan;
	kichBan2 buoc;

	Timer timer;
	long beforeTime = 0L;


	

	Graphics2D dbg2;
	Image dbImage;



	public void setKhoiTao(int xuatphat, int n) {
		this.xuatphat = xuatphat;
		this.n = n;
	}

	public void setSpeedForAuto(int speed) {
		this.speed = speed;
	}

	public panelSoDoDFS(MainFrame mf) {

		timer = new Timer(100, this);
		
		kBan=new KichBanDFS();
		
		sodo=new SoDoDFS();
		
		this.mf=mf;
		
	}
	public void insertMatric(int matric[][]) {

		for (int i = 1; i < a.length; i++)
			for (int j = 1; j < a.length; j++)
				a[i][j] = matric[i - 1][j - 1];

	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		render();
		paintSr();
		if (run) {
			update();
		}
	}

	
	private void update() {
		if (kBan.start != null) {
			if (System.currentTimeMillis() - beforeTime > speed) {
				beforeTime = System.currentTimeMillis();
				//System.out.println(buoc.buoc);
				if (buoc.next != null)
					buoc = buoc.next;
				else
					buoc = kBan.start;
			}
		}
	}
	
	public void makeKichBanDFS(int xuatphat, int n) {
		
		int []Stack=new int[100];
		int topS=0;
		int []tham = new int[100];
		int[] back = new int[100];
		
		boolean jumpTo3 = true;
		
		Edge_List listEdge = new Edge_List();
		
		int i=-1;
		
		String ketQuaDuyet="";
		
		kBan.insertKichBan("buff",Stack,0,0,0,ketQuaDuyet,i);
		kBan.insertKichBan("begin",Stack,0,0,0,ketQuaDuyet,i);
		kBan.insertKichBan("Khoi tao",Stack,0,0,0,ketQuaDuyet,i);
		Stack[topS++]=xuatphat;
		
		
		kBan.insertKichBan("B1",Stack,topS,0,0,ketQuaDuyet,i);
		kBan.insertKichBan("topHon0First",Stack,topS,0,0,ketQuaDuyet,i);
		
		
		
		while(topS>0){
			
			jumpTo3=true;
			
			
			
			int v=Stack[--topS];
			
			if(back[v]!=0) listEdge.InsertEdge(0, mf.wp.ds.get_Node(v-1), mf.wp.ds.get_Node(back[v]-1));
			
			
			
			kBan.insertKichBan("B2",Stack,topS,v,0,ketQuaDuyet,i);
			//System.out.println("Nut dang xet: " + nodeDangXet);
			
			
			kBan.insertKichBan("dathamchua",Stack,topS,v,0,ketQuaDuyet,i);
			if(tham[v]!=1){
				i++;
				if(v==xuatphat)
					ketQuaDuyet+=String.valueOf(xuatphat);
					else ketQuaDuyet+=(">"+v);
				
				kBan.insertKichBan("printV", Stack, topS, v, 0, ketQuaDuyet, i);
				
				
				
				tham[v] = 1;
				
				kBan.insertKichBan("uHon1First",Stack,topS,v,0,ketQuaDuyet,i);
				
				for(int u=n;u>=1;u--){
					
					kBan.insertKichBan("daTham",Stack,topS,v,u,ketQuaDuyet,i);
					
					if (a[v][u] != 0 && a[v][u] != 1111) {
						if (tham[u] == 0) {
							Stack[topS++] = u;
							
							//tham[u]=1;
							
							back[u]=v;
							
							kBan.insertKichBan("B3",Stack,topS,v,u,ketQuaDuyet,i);
							kBan.insertKichBan("plusJFirst",Stack,topS,v,0,ketQuaDuyet,i);
						}
					} else
						kBan.insertKichBan("plusJSecond",Stack,topS,v,0,ketQuaDuyet,i);
					kBan.insertKichBan("uHon1Second",Stack,topS,v,0,ketQuaDuyet,i);
				}
				jumpTo3 = false;
			}
			
			
			if(jumpTo3){
				kBan.insertKichBan("topHon0Third", Stack, topS, 0, 0, ketQuaDuyet, i);
				jumpTo3=true;
			}else kBan.insertKichBan("topHon0Second",Stack,topS,0,0,ketQuaDuyet,i);
			
		}
		kBan.insertKichBan("end",Stack,0,0,0,ketQuaDuyet,i);
		kBan.insertKichBan("buff2",Stack,0,0,0,ketQuaDuyet,i);
		
		Graphs d = new Graphs();
		Edge_List list = d.getEdgeDFS(mf.wp.ds);
		
		kBan.insertEdgeL(list);
		
		
		
	}
	
	public void render() {
		dbImage = createImage(w, h);
		if (dbImage != null) {
			dbg2 = (Graphics2D) dbImage.getGraphics();
			if (dbg2 == null)
				return;
			else {
				dbg2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				sodo.showSoDo(dbg2, this.n, this.xuatphat);
				
				sodo.stack(buoc,dbg2);
				
				if (buoc != null) {
					
					
					if(buoc!=null) mf.result.prosessingTime.setTienDo(buoc);
					
					if (buoc.buoc == "begin")
						sodo.showStart(dbg2, Color.red);

					if (buoc.buoc == "Khoi tao")
						sodo.khoitao(dbg2, Color.red, 165, 60, n, xuatphat);
					if (buoc.buoc == "B1")
						sodo.B1(dbg2, Color.red, 155, 130);
					if(buoc.buoc=="topHon0Third")
						sodo.fKhacThird(dbg2, Color.red, 170, 165);
					
					if(buoc.buoc=="dathamchua")
						sodo.daThamChua(dbg2, Color.red, 170, 250);
					if(buoc.buoc=="printV")
						sodo.printToScreen(dbg2,Color.red, 170,300);
					
						
					
					if (buoc.buoc == "topHon0First")
						sodo.fKhacRFirst(dbg2, Color.red, 170, 165);
					
					if (buoc.buoc == "daTham")
						sodo.daTham(dbg2, Color.red, 165, 390);
					
					if (buoc.buoc == "uHon1First")
						sodo.jBeHonNFirst(dbg2, Color.red, 170, 340);
					if (buoc.buoc == "B2")
						sodo.B2(dbg2, Color.red, 170, 220);
					if (buoc.buoc == "B3")
						sodo.B3(dbg2, Color.red, 300, 405);
					if (buoc.buoc == "uHon1Second")
						sodo.jBeHonNSecond(dbg2, Color.red, 170, 340);
					if (buoc.buoc == "topHon0Second")
						sodo.fKhacRSecond(dbg2, Color.red, 170, 165);
					if (buoc.buoc == "plusJFirst")
						sodo.plusJFirst(dbg2, Color.red, 170, 320);
					if (buoc.buoc == "plusJSecond")
						sodo.plusJSecond(dbg2, Color.red, 170, 320);

					
					if (buoc.buoc == "end")
						sodo.theEnd(dbg2, Color.red);
					if (buoc.buoc == "buff2") {
						buoc = kBan.start;
						run = false;
						mf.batdau2.setIcon(mf.startIcon);
					}
					setState();
				}
				
			}
		}
	}
	private void paintSr() {
		Graphics g;
		try {
			g = this.getGraphics();
			if (g != null)
				g.drawImage(dbImage, 0, 0, null);
		} catch (Exception e) {
		}
	}
	///////////////////////////////////////////
	public void actionPerformd2() {
		// TODO Auto-generated method stub

		render();
		paintSr();

		update3();
		
	}
	public void actionPerformd() {
		// TODO Auto-generated method stub

		render();
		paintSr();

		update2();
		
	}
	private void update2() {
		if (kBan.start != null) {

			// System.out.println(buoc.buoc);
			if (buoc.next != null)
				buoc = buoc.next;
			else
				buoc = kBan.start;

		}
	}
	private void update3() {
		if (kBan.start != null) {

			// System.out.println(buoc.buoc);
			if (buoc.pre != null)
				buoc = buoc.pre;
			else
				buoc = kBan.start;

		}
	}
	public void setState() {
		
		
		// ***************DO Thi***************
		Image dbImage = mf.wp.createImage(mf.width, mf.heigh);
		Graphics2D g2=null;
		if(dbImage!=null){
			g2 = (Graphics2D) dbImage.getGraphics();
			if(g2!=null){
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				mf.wp.bg.GridBackGr(g2);
				mf.wp.gp.drawHideGraph(g2, mf.wp.ds);
				//Node******
				
				mf.ketQuaDuyet.setText(buoc.ketQuaDuyet);
				mf.result.setResult(buoc.ketQuaDuyet);
				
				if(buoc.nEdge>0) {
					mf.wp.gp.drawEdgeList(g2, kBan.edgeL, buoc.nEdge, mf.wp.ds);
					
				}
				
				//System.out.println("nEdge="+buoc.nEdge);
				if (mf.wp.ds.get_xy(buoc.nodeDangXet - 1) != null
						&& buoc.nodeDangXet != 0&&g2!=null) {
					
					
					
					mf.wp.drawN.nodeStart(g2, mf.wp.ds
							.get_Node(buoc.nodeDangXet - 1),true);
					
					if(buoc.nodeKeDangXet!=0){
						
						if(buoc.nodeDangXet==buoc.nodeKeDangXet)
						mf.wp.drawN.nodeKeDangXet(g2, mf.wp.ds.get_Node(buoc.nodeKeDangXet-1), false,true);
						else 
							mf.wp.drawN.nodeKeDangXet(g2, mf.wp.ds.get_Node(buoc.nodeKeDangXet-1), false,false);
					}
					
				} 
				//************************
				
				if(buoc==null&&buoc.buoc=="buff2") mf.wp.gp.drawResultDFS(g2, mf.wp.ds);
				
				mf.wp.DFSChuThich.showCT(g2);
				
				Graphics g=null;
				try{
					g=mf.wp.getGraphics();
				}catch(Exception e){}
				if(g!=null) g.drawImage(dbImage,0,0,null);
			}
		}

		// ***********************************

		

	}
}
