package logic;


import java.awt.Point;






public class Node_Link {
	Node p, q, loc;
	int min;
	public Node FirstNode, LastNode;

	public Node_Link() {
		FirstNode = LastNode = null;
	}

	boolean isEmpty() {
		if (FirstNode == null)
			return true;
		else
			return false;
	}

	void Check(Node n) {
		n.isCheck = true;
	}

	void Check(int n) {
		Node p = FirstNode;
		while (p != null) {
			if (p.cost == n) {
				p.isCheck = true;
				break;
			}
			p = p.NodeNext;
		}
	}

	boolean isCheck(Node n) {
		if (n.isCheck == true)
			return true;
		return false;
	}

	void DelCheck() {
		Node p = FirstNode;
		while (p != null) {
			p.isCheck = false;
			p = p.NodeNext;
		}
	}

	public void InsertNode(int data, Point xy) {
		Node node = new Node(data, null, null, xy.x, xy.y);
		if (isEmpty())
			FirstNode = LastNode = node;
		else
			LastNode.NodeNext = node;
		LastNode = node;
	}
	public boolean isExist_Edge(Node px, Node pk){
		Node px_=FirstNode;
		while(px_!=null&&px_!=px){
			px_=px_.NodeNext;
		}
		if(px_!=null){
			Link l = px_.adj;
			while(l!=null) l=l.adj;
			if(l!=null) return true;
		}
		
		return false;
	}
	public void nutxet_nutke(int nutxet_, int nutke_) {
		if(nutxet_!=nutke_){
			Node pk = FirstNode, px = FirstNode;
			while (px.cost != nutxet_ && px != null) {
				px = px.NodeNext;
			}
	
			while (pk.cost != nutke_ && pk != null) {
				pk = pk.NodeNext;
			}
			if (pk != null && px != null) {
				if (!isExist_Edge(px, pk)) {
					Link l = new Link(pk);
					if (px.adj == null) {
						px.adj = l;
					} else {
						Link link = px.adj;
						while (link.adj != null) {
							link = link.adj;
						}
						link.adj = l;
					}
					l = new Link(px);
					if (pk.adj == null) {
						pk.adj = l;
					} else {
						Link link = pk.adj;
						while (link.adj != null) {
							link = link.adj;
						}
						link.adj = l;
					}
				}
			}
		}
	}
		
	void out() {
		p = FirstNode;
		while (p != null) {
			System.out.print(p.cost + ",(" + p.x + "," + p.y + "): ");
			Link l = p.adj;
			while (l != null) {
				System.out.print(l.cost.cost + " ");
				l = l.adj;
			}
			System.out.println();
			p = p.NodeNext;
		}
	}

	public int getnode_xy(Point xy) {
		Node p = FirstNode;
		while (p != null) {
			if (xy.x >= (p.x - 11) && xy.x <= (p.x + 11) && xy.y >= (p.y - 11)
					&& xy.y <= (p.y + 11))
				return p.cost;

			p = p.NodeNext;
		}
		return -1;
	}
	
	public Node getNode_enterNode(Point xy){
		Node p = FirstNode;
		while (p != null) {
			if (xy.x >= (p.x - 11) && xy.x <= (p.x + 11) && xy.y >= (p.y - 11)
					&& xy.y <= (p.y + 11))
				return p;

			p = p.NodeNext;
		}
		return null;
	}

	public Point get_xy(int data) {
		p = FirstNode;
		while (p != null) {
			if (p.cost == data)
				return new Point(p.x, p.y);
			p = p.NodeNext;
		}
		return null;
	}
	
	public boolean isNodeHere(Point xy){
		Node p = FirstNode;
		while (p != null) {
			if (xy.x >= (p.x - 11) && xy.x <= (p.x + 11) && xy.y >= (p.y - 11)
					&& xy.y <= (p.y + 11))
				return true;

			p = p.NodeNext;
		}
		return false;
	}
	
