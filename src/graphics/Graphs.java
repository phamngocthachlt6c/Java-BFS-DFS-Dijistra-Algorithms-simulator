package graphics;
import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Graphics2D;

import logic.Line_List;
import logic.Link;
import logic.Node;
import logic.Node_Link;



public class Graphs {
	
	private drawNode d = new drawNode();
	
	public void drawNum(Graphics2D g, Edge_List listEdge){
		
		Edge p = listEdge.First;
		g.setColor(Color.black);
		int x,y;
		while(p!=null){
			x=(int)(p.b.x+p.a.x)/2-7;
			y=(int)(p.b.y+p.a.y)/2+6;
			
			g.drawString(""+p.ts, x, y);
			p=p.next;
		}
		
	}
	
	public void drawResultDFS(Graphics2D g, Node_Link ds){
		
		Node[] drawArray = new Node[100];
		int iarray=0;
		
		int[] stack = new int[30];
		int top = 1;
		Node p, q;
		Link k;
		p = ds.FirstNode;
		if (p != null) {
			while (p != null) {
				p.isCheck = false;
				
				p = p.NodeNext;
			}
			p = ds.FirstNode;
			stack[0] = -1;
			stack[top] = p.cost;
			
			
			while (stack[top] != -1) {

				p = ds.FirstNode;
				while (p != null && p.cost != stack[top])
					p = p.NodeNext;
				p.isCheck = true;
				
				
				drawArray[iarray]=p;
				iarray++;
				
				k = p.adj;
				if(!haveAdj(ds,p))top--;
				else
				while (k != null) {
					q = k.cost;
					if (!q.isCheck) {
						top++;
						stack[top] = q.cost;
						q.isCheck = true;
						
						k=null;
					}
					if(k!=null)k = k.adj;
				}
			}
			
			
			for(int i=0;i<iarray-1;i++){
				d.drawNodeEdNode(g, drawArray[i], drawArray[i+1], ds, false,"#d508d7");
				
			}

		}
	}
	
	
	public Edge_List getEdgeDFS(Node_Link ds){
		
		Edge_List edL= new Edge_List();
		
		Node[] drawArray = new Node[100];
		int iarray=0;
		
		int[] stack = new int[30];
		int top = 1;
		Node p, q;
		Link k;
		p = ds.FirstNode;
		if (p != null) {
			while (p != null) {
				p.isCheck = false;
				
				p = p.NodeNext;
			}
			p = ds.FirstNode;
			stack[0] = -1;
			stack[top] = p.cost;
			
			
			while (stack[top] != -1) {

				p = ds.FirstNode;
				while (p != null && p.cost != stack[top])
					p = p.NodeNext;
				p.isCheck = true;
				
				
				drawArray[iarray]=p;
				iarray++;
				
				k = p.adj;
				if(!haveAdj(ds,p))top--;
				else
				while (k != null) {
					q = k.cost;
					if (!q.isCheck) {
						top++;
						stack[top] = q.cost;
						q.isCheck = true;
						
						k=null;
					}
					if(k!=null)k = k.adj;
				}
			}
			
			
			for(int i=0;i<iarray-1;i++){
				edL.InsertEdgeForDFS(0, drawArray[i], drawArray[i+1]);
				
			}
			
			
		}
		return edL;
	}
	
