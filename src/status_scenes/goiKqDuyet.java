package status_scenes;

public class goiKqDuyet {
	public int from;
	public int to;
	public String kqDuyet;
	public int ts;
	public goiKqDuyet next;

	public goiKqDuyet(int from, int to, String kqDuyet, int ts) {
		this.from = from;
		this.to = to;
		this.kqDuyet = kqDuyet;
		this.ts = ts;
		next = null;
	}
}