	public Node get_xy(Point xy) {
		Node p = FirstNode;
		while (p != null) {
			if (xy.x >= (p.x - 11) && xy.x <= (p.x + 11) && xy.y >= (p.y - 11)
					&& xy.y <= (p.y + 11))
				return p;

			p = p.NodeNext;
		}
		return null;
	}

	public boolean isExist(Point xy) {

		p = FirstNode;
		while (p != null) {
			if (p.x == xy.x && p.y == xy.y)
				return true;
			p = p.NodeNext;
		}
		return false;

	}

	public void set_root(Node a) {
		if (a != FirstNode) {
			p = FirstNode;
			while (p.NodeNext != a) {
				p = p.NodeNext;
			}
			if (a == LastNode) {
				LastNode = p;
				LastNode.NodeNext = null;
			} else
				p.NodeNext = a.NodeNext;
			a.NodeNext = FirstNode;
			FirstNode = a;

		}
	}

	public Node get_Node(int data) {
		Node T = FirstNode;
		while (T != null) {
			if (T.cost == data)
				return T;
			T = T.NodeNext;
		}
		return null;
	}

	void del_link(Node node_xet, Node node_xoa) {
		Link link = node_xet.adj;
		if (link != null) {
			if (link.cost == node_xoa) {
				node_xet.adj = link.adj;
			} else {
				while (link != null && link.cost != node_xoa)
					link = link.adj;
				if (link != null) {
					Link a = node_xet.adj;
					while (a.adj.cost != node_xoa)
						a = a.adj;
					a.adj = link.adj;
				}
			}
		}
	}

	public void del_node(Node data) {
		if (data != FirstNode) {
			Node node_ = FirstNode;
			while (node_ != null) {
				del_link(node_, data);
				node_ = node_.NodeNext;
			}
			node_ = FirstNode;
			while(node_!=data&&node_!=null) node_=node_.NodeNext;
			if(node_!=null){
				Node prev_node_=FirstNode;
				while(prev_node_.NodeNext!=data)prev_node_=prev_node_.NodeNext;
				
				prev_node_.NodeNext=node_.NodeNext;
				if(node_==LastNode) LastNode=prev_node_;
			}
		}else{
			Node p = FirstNode;
			Node a = p;
			p = FirstNode.NodeNext;
			FirstNode=p;
			while(p!=null){
				del_link(p,a);
				p=p.NodeNext;
			}
		}

	}
	public void swap_link(Link a, Link b){
		Node cost=a.cost;
		a.cost=b.cost;
		b.cost=cost;
	}
	public void sort_link(){
		Node c=FirstNode;
		Link l1,l2;
		int min;
		Link m;
		while(c!=null){
			l1=c.adj;
			while(l1!=null){
				min=l1.cost.cost;
				l2=l1;
				m=l1;
				while(l2!=null){
					if(l2.cost.cost<min) m=l2;
					l2=l2.adj;
				}
				swap_link(l1,m);
				l1=l1.adj;
			}
			c=c.NodeNext;
		}
	}
	public void after_delete_node(Node node_del){
		Node t = FirstNode;
		while(t!=null){
			if(t.cost>node_del.cost){
				t.cost--;
			}
			t=t.NodeNext;
		}
	}

	public void del_edge(Node a,Node b){
		Node p=FirstNode;
		while(p!=a) p = p.NodeNext;
		Link l1 = p.adj;
		Link l2=p.adj;
		if(l1.cost==b)p.adj=l1.adj;
		else{
			while(l1.adj.cost!=b)l1=l1.adj;
			while(l2.cost!=b)l2=l2.adj;
			l1.adj=l2.adj;
		}
		 p=FirstNode;
		while(p!=b) p = p.NodeNext;
		l1 = p.adj;
		l2=p.adj;
		if(l1.cost==a)p.adj=l1.adj;
		else{
			while(l1.adj.cost!=a)l1=l1.adj;
			while(l2.cost!=a)l2=l2.adj;
			l1.adj=l2.adj;
		}
		
		
	}
}
