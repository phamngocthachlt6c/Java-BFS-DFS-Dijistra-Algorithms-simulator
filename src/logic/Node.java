package logic;

public class Node {
	public boolean isCheck=false;
	public int cost;
	public Node NodeNext;
	public Link adj;
	public int x, y;
	
	

	Node(int d, Node next, Link l, int x, int y) {
		this.NodeNext = next;
		cost = d;
		adj = l;
		this.x = x;
		this.y = y;
		isCheck = false;
	}
}