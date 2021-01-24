package status_scenes;





public class StatusScene3 {
	public String text;
	public int r, c;
	public int edgeN = 0;
	public StatusScene3 next;
	public StatusScene3 prev;
	public kqDuyet kq;
	public int n;

	String kqDuyet;

	public StatusScene3(String text, int r, int c, int edgeN, kqDuyet kq, int nkq) {
		this.text = text;
		this.r = r;
		this.c = c;
		this.edgeN = edgeN;
		this.kqDuyet = kqDuyet;
		this.kq = kq;
		this.n=nkq;
	}

}
