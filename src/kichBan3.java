class goiKqDuyet {
	int from;
	int to;
	String kqDuyet;
	int ts;
	goiKqDuyet next;

	public goiKqDuyet(int from, int to, String kqDuyet, int ts) {
		this.from = from;
		this.to = to;
		this.kqDuyet = kqDuyet;
		this.ts = ts;
		next = null;
	}
}

class kqDuyet {
	goiKqDuyet first, end;

	public kqDuyet() {
		first = end = null;
	}

	public void insertGoiDuyet(int from, int to, String kqDuyet, int ts) {
		if (first == null) {
			first = end = new goiKqDuyet(from, to, kqDuyet, ts);
		} else {
			goiKqDuyet a = new goiKqDuyet(from, to, kqDuyet, ts);
			end.next = a;
			end = a;
		}
	}
	public void out(){
		goiKqDuyet p = first;
		while(p!=null){
			System.out.println(p.from+"-"+p.to+": "+p.kqDuyet+","+p.ts);
			p=p.next;
		}
	}
	public goiKqDuyet getGoiKqDuyet(int n){
		goiKqDuyet p = first;
		int i=0;
		while(p!=null&&i<n){
			p=p.next;
			i++;
		}
		return p;
	}
}

public class kichBan3 {
	String text;
	int r, c;
	int edgeN = 0;
	kichBan3 next;
	kichBan3 prev;
	kqDuyet kq;
	int n;

	String kqDuyet;

	public kichBan3(String text, int r, int c, int edgeN, kqDuyet kq, int nkq) {
		this.text = text;
		this.r = r;
		this.c = c;
		this.edgeN = edgeN;
		this.kqDuyet = kqDuyet;
		this.kq = kq;
		this.n=nkq;
	}

}
