package graphics;
import java.awt.Point;

import logic.Edge;
import logic.Node;

public class Edge_List {

	public Edge First;
	private Edge c;

	public Edge_List() {
		First = null;
	}

	public void getEdgeList(Edge_List edgeL1, Edge_List edgeL2) {
		if (edgeL1.First != null) {
			edgeL2.First = edgeL1.First;
			if (edgeL1.First.next != null) {

				Edge p = edgeL1.First.next;
				c = edgeL2.First;
				while (p != null) {
					c.next = p;
					c = p;
					p = p.next;
				}
			}

		}

	}

	public void format() {
		First = null;
	}

	boolean isEmpty() {
		if (First == null)
			return true;
		else
			return false;
	}

	public void InsertEdge(int ts, Node a, Node b) {
		
		c = new Edge(a, b, ts, null);
		if (isEmpty())
			First = c;
		else {
			Edge d = First;
			while (d.next != null)
				d = d.next;
			d.next = c;

		}

	}
	public void InsertEdgeForDFS(int ts, Node a, Node b) {
		if(!isExistEdge(a,b)){
			c = new Edge(a, b, ts, null);
			if (isEmpty())
				First = c;
			else {
				Edge d = First;
				while (d.next != null)
					d = d.next;
				d.next = c;

			}
		}
	}

	public void out() {
		if (First != null) {
			Edge p = First;
			while (p != null) {
				System.out.println(p.a.cost + ", " + p.b.cost + ": " + p.ts);
				p = p.next;
			}
		}

	}

	

	public boolean isExistEdge(Node a, Node b) {
		Edge p = First;
		while (p != null) {
			if (p.a == a && p.b == b || p.a == b && p.b == a)
				return true;
			p = p.next;
		}
		return false;
	}

	public void changeNum(Node a, Node b, int ts) {
		Edge p = First;
		while (p != null && !(p.a == a && p.b == b || p.a == b && p.b == a))

			p = p.next;
		if (p != null) {
			p.ts = ts;
		}
	}

	public void del_edge(Node a, Node b) {
		Edge p = First;
		Edge q;
		while (p != null && !(p.a == a && p.b == b || p.a == b && p.b == a))
			p = p.next;

		if (p != null) {

			if (p == First) {
				q = p.next;
				First = q;
			} else {
				q = First;
				while (q.next != p)
					q = q.next;
				q.next = p.next;
			}
		}
	}

	public void del_edge(Node a) {

		Edge p;
		Edge q;
		p = First;
		while (p != null) {

			if (p.a == a || p.b == a) {

				if (p == First) {
					q = p.next;
					First = q;
				} else {
					q = First;
					while (q.next != p)
						q = q.next;
					q.next = p.next;
				}
				p = First;
			} else
				p = p.next;

		}
	}
}
