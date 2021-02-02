package logic;

public class Edge {
	public Node a, b;
	public int ts;
	public Edge next;

	public Edge(Node a, Node b, int ts, Edge next) {
		this.a = a;
		this.b = b;
		this.ts = ts;
		this.next = next;
	}
}