	private boolean haveAdj(Node_Link ds, Node p){
		Node q = ds.FirstNode;
		while(q!=null&&q!=p) q=q.NodeNext;
		if(q!=null){
			Link l = q.adj;
			if(l!=null){
				while(l!=null){
					if(!l.cost.isCheck) return true;
					l=l.adj;
				}
			}
		}
		return false;
	}
	public void drawResultBFS(Graphics2D g, Node_Link ds){
		
		int i = 1, j = 0;
		drawNode d = new drawNode();

		Node p, q;
		Link k;
		int[] qu = new int[60];
		
		p = ds.FirstNode;
		if (p != null) {
			while (p != null) {
				p.isCheck = false;
				p = p.NodeNext;
			}
			p = ds.FirstNode;
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
					if(p==ds.FirstNode)d.nodeRoot(g, p, false);
					else d.node(g, p, false);
					while (k != null) {
						q = k.cost;
						if (!q.isCheck) {
							qu[i] = q.cost;

							d.drawNodeEdNode(g, p, q, ds, false, "#d508d7");

							q.isCheck = true;
							qu[i + 1] = -1;
							i++;
						}
						k = k.adj;
					}

				}
				j++;
			}

		}
		
	}
	
	public void drawHideGraph(Graphics2D g,Node_Link ds){
		
		Node p;
		Link L;
		Line_List Line;
		g.setStroke(new BasicStroke(2));
		Line = new Line_List();
		p = ds.FirstNode;
		g.setColor(Color.gray);
		while (p != null) {
			L = p.adj;
			while (L != null) {
				if (!Line.isExist(p, L.cost)) {
					g.drawLine(p.x, p.y, L.cost.x, L.cost.y);
					Line.Insert_Line(p, L.cost);
				}
				L = L.adj;
			}
			p = p.NodeNext;
		}
		
		//***********VE NODE **************************
		
		
		p = ds.FirstNode;
		while (p != null) {
			 d.nodeHide(g,p);
			
			p = p.NodeNext;

		}
	
		
	}
	public void drawEdgeList(Graphics2D g2, Edge_List edgeL,int nEdge, Node_Link ds){
		
		
		
		g2.setStroke(new BasicStroke(2));
		int i=0;
		Edge p=null;
		if(edgeL.First!=null) p = edgeL.First;
		g2.setColor(Color.green);
		while (p != null&&i<nEdge) {
			//d.drawEdge(g2, p.a, p.b, "#d508d7");
			i++;
			d.drawNodeEdNode(g2, p.a, p.b, ds, false, "#d508d7");
			p = p.next;
		}
		
		//***********VE NODE **************************
		
	
		
	}
	

	public void drawGraph(Graphics2D g,Node_Link ds){
		Node p;
		Link L;
		Line_List Line;
		g.setStroke(new BasicStroke(3));
		Line = new Line_List();
		p = ds.FirstNode;
		g.setColor(Color.green);
		while (p != null) {
			L = p.adj;
			while (L != null) {
				if (!Line.isExist(p, L.cost)) {
					g.drawLine(p.x, p.y, L.cost.x, L.cost.y);
					Line.Insert_Line(p, L.cost);
				}
				L = L.adj;
			}
			p = p.NodeNext;
		}
		
		//***********VE NODE **************************
		
		
		p = ds.FirstNode;
		while (p != null) {
			if(p==ds.FirstNode)
				d.nodeRoot(g, p,false);
				else d.node(g,p,false);
			
			p = p.NodeNext;

		}
	}
	public void drawEdgeIsEntered(Graphics2D g,Node a,Node b, Node_Link ds){
		
		g.setStroke(new BasicStroke(7));
		g.setColor(Color.gray);
		g.drawLine(a.x, a.y, b.x, b.y);
		d.drawEdge(g, a, b, "#00ff00");
		
		if(a!=ds.FirstNode) d.node(g, a, false);
		else d.nodeRoot(g, a, false);
	
		if(b!=ds.FirstNode) d.node(g, b, false);
		else d.nodeRoot(g, b, false);
		
	}

	public void drawEdgeListSapDuyet(Graphics2D g2, Edge_List edgeL,int nEdge, Node_Link ds) {
		
		g2.setStroke(new BasicStroke(2));
		int i=0;
		Edge p=null;
		if(edgeL.First!=null) p = edgeL.First;
		g2.setColor(Color.green);
		while (p != null&&i<nEdge) {
			//d.drawEdge(g2, p.a, p.b, "#d508d7");
			i++;
			d.drawNodeEdNode(g2, p.a, p.b, ds, false, "#fdb682");
			p = p.next;
		}
		
	}
}


//********************************************\
