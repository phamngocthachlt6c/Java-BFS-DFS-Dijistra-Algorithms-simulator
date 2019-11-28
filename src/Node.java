
public class Node {
	boolean isCheck=false;
	int cost;
	Node NodeNext;
	Link adj;
	int x, y;
	
	

	Node(int d, Node next, Link l, int x, int y) {
		this.NodeNext = next;
		cost = d;
		adj = l;
		this.x = x;
		this.y = y;
		isCheck = false;
	}
}