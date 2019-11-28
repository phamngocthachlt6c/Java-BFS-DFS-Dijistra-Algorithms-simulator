import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
/**
 * 
 * @author Thach Shichibukai
 *
 */
public class panelDijstra extends JPanel implements ActionListener,
		MouseMotionListener {

	long beforeTime = 0L;
	private MainFrame mf;
	
	Graphs gp = new Graphs();
	
	private int speed = 1000;
	public boolean run=false;
	
	Graphics2D dbg2;
	Image dbImage;

	kichBanDJ kBan;
	kichBan3 buoc;
	TapDinh tapDinh;
	private int[][] a = new int[31][31];

	Timer timer;

	public int w = 455;
	public int h = 500;
	private int xTable = 10;
	private int yTable = 10;
	tableDJ tb = new tableDJ(xTable, yTable);

	CuScrollBarX scrbarX = new CuScrollBarX(h - 15, w - 15);
	CuScrollBarY scrbarY = new CuScrollBarY(w - 15, h);

	public panelDijstra(MainFrame mf) {
		timer = new Timer(10, this);
		this.mf=mf;

		this.addMouseMotionListener(this);
		kBan = new kichBanDJ();
		
		tapDinh=new TapDinh();
	}
	public void setRun(boolean b){
		if(b) run = true;
		else run = false;
	}
	public void setSpeedForAuto(int speed) {
		this.speed = speed;
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
	public void actionPerformd2() {
		// TODO Auto-generated method stub

		update3();
		render();
		paintSr();

		
		
	}
	private void update3() {
		if (kBan.start != null) {

			// System.out.println(buoc.buoc);
			
			if (buoc.prev != null){
				tb.delete(buoc.r, buoc.c);
				buoc = buoc.prev;
			}
				
			else{
				buoc = kBan.start;
				tb.format();
			}
				
			
		}
	}
	public void insertMatric(int matric[][]) {

		for (int i = 1; i < a.length; i++)
			for (int j = 1; j < a.length; j++)
				a[i][j] = matric[i - 1][j - 1];

	}
	public void render() {
		dbImage = createImage(w, h);
		if (dbImage != null) {
			dbg2 = (Graphics2D) dbImage.getGraphics();
			if (dbg2 == null)
				return;
			else {
				dbg2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);

				
				tb.setWidthOfCol(45);
				
				if (tb.getN() != 0) {
					if (buoc != null) {
						
						
						
						if (buoc.text!="buff"&&buoc.text!="buocKhac")
							tb.setTextForTb(buoc.text, buoc.r, buoc.c);
						if (buoc.text == "buff2"){
							tb.format();
							run = false;
							mf.batdau3.setIcon(mf.startIcon);
						}
						
					
						for(int i=0;i<buoc.n;i++){
							dbg2.drawString("Từ 1 đến "+buoc.kq.getGoiKqDuyet(i).to+
									" path: "+buoc.kq.getGoiKqDuyet(i).kqDuyet, xTable,
									tb.ToaDoDuoiCuaBang()+30+i*20+yTable );
						}
						
					}
					tb.set(xTable, yTable);
					tb.showTable(dbg2);

					scrbarX.show(dbg2);

					scrbarY.show(dbg2);

					
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

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		update();
		render();
		paintSr();
		/*
		 * if (run) { update(); }
		 */
	}

	private void update() {
		if(run){
			if (kBan.start != null) {
				if (System.currentTimeMillis() - beforeTime > speed) {
					beforeTime=System.currentTimeMillis();
					if (buoc == null)
						buoc = kBan.start;
					else
						buoc = buoc.next;
				}
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (scrbarX.areaIsScrBar(arg0.getX(), arg0.getY())) {
			System.out.println("y");
			scrbarX.setPointX(arg0.getX());
			xTable = 10 - scrbarX.getPointX() * 4;
		}
		if (scrbarY.areaIsScrBar(arg0.getX(), arg0.getY())) {
			scrbarY.setPointY(arg0.getY());
			yTable = 10 - scrbarY.getPointY();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	//******************************************************
	public resultDijkstra dijkstra = new resultDijkstra();
	///************ tạo file đường dẫn*************************
	public void Dijkstra(int A[][], int n, int D, int C) {
		
		int MAXINT = 1111;
		
		
		 char []DanhDau = new char [31];
		 int []Nhan = new int [31];
		 int []Truoc = new int [31];
		 int XP, min;
		 for(int i=1; i<=n; i++){
		  Nhan[i] = MAXINT;
		  DanhDau[i] = 0;
		  Truoc[i] = D;
		 }
		 Nhan[D] = 0;
		 DanhDau[D] = 1;
		 XP = D;
		 while(XP != C){
		  for(int j=1; j<=n; j++)
		   if(A[XP][j]>0 && Nhan[j]>A[XP][j]+Nhan[XP] && DanhDau[j]==0) {
		    Nhan[j] = A[XP][j]+Nhan[XP];
		    Truoc[j] = XP;
		   }
		   min = MAXINT;
		  for(int j = 1; j<=n; j++)
		  if(min>Nhan[j]&& DanhDau[j]==0){
		   min = Nhan[j];
		   XP = j;
		  }
		  DanhDau[XP] = 1;
		 }
		 System.out.println("Duong Di Ngan Nhat La:"+Nhan[C]);
		 System.out.print(C+1+" <-"+Truoc[C]+1);
		 int i = Truoc[C];
		 while(i!=D){
		  i = Truoc[i];
		  System.out.print(" <-"+(i+1));
		 }
		}
	/// *********** MAKE KICH BAN DIJSTRA*************************
	public void makeKichBan(int n) {
		// init
		
		Edge_List edgeL = new Edge_List();
		int nedge=0;
		
		int r = 1;
		
		
		
		kqDuyet kq = new kqDuyet();
		
		kBan.insertKichBan("buff", 0, 0,nedge,kq,0);
		
		if(n>0) {
			kBan.insertKichBan("Init", 0, 0,nedge,kq,0);
			kBan.insertKichBan("(0,-)", 0, 1,nedge, kq,0);
			tapDinh.insertDinh(1, 0, 0);
		}
		for(int i=2;i<=n;i++) {
			kBan.insertKichBan("(∞,-)", 0, i,nedge,kq,0);
			tapDinh.insertDinh(i, 1111, 1);
		}
		
		int nkq = 0;
		
		
		while(r<=n){
			
			
			
			/////////////////////////////////////////
			
			
			
			int v = tapDinh.getMin();
			if(v!=1) {
				
				nkq++;
				kq.insertGoiDuyet(1, v, this.dijkstra.dijkstraResult(mf.wp.matNum.getA(),
						mf.wp.data+1, 1, v), 0);
			}
					
			kBan.insertKichBan(v+"", r, 0,nedge,kq,nkq);
			TapDinh.Dinh V = tapDinh.getDinh(v);
			if(v!=-1)
			for(int i=1;i<=n;i++){
				
				
				tapDinh.delete(v);
				if(tapDinh.inTapDinh(i)){
					tapDinh.plusVandIBeHon(V, i,a[v][i],v);
					if(tapDinh.getDinh(i).d==1111)
						kBan.insertKichBan("(∞,"+tapDinh.getDinh(i).path+")", r, i, nedge,kq,nkq);
					else
					kBan.insertKichBan("("+tapDinh.getDinh(i).d+","+tapDinh.getDinh(i).path+")", r, i,nedge,kq,nkq);
				}
				
				
					
				
			}
			if(tapDinh.getVisDMin()!=null) {
				edgeL.InsertEdge(0, mf.wp.ds.get_Node(tapDinh.getVisDMin().path-1),
						mf.wp.ds.get_Node(tapDinh.getVisDMin().dinh-1));
				
				nedge++;
			}
			
			/////////////////////////////////////////
			r++;
		}
		
		kBan.insertEdgeL(edgeL);
		kBan.insertKichBan("buff2", 0, 0,nedge,kq,nkq);
		//edgeL.out();
	}
	
	
	
	///////////////////////////////***************************************************************************
	public void setState() {
		
		/*System.out.println("Edge["+buoc.buoc+"]:\n");
		buoc.edgeL.out();
		System.out.println("**********************");
		*/
		

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
				
				if(buoc!=null){
					if(buoc.text!="Init"&&buoc.text!="(∞,-)"&&buoc.text!="(0,-)"&&buoc.text!="buff")
						mf.wp.drawN.nodeRoot(g2, 
							mf.wp.ds.get_Node(0).x,mf.wp.ds.get_Node(0).y, 0);
					mf.wp.gp.drawEdgeList(g2, kBan.edgeL,buoc.edgeN,mf.wp.ds);
					
					
					
					
				}
				
				
				if(mf.wp.showNumb) mf.wp.gp.drawNum(g2, mf.wp.listEdge);
				//************************
				
				
				
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
