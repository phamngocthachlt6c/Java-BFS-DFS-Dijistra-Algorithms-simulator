import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

class draw extends JPanel implements Runnable{
	Thread t;
	int w=200,h=200;
	public draw(){
		this.setPreferredSize(new Dimension(w,h));
		t = new Thread(this);
	}
	public void run(){
		while(true){
			System.out.println("asdf\n");
			try{
				Thread.sleep(20);
			}catch(Exception e){
				
			}
		}
	}
	public void stop(){
		t.stop();
	}
	public void addNotify(){
		super.addNotify();
		start();
	}
	private void start(){
		t.start();
	}
}

public class dijkstra extends JPanel{
	
	private int max=30;
	private int infinity=1111;
	private int [][]c=new int[max][max];
	private int n;
	
	private drawNode dr = new drawNode();
	
	draw da;
	
	
	private JLabel Shortestway=new JLabel("Đường đi ngắn nhất từ 0 đến 0 là: 0");
	
	private int []p=new int[max];
	private int []d=new int[max];
	private boolean []k=new boolean[max];
	
	private Image im;
	
	
	public dijkstra(){
		setLayout(null);
		
		Shortestway.setBounds(15,30,300,20);
		add(Shortestway);
		da = new draw();
		add(da);
	}
	public void setShortestWay(int begin,int end, int s){
		if(s==1111)
		Shortestway.setText("- Không có đường đi từ "+begin+" đến "+end);
		else Shortestway.setText("- Đường đi ngắn nhất từ "+begin+" đến "+end+" là: "+s);
	}
	public void drawBegin(Graphics2D g2,Point xy){

		try {
			im=ImageIO.read(getClass().getResource("begin.png"));
		} catch (IOException e) {}
		g2.drawImage(im,xy.x,xy.y-20,null);
	}
	public void drawEnd(Graphics2D g2,Point xy){
		try {
			im=ImageIO.read(getClass().getResource("end.png"));
		} catch (IOException e) {}
		g2.drawImage(im,xy.x,xy.y-20,null);
	}
	public void drawBeginEnd(Graphics2D g2,Point xy){
		try {
			im=ImageIO.read(getClass().getResource("begin.png"));
		} catch (IOException e) {}
		g2.drawImage(im,xy.x,xy.y-20,null);
		
		try {
			im=ImageIO.read(getClass().getResource("end.png"));
		} catch (IOException e) {}
		g2.drawImage(im,xy.x,xy.y,null);
	
	}
	
	
	
	
	public boolean isCatToEach(int begin,int end, Node_Link ds){
		
		int i = 1, j = 0;
		

		Node p, q;
		Link k;
		int[] qu = new int[30];
		
		for(int i1=0;i1<30;i1++)qu[i1]=-1;
		
		p = ds.FirstNode;
		if (p != null) {
			while (p != null) {
				p.isCheck = false;
				p = p.NodeNext;
			}
			p = ds.FirstNode;
			while(p.cost!=begin)p=p.NodeNext;
			qu[0] = p.cost;
			qu[1]=-1;
			p.isCheck = true;

			while (qu[j] != -1) {

				p = ds.FirstNode;
				while (p != null && p.cost != qu[j]) {

					p = p.NodeNext;
				}
				
				if (p != null) {
					k = p.adj;
					
					while (k != null) {
						q = k.cost;
						if (!q.isCheck) {
							qu[i] = q.cost;

							

							q.isCheck = true;
							qu[i + 1] = -1;
							i++;
						}
						k = k.adj;
					}

				}
				j++;
			}
			for(int ii=0;ii<30;ii++) if(qu[ii]==end) return true;
		}
		return false;
	}
	private int minimum(){
		int u=0,v,dmin=infinity;
		for(v=0;v<n;v++){
			if(!k[v]&&d[v]<dmin){
				dmin=d[v];
				u=v;
			}
		}
		return u;
	}
	public void dijkstraResult(Node_Link ds,int A[][],Graphics2D g2,int n,int begin,int end){
		
		if(n>0){
			this.n=n;
			
			int v,u;
			
			
			for(v=0;v<n;v++)
				for(u=0;u<n;u++)c[v][u]=A[v][u];
			for(v=0;v<n;v++){
				d[v]=c[begin][v];
				p[v]=begin;
				k[v]=false;
			}
			k[begin]=true;
			while(!k[end]){
				u=minimum();
				
				k[u]=true;
				
				if(!k[end]){
					for(v=0;v<n;v++){
						if(!k[v]&&d[u]+c[u][v]<d[v]){
							d[v]=d[u]+c[u][v];
							p[v]=u;
						}
					}
				}
			}
		}else this.n=0;
		
		int i=p[end];
		
		dr.drawNodeEdNode(g2, ds.get_Node(end), ds.get_Node(i), ds, false, "#f60d33");
		//System.out.print(end);
		while(i!=begin){
			dr.drawNodeEdNode(g2, ds.get_Node(i), ds.get_Node(p[i]), ds, false, "#f60d33");
			//System.out.print(" "+i);
			i=p[i];
		}
		//System.out.print(" "+begin);
		setShortestWay(begin,end,d[end]);
	}
	
	
}
