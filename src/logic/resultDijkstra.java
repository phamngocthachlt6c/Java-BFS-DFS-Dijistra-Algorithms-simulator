package logic;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class resultDijkstra{
	
	private int max=30;
	private int infinity=1111;
	private int [][]c=new int[max][max];
	private int n;
	

	
	

	
	private int []p=new int[max];
	private int []d=new int[max];
	private boolean []k=new boolean[max];
	
	private Image im;
	
	
	public resultDijkstra(){
		
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
	
	public String dijkstraResult(int A[][],int n,int begin,int end){
		
		if(n>0){
			this.n=n;
			
			int v,u;
			
			
			for(v=0;v<n;v++)
				for(u=0;u<n;u++)c[v][u]=A[v][u];
			for(v=0;v<n;v++){
				d[v]=c[begin-1][v];
				p[v]=begin-1;
				k[v]=false;
			}
			k[begin-1]=true;
			while(!k[end-1]){
				u=minimum();
				
				k[u]=true;
				
				if(!k[end-1]){
					for(v=0;v<n;v++){
						if(!k[v]&&d[u]+c[u][v]<d[v]){
							d[v]=d[u]+c[u][v];
							p[v]=u;
						}
					}
				}
			}
		}else this.n=0;
		
		int i=p[end-1];
		
		String kqDuyet = "";
		System.out.print(end);
		kqDuyet+=""+end;
		while(i!=begin-1){

			System.out.print(" "+(i+1));
			kqDuyet+=("<-"+(i+1));
			i=p[i];
		}
		kqDuyet+="<-"+begin;
		System.out.print("<-"+begin);
		System.out.println();
		return kqDuyet;
	}
	
	
}
